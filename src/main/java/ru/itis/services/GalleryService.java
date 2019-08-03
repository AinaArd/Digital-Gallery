package ru.itis.services;

import ru.itis.models.Gallery;
import ru.itis.models.User;

import java.util.Optional;

public interface GalleryService {
    Gallery addGallery(Gallery gallery);

    Optional<Gallery> findGalleryById(Long id);

    boolean checkIfOwner(User currentUser);

    void addEditor(Gallery gallery, User editor);
}
