package ru.itis.services;

import org.springframework.security.core.Authentication;
import ru.itis.forms.RegisterForm;
import ru.itis.models.User;

import java.util.Optional;

public interface UserService {
    
    boolean signUp(RegisterForm registerForm);

    Optional<User> findById(Long id);

    boolean makeAFollow(User userFollower, User following);

    User getCurrentUser(Authentication authentication);
}
