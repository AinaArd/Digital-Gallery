package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Gallery;
import ru.itis.models.User;
import ru.itis.repositories.GalleryRepository;
import ru.itis.repositories.UsersRepository;

import java.util.Optional;

@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Gallery addGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    @Override
    public Optional<Gallery> findGalleryById(Long id) {
        return galleryRepository.findById(id);
    }

    @Override
    public boolean checkIfOwner(User currentUser) {
        return usersRepository.checkIfOwner(currentUser.getId()).isPresent();
    }
}
