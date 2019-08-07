package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.models.User;
import ru.itis.services.UserService;

@Controller
public class FollowingsController {

    @Autowired
    public UserService userService;

    @GetMapping("/followings")
    public String getFollowingsPage(ModelMap model, Authentication authentication){
        User currentUser = userService.getCurrentUser(authentication);
        model.addAttribute("user", currentUser);
        return "followings";
    }
}
