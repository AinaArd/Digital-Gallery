package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.forms.GalleryForm;
import ru.itis.models.Gallery;
import ru.itis.models.User;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.GalleryService;

@Controller
public class PortfolioController {

    @Autowired
    private GalleryService galleryService;

    @GetMapping("/portfolio")
    public String getPortfolioPage(ModelMap model, Authentication authentication) {
        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        model.addAttribute("user", currentUser);
        return "portfolio";
    }

    @PostMapping("/portfolio")
    public String addGallery(ModelMap model, GalleryForm galleryForm, Authentication authentication) {
        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        Gallery gallery = Gallery.builder()
                .name(galleryForm.getName())
                .owner(currentUser)
                .build();
        currentUser.getOwnGalleries().add(gallery);
        Gallery newGallery = galleryService.addGallery(gallery);
        return "redirect:portfolio";
    }
}
