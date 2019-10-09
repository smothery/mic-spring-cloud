package panzer.vor.mic.client.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by luozc on 2019-10-09
 */
@Component
@RefreshScope
@Data
public class RefreshInfoConfig {
    @Value("${spring.cloud.config.profile}")
    private String profile;
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private String serverPort;
}
