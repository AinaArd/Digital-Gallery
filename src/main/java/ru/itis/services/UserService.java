package ru.itis.services;

import ru.itis.forms.RegisterForm;

public interface UserService {
    boolean signUp(RegisterForm registerForm);
}
