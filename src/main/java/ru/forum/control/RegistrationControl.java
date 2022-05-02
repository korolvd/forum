package ru.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.forum.model.User;
import ru.forum.service.UserService;

@Controller
public class RegistrationControl {

    private final UserService userService;

    public RegistrationControl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String regPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String regSave(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/login";
    }
}
