package ru.forum.service;

import org.springframework.stereotype.Service;
import ru.forum.model.Post;
import ru.forum.store.PostRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class PostService {

    private final PostRepository store;

    public PostService(PostRepository posts) {
        this.store = posts;
    }


    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        store.findAll().forEach(posts::add);
        return posts;
    }

    public Post findById(int id) {
        return store.findById(id).get();
    }

    public void save(Post post) {
        if (post.getCreated() == null) {
            post.setCreated(Calendar.getInstance());
        }
        store.save(post);
    }
}
