package ru.forum.service;

import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Service;
import ru.forum.model.User;
import ru.forum.store.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository store;

    public UserService(UserRepository store) {
        this.store = store;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        store.findAll().forEach(users::add);
        return users;
    }

    public User save(User user) {
        User rsl = null;
        try {
            user = store.save(user);
        } catch (Exception e) {
            return null;
        }
        return user;
    }
}
