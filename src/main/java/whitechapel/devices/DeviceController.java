package whitechapel.devices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import whitechapel.users.UsersService;

import java.util.List;

/**
 * Created by sewl on 6/6/16.
 */
@RestController
@RequestMapping("/api/v1/devices")
public class DeviceController {

    @Autowired
    private DevicesService deviceService;

    @Autowired
    private UsersService usersService;

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public Device register(@RequestBody Device device) {
        return deviceService.createDeviceForUser(usersService.user(), device.getInstanceId(), device.getToken());
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Device> all() {
        return deviceService.all(usersService.user());
    }
}
