package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Comment;

import ru.itis.repositories.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
