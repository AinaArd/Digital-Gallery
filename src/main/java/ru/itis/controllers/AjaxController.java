package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.models.Comment;
import ru.itis.models.Gallery;
import ru.itis.models.Photo;
import ru.itis.models.User;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.CommentService;
import ru.itis.services.GalleryService;
import ru.itis.services.PhotoService;
import ru.itis.services.UserService;
import ru.itis.transfer.FollowDto;
import ru.itis.transfer.UserCommentDto;
import ru.itis.transfer.UserDto;

import javax.xml.ws.Response;
import java.util.List;

import static ru.itis.transfer.UserCommentDto.from;

@RestController
public class AjaxController {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private GalleryService galleryService;

    @PostMapping("/ajax/like")
    public ResponseEntity<Object> like(@RequestParam(name = "id") Long photoId) {
        photoService.increaseLikes(photoId);
        return ResponseEntity.ok(photoId);
    }

    @PostMapping("/ajax/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "id") Long id) {
        Photo photo = photoService.findPhotoById(id).orElseThrow(IllegalArgumentException::new);
        Gallery gallery = photo.getGallery();
        gallery.getPhotos().remove(photo);
        photoService.deletePhoto(photo);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/ajax/addComment")
    public ResponseEntity<Object> addComment(@RequestParam(name = "id") Long photoId, @RequestParam(name = "comment") String message,
                                             Authentication authentication) {
        Photo photo = photoService.findPhotoById(photoId).orElseThrow(IllegalArgumentException::new);
        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        Comment comment = Comment.builder()
                .photo(photo)
                .content(message)
                .author(currentUser)
                .build();
        Comment savedComment = commentService.addComment(comment);
        UserCommentDto dto = from(currentUser, savedComment);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/ajax/followUser")
    public ResponseEntity<Object> followUser(@RequestParam(name = "follower") Long followerId, Authentication authentication) {
        User currentUser = userService.getCurrentUser(authentication);
        User userToFollow = userService.findById(followerId).orElseThrow(IllegalArgumentException::new);
        userService.makeAFollow(currentUser, userToFollow);
        FollowDto dto = FollowDto.from(userToFollow);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/ajax/addParticipant")
    public ResponseEntity<Object> addParticipant(@RequestParam(name = "userName") String userName, @RequestParam(name = "galleryId")
            Long galleryId) {
        User editor = userService.findByName(userName).orElseThrow(IllegalArgumentException::new);
        Gallery gallery = galleryService.findGalleryById(galleryId).orElseThrow(IllegalArgumentException::new);
        galleryService.addEditor(gallery, editor);
        userService.addGallery(editor, gallery);
        User newEditor = userService.save(editor);
        return ResponseEntity.ok(newEditor);
    }

    @PostMapping("/ajax/inviteUsersToGallery")
    public ResponseEntity<Object> inviteUsers(@RequestParam(name = "search") String search, Authentication authentication) {
        User currentUser = userService.getCurrentUser(authentication);
        List<UserDto> userCandidates = userService.findByNameOrLogin(search, currentUser);
        return ResponseEntity.ok(userCandidates);
    }

    @PostMapping("/ajax/unfollowUser")
    public ResponseEntity<Object> unfollowUser(@RequestParam(name = "followingId") Long followingId, Authentication authentication) {
        User userToUnfollow = userService.findById(followingId).orElseThrow(IllegalArgumentException::new);
        User currentUser = userService.getCurrentUser(authentication);
        userService.makeUnfollow(currentUser, userToUnfollow);
        return ResponseEntity.ok().build();
    }
}

//TODO: fix unfollow and make search