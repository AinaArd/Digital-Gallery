package ru.itis.services;

import ru.itis.models.Gallery;

import java.util.Optional;

public interface GalleryService {
    Gallery addGallery(Gallery gallery);

    Optional<Gallery> findGalleryById(Long id);
}
