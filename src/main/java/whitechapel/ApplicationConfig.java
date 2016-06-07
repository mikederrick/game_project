package whitechapel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sewl on 6/6/16.
 */
@Configuration
@EnableJpaRepositories
public class ApplicationConfig {

    @Bean
    protected RestOperations restTemplate() {
        return new RestTemplate();
    }
}
