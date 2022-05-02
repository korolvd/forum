package ru.forum.store;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.forum.model.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
    Authority findByAuthority(String authority);
}
