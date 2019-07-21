package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Gallery;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
}
