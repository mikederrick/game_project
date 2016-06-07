package whitechapel.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;
import whitechapel.devices.Device;
import whitechapel.devices.DevicesService;
import whitechapel.users.User;

import java.util.List;

/**
 * Created by sewl on 6/5/16.
 */
@Configuration
@PropertySource("classpath:notifications.properties")
@Component
public class NotificationsAdapter {

    @Autowired
    private Environment env;

    @Autowired
    private RestOperations restTemplate;

    @Autowired
    private DevicesService devicesService;

    public void updateForUser(User user) {
        List<Device> devices = devicesService.all(user);
        for(Device d : devices) {
            NotificationRequest request = new NotificationRequest(d.getToken());
            restTemplate.postForEntity(env.getProperty("notifications.url"),
                    new HttpEntity<>(request, getHeadersForRequest()),
                    NotificationResponse.class);
        }
    }

    private MultiValueMap<String, String> getHeadersForRequest() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", new StringBuilder().append("key=")
                .append("AIzaSyAeAl4RytBhPuwAop24T2H9Zj5bC1bT-IA")
                .toString());
        return headers;
    }
}
