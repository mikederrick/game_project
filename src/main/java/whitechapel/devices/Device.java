package whitechapel.devices;

import com.fasterxml.jackson.annotation.JsonIgnore;
import whitechapel.users.User;

import javax.persistence.*;

/**
 * Created by sewl on 6/6/16.
 */
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @JsonIgnore
    @ManyToOne
    private User user;

    private String token;

    private String instanceId;

    public Device() {}

    public Device(User user, String token, String instanceId) {
        this.token = token;
        this.instanceId = instanceId;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
