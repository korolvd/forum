package ru.forum.store;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.forum.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
