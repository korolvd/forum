package ru.forum.store;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.forum.model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
}
