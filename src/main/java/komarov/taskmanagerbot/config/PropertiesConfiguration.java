package komarov.taskmanagerbot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:token.yml")
public class PropertiesConfiguration {
}
