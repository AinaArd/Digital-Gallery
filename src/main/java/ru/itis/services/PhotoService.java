package ru.itis.services;

import ru.itis.forms.PhotoForm;
import ru.itis.models.Gallery;
import ru.itis.models.Photo;

public interface PhotoService {
    Photo addPhoto(PhotoForm photoForm, Gallery gallery);
}
