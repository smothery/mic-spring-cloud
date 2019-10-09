package panzer.vor.mic.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 带hystrix订单服务
 *
 * 测试需启动:
 *    app-eureka(一个或集群)
 *
 * Created by luozc on 2019-06-23
 */
@SpringBootApplication
@ComponentScan(basePackages = "panzer.vor.mic")
@EnableDiscoveryClient
@EnableEurekaClient
@EnableCircuitBreaker
public class OrderHystrixApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixApp.class, args);
    }
}
