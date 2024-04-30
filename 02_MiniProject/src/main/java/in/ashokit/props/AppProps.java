package in.ashokit.props;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
@Configuration
@Data
@ConfigurationProperties(prefix = "app")
@EnableConfigurationProperties
public class AppProps {
private Map<String, String>messages = new HashMap<>();
}
