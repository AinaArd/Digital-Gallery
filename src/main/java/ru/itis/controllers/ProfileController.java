package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.forms.EditForm;
import ru.itis.models.User;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.UserService;
import ru.itis.transfer.UserDto;

import javax.xml.ws.RespectBinding;

import static ru.itis.transfer.UserDto.from;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String getUserPage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:login";
        }
        User currentUser = userService.getCurrentUser(authentication);
        UserDto user = from(currentUser);
        String picture = user.getPicturePath();

        model.addAttribute("picture", picture);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/profile/{user-id}")
    public String getOtherUserPage(@PathVariable(name = "user-id") Long userId, ModelMap model, Authentication authentication) {
        User otherUser = userService.findById(userId).orElseThrow(IllegalArgumentException::new);
        User currentUser = userService.getCurrentUser(authentication);
        if (currentUser.getFollowings().contains(otherUser)) {
            System.out.println("followed");
            model.addAttribute("followed", true);
        } else {
            System.out.println("not followed");
            model.addAttribute("notfollowed", true);
        }
        model.addAttribute("user", otherUser);
        model.addAttribute("otherUser", true);
        return "profile";
    }

    @PostMapping(value = "/profile", params = "description")
    public String addDescription(EditForm editForm, Authentication authentication) {
        User currentUser = userService.getCurrentUser(authentication);
        currentUser.setDescription(editForm.getDescription());
        userService.save(currentUser);
        return "redirect:profile";
    }

    @PostMapping(value = "/profile", params = "photo")
    public String changePhoto(EditForm editForm, Authentication authentication) {
        User currentUser = userService.getCurrentUser(authentication);
        userService.changePicture(editForm.getPhoto(), currentUser);
        userService.save(currentUser);
        return "redirect:profile";
    }
}
