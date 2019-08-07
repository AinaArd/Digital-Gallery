package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.forms.RegisterForm;
import ru.itis.models.Gallery;
import ru.itis.models.Role;
import ru.itis.models.User;
import ru.itis.repositories.GalleryRepository;
import ru.itis.repositories.UsersRepository;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.transfer.UserDto;
import ru.itis.utils.FileDownloader;

import java.util.List;
import java.util.Optional;

import static ru.itis.transfer.UserDto.from;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private GalleryRepository galleryRepository;

    @Autowired
    private FileDownloader fileDownloader;

    @Override
    public boolean signUp(RegisterForm registerForm) {
        String hashPassword = passwordEncoder.encode(registerForm.getPassword());
        User user = User.builder()
                .login(registerForm.getLogin())
                .hashPassword(hashPassword)
                .name(registerForm.getName())
                .role(Role.USER)
                .build();
        usersRepository.save(user);
        return true;
    }

    @Override
    public Optional<User> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public User getCurrentUser(Authentication authentication) {
        return ((UserDetailsImpl) authentication.getPrincipal()).getUser();
    }

    @Override
    public List<UserDto> findByNameOrLogin(String input, User user) {
        List<UserDto> users;
        UserDto currentUser = from(user);
        users = usersRepository.findByNameContaining(input);
        users.remove(currentUser);
        return users;
    }

    @Override
    public Optional<User> findByName(String name) {
        return usersRepository.findByName(name);
    }

    @Override
    public void addGallery(User editor, Gallery gallery) {
        if (!editor.getGalleries().contains(gallery)) {
            editor.getGalleries().add(gallery);
        } else {
            editor.getGalleries().remove(gallery);
        }
    }

    @Override
    public User save(User user) {
        return usersRepository.save(user);
    }

    @Override
    public boolean checkTheRights(User currentUser, Gallery currentGallery) {
        //            this user is the editor of this gallery of the owner
        if (currentGallery.getEditors().contains(currentUser)) {
            return true;
        } else return checkIfOwner(currentUser, currentGallery);
    }

    @Override
    public void makeUnfollow(User currentUser, User userToUnfollow) {
        currentUser.getFollowings().remove(userToUnfollow);
        usersRepository.save(currentUser);
    }

    @Override
    public void changePicture(MultipartFile file, User currentUser) {
        String photoPath = fileDownloader.upload(file, currentUser.getName()).orElseThrow(IllegalArgumentException::new);
        currentUser.setPicturePath(photoPath);
        usersRepository.save(currentUser);

    }

    @Override
    public boolean makeAFollow(User userFollower, User following) {
        if (!userFollower.getFollowings().contains(following)) {
            userFollower.getFollowings().add(following);
            usersRepository.save(userFollower);
            return true;
        } else if (userFollower.getFollowings().contains(following)) {
//            TODO: fix remove()
            userFollower.getFollowings().remove(findUserById(userFollower.getFollowings(), following.getId()));
            usersRepository.save(userFollower);
            return false;
        }
        return false;
    }

    private boolean checkIfOwner(User currentUser, Gallery currentGallery) {
        Long ownerId = galleryRepository.getOwner(currentGallery.getId());
        return currentUser.getId().equals(ownerId);
    }

    private User findUserById(List<User> users, Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
