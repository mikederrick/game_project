package whitechapel.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sewl on 6/5/16.
 */
@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public User authenticate() {
        //TODO: Authenticate with cookie (after oauth authentication)
        return user();
    }

    public User user() {
        User user = null;
        List<User> users = userRepository.findAll();
        if(users.size() == 0) {
            user = userRepository.save(new User("Bruce", "Wayne"));
            userRepository.save(user);
        } else {
            user = users.get(0);
        }
        return user;
    }
}
