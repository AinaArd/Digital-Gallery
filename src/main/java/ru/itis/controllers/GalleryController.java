package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.forms.PhotoForm;
import ru.itis.models.Gallery;
import ru.itis.models.User;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.GalleryService;
import ru.itis.services.PhotoService;
import ru.itis.services.UserService;

@Controller
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private UserService userService;

    @GetMapping("/gallery/{gallery-id}")
    public String getOneGalleryPage(ModelMap model, @PathVariable(name = "gallery-id") Long id, Authentication authentication) {
        Gallery gallery = galleryService.findGalleryById(id).orElseThrow(IllegalArgumentException::new);
        model.addAttribute("gallery", gallery);
        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();

        if (userService.checkTheRights(currentUser, gallery)) {
            model.addAttribute("user", currentUser);
        } else {
//            TODO: do not give rights
            System.out.println("goodbye");
        }
        return "gallery";
    }

    @PostMapping("/gallery/{gallery-id}")
    public String addPhoto(@PathVariable(name = "gallery-id") Long id, PhotoForm photoForm) {
        Gallery gallery = galleryService.findGalleryById(id).orElseThrow(IllegalArgumentException::new);
        photoService.addPhoto(photoForm, gallery);
        return "redirect:{gallery-id}";
    }

//    @PostMapping("/gallery/{gallery-id}")
//    public String giveAccess(Authentication authentication, ModelMap model, @PathVariable(name = "gallery-id") Long id) {
//        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
//
//        return "redirect:{gallery-id}";
//    }
}

