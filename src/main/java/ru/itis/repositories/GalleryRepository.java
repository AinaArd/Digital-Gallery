package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.models.Gallery;

import java.util.Optional;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {

    @Query(nativeQuery = true, value = "select owner_id from gallery where id = ?;")
    Long getOwner(Long galleryId);

}
