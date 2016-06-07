package whitechapel.devices;

import org.springframework.data.repository.CrudRepository;
import whitechapel.users.User;

import java.util.List;

/**
 * Created by sewl on 6/6/16.
 */
public interface DeviceRepository extends CrudRepository<Device, Long> {

    List<Device> findByUser(User user);

    List<Device> findAll();
}
