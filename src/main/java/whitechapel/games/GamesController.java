package whitechapel.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import whitechapel.users.UsersService;
import whitechapel.notifications.NotificationsAdapter;

/**
 * Created by sewl on 6/5/16.
 */
@RestController
@RequestMapping("/api/v1/games")
public class GamesController {

    @Autowired
    private NotificationsAdapter notificationsAdapter;

    @Autowired
    private UsersService usersService;

    @RequestMapping(method = RequestMethod.POST)
    private void startGame() {
        notificationsAdapter.updateForUser(usersService.user());
    }
}
