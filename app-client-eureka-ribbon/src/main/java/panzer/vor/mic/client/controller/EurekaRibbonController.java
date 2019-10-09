package panzer.vor.mic.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by luozc on 2019-09-17
 */
@RestController
public class EurekaRibbonController {
    private String URL = "http://APP-PRODUCT/client/get";

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
        String productApplicatonName = restTemplate.exchange(URL, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), String.class).getBody();

        return applicationName + "<>" + productApplicatonName;
    }
}
