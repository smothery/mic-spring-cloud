package panzer.vor.mic.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import panzer.vor.mic.client.config.RefreshInfoConfig;

/**
 * Created by luozc on 2019-10-08
 */
@RestController
public class BusConfigClientController {
    // @Value("${spring.cloud.config.profile}")
    // private String profile;
    // @Value("${spring.application.name}")
    // private String applicationName;
    // @Value("${server.port}")
    // private String serverPort;

    @Autowired
    private RefreshInfoConfig refreshInfoConfig;

    @GetMapping("/client/get")
    public String getClient() {

        return refreshInfoConfig.getApplicationName() + "<>" + refreshInfoConfig.getProfile() + "<>" + refreshInfoConfig.getServerPort();
    }
}
