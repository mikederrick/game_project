package whitechapel.users;


import com.fasterxml.jackson.annotation.JsonIgnore;
import whitechapel.devices.Device;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sewl on 6/5/16.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String firstName;

    private String lastName;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Device> devices;

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addDevice(Device device) {
        device.setUser(this);
        System.out.println("devices: " + devices.size());
        this.devices.add(device);
    }

    public long getId() {
        return id;
    }

    public List<Device> getDevices() {
        return devices;
    }
}
