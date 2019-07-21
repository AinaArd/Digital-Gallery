package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.forms.PhotoForm;
import ru.itis.models.Gallery;
import ru.itis.models.Photo;
import ru.itis.repositories.PhotoRepository;
import ru.itis.utils.FileDownloader;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private FileDownloader fileDownloader;

    @Override
    public Photo addPhoto(PhotoForm photoForm, Gallery gallery) {
        String photoPath = fileDownloader.upload(photoForm.getFile(), photoForm.getName()).orElseThrow(IllegalArgumentException::new);
        Photo photo = Photo.builder()
                .name(photoForm.getName())
                .description(photoForm.getDescription())
                .photoPath(photoPath)
                .gallery(gallery)
                .build();
        return photoRepository.save(photo);
    }
}
