package ru.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.forum.model.User;
import ru.forum.service.AuthorityService;
import ru.forum.service.UserService;

@Controller
public class RegistrationControl {

    private final UserService userService;
    private final PasswordEncoder encoder;
    private final AuthorityService authorityService;

    public RegistrationControl(UserService userService, PasswordEncoder encoder, AuthorityService authorityService) {
        this.userService = userService;
        this.encoder = encoder;
        this.authorityService = authorityService;
    }

    @GetMapping("/registration")
    public String regPage(Model model,
                          @RequestParam(name = "fail", required = false) Boolean fail) {
        if (fail != null) {
            model.addAttribute("errMessage", "Пользователь с такой почтой уже существует");
        }
        model.addAttribute("fail", fail != null);
        return "registration";
    }

    @PostMapping("/registration")
    public String regSave(Model model, @ModelAttribute User user) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorityService.findByAuthority("ROLE_USER"));
        User rsl = userService.save(user);
        if (rsl == null) {
            return "redirect:/registration?fail=true";
        }
        return "redirect:/login";
    }
}
