package ru.itis.services;

import org.springframework.security.core.Authentication;
import ru.itis.forms.RegisterForm;
import ru.itis.models.Gallery;
import ru.itis.models.User;
import ru.itis.transfer.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    
    boolean signUp(RegisterForm registerForm);

    Optional<User> findById(Long id);

    boolean makeAFollow(User userFollower, User following);

    User getCurrentUser(Authentication authentication);

    List<UserDto> findByNameOrLogin(String search, User currentUser);

    Optional<User> findByName(String name);

    void addGallery(User editor, Gallery gallery);

    User save(User user);

    boolean checkTheRights(User currentUser, Gallery currentGallery);
}
