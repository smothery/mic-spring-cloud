package panzer.vor.mic.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import panzer.vor.mic.feign.service.IProductService;

/**
 * Created by luozc on 2019-09-17
 */
@RestController
public class FeignController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private IProductService iProductService;
    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/client/info")
    public Object info() {
        return discoveryClient;
    }

    @GetMapping("/client/get")
    public String getClient() {
        return applicationName + "<>" + iProductService.getClient();
    }
}
