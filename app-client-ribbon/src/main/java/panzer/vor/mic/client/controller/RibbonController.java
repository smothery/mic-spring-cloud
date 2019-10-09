package panzer.vor.mic.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by luozc on 2019-09-17
 */
@RestController
public class RibbonController {
    private String PRODUCT_TOPIC = "APP-PRODUCT";

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Value("${spring.application.name}")
    private String applicationName;
    @Autowired
    private HttpHeaders httpHeaders;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/client/info")
    public Object info() {
        return discoveryClient;
    }

    @GetMapping("/client/get")
    public String getClient() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose(PRODUCT_TOPIC);
        System.out.println(
                "【*** ServiceInstance ***】host = " + serviceInstance.getHost()
                        + "、port = " + serviceInstance.getPort()
                        + "、serviceId = " + serviceInstance.getServiceId());

        URI uri = URI.create(String.format("http://%s:%s/client/get/",
                serviceInstance.getHost(), serviceInstance.getPort()));

        String productApplicatonName = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), String.class).getBody();

        return applicationName + "<>" + productApplicatonName;
    }
}
