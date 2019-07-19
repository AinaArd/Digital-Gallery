package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import ru.itis.forms.RegisterForm;
import ru.itis.services.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class RegisterController {

    private final UserService service;

    @Autowired
    public RegisterController(UserService service) {
        this.service = service;
    }

    @PostMapping("/signUp")
    public String register(ModelMap model, RegisterForm registerForm) {
        service.signUp(registerForm);
        return "redirect:/login";
    }

    @GetMapping("/signUp")
    public String showPage() {
        return "signUp";
    }
}
