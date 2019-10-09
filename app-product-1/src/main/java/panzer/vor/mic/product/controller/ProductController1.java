package panzer.vor.mic.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luozc on 2019-09-17
 */
@RestController
public class ProductController1 {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/client/info")
    public Object info() {
        return discoveryClient;
    }

    @GetMapping("/client/get")
    public String getClient() {
        return String.format("%s:%s", applicationName, serverPort);
    }
}
