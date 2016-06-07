package whitechapel.devices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whitechapel.users.User;

import java.util.List;

/**
 * Created by sewl on 6/6/16.
 */
@Service
public class DevicesService {

    @Autowired
    private DeviceRepository deviceRepository;

    public Device createDeviceForUser(User user, String instanceId, String token) {
        List<Device> devices = deviceRepository.findByUser(user);
        for (Device d : devices) {
            if(d.getInstanceId() != null &&
               d.getInstanceId().equals(instanceId)) {

                d.setToken(token);
                deviceRepository.save(d);
                return d;
            }
        }
        return createDevice(user, instanceId, token);
    }

    private Device createDevice(User user, String instanceId, String token) {
        Device device;
        device = new Device(user, token, instanceId);
        deviceRepository.save(device);
        return device;
    }

    public List<Device> all(User user) {
        return deviceRepository.findByUser(user);
    }
}
