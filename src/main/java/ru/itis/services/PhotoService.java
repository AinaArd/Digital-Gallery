package ru.itis.services;

import ru.itis.forms.PhotoForm;
import ru.itis.models.Gallery;
import ru.itis.models.Photo;

import java.util.Optional;

public interface PhotoService {
    Photo addPhoto(PhotoForm photoForm, Gallery gallery);

    Optional<Photo> findPhotoById(Long photoId);

    void increaseLikes(Long photoId);

    void deletePhoto(Photo photo);
}
