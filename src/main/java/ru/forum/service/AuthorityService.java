package ru.forum.service;

import org.springframework.stereotype.Service;
import ru.forum.model.Authority;
import ru.forum.store.AuthorityRepository;

@Service
public class AuthorityService {
    private final AuthorityRepository store;

    public AuthorityService(AuthorityRepository store) {
        this.store = store;
    }

    public Authority findByAuthority(String authority) {
        return store.findByAuthority(authority);
    }
}
