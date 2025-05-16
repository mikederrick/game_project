package whitechapel.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sewl on 6/5/16.
 */
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(method = RequestMethod.POST)
    public User login() {
        // TODO: Create session
        return usersService.authenticate();
    }
}
