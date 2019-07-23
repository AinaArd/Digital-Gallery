package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.itis.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
