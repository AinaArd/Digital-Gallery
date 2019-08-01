package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.forms.RegisterForm;
import ru.itis.models.Role;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;
import ru.itis.security.details.UserDetailsImpl;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean signUp(RegisterForm registerForm) {
        String hashPassword = passwordEncoder.encode(registerForm.getPassword());
        User user = User.builder()
                .login(registerForm.getLogin())
                .hashPassword(hashPassword)
                .name(registerForm.getName())
                .role(Role.USER)
                .build();
        usersRepository.save(user);
        return true;
    }

    @Override
    public Optional<User> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public boolean makeAFollow(User userFollower, User following) {
        if (!userFollower.getFollowers().contains(following)) {
            userFollower.getFollowers().add(following);
            usersRepository.save(userFollower);
            return true;
        } else {
            userFollower.getFollowers().remove(findUserById(userFollower.getFollowers(),following.getId()));
            usersRepository.save(userFollower);
            return false;
        }
    }

    @Override
    public User getCurrentUser(Authentication authentication) {
        return ((UserDetailsImpl) authentication.getPrincipal()).getUser();
    }

    private User findUserById(List<User> users, Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
