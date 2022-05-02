package ru.forum.service;

import org.springframework.stereotype.Service;
import ru.forum.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public UserService() {
        users.add(User.of("user"));
    }

    public List<User> getUsers() {
        return users;
    }

    public void save(User user) {
        users.add(user);
    }
}
