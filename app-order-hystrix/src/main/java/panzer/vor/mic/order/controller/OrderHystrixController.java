package panzer.vor.mic.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by luozc on 2019-09-17
 */
@RestController
public class OrderHystrixController {
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
    @HystrixCommand(fallbackMethod = "getClientFallback")
    public String getClient() {
        String result = String.format("%s:%s", applicationName, serverPort);
        if (new Random().nextInt(10) % 2 == 0) throw new RuntimeException("bao cuo la!");
        return result;
    }

    /**
     * 提供方内部发生错误时，调用备用方法(服务降级)
     *
     * fallback方法，参数要跟原方法一致
     * @return
     */
    private String getClientFallback(){
        return String.format("%s:%s<>%s", applicationName, serverPort,"hystrix fallback");
    }
}
