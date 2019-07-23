package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.models.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update photo set likes = likes+1 where id = ?")
    void increaseLikes(Long id);
}
