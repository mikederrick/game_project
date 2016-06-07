package whitechapel.users;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sewl on 6/6/16.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
}
