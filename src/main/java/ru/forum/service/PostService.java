package ru.forum.service;

import org.springframework.stereotype.Service;
import ru.forum.model.Post;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final AtomicInteger ids = new AtomicInteger(0);


    public Collection<Post> getAll() {
        return posts.values();
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(ids.incrementAndGet());
            post.setCreated(LocalDateTime.now());
            posts.put(post.getId(), post);
        } else {
            posts.replace(post.getId(), post);
        }
    }
}
