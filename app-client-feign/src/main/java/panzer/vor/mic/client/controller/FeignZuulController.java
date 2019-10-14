package panzer.vor.mic.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import panzer.vor.mic.feign.service.IZuulSercice;

/**
 * Created by luozc on 2019-09-17
 */
@RestController
public class FeignZuulController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private IZuulSercice iZuulSercice;
    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/zuul/client/info")
    public Object info() {
        return discoveryClient;
    }

    @GetMapping("/product/get")
    public String getProductClient() {
        return applicationName + "<>" + iZuulSercice.getProductClient();
    }

    @GetMapping("/order/get")
    public String getOrderClient() {
        return applicationName + "<>" + iZuulSercice.getOrderClient();
    }

    @GetMapping("/orderAndProduct/get")
    public String getOrderAndProduct() {
        return applicationName + "<>" + iZuulSercice.getOrderClient()
                + "\n\n"
                + applicationName + "<>" + iZuulSercice.getProductClient();
    }
}
