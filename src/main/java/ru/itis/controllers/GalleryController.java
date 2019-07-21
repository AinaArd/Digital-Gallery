package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.forms.PhotoForm;
import ru.itis.models.Gallery;
import ru.itis.models.Photo;
import ru.itis.services.GalleryService;
import ru.itis.services.PhotoService;

@Controller
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    @Autowired
    private PhotoService photoService;

    @GetMapping("/gallery/{gallery-id}")
    public String getOneGalleryPage(ModelMap model, @PathVariable(name = "gallery-id") Long id) {
        Gallery gallery = galleryService.findGalleryById(id).orElseThrow(IllegalArgumentException::new);
        model.addAttribute("gallery", gallery);
        return "gallery";
    }

    @PostMapping("/gallery/{gallery-id}")
    public String addPhoto(@PathVariable(name = "gallery-id") Long id, PhotoForm photoForm) {
        Gallery gallery = galleryService.findGalleryById(id).orElseThrow(IllegalArgumentException::new);
        photoService.addPhoto(photoForm, gallery);
        return "redirect:{gallery-id}";
    }
}
