package whitechapel.login;

import org.springframework.stereotype.Service;

/**
 * Created by sewl on 6/5/16.
 */
@Service
public class LoginService {

    public User authenticate() {
        return new User("Bruce", "Wayne");
    }
}
