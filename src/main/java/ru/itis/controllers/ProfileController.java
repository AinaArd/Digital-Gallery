package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.models.User;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.UserService;
import ru.itis.transfer.UserDto;

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
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        UserDto user = from(details.getUser());
        User currentUser = userService.getCurrentUser(authentication);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/profile/{user-id}")
    public String getOtherUserPage(@PathVariable(name = "user-id") Long userId, ModelMap model, Authentication authentication) {
        User otherUser = userService.findById(userId).orElseThrow(IllegalArgumentException::new);
        User currentUser = userService.getCurrentUser(authentication);
        if (currentUser.getFollowings().contains(otherUser)) {
            model.addAttribute("followed", true);
        }
        model.addAttribute("user", otherUser);
        model.addAttribute("otherUser", true);
        return "profile";
    }
}
