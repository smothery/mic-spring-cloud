package panzer.vor.mic.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * feign客户端(其实底层是eureka+ribbon,只是用接口方法简化了ribbon具体调用)
 *
 * FeignController 普通feign客户端，只能调一种服务
 *
 * FeignZuulController feign+zuul 客户端，可以调多种服务，具体看app-zuul-gateway路由规则
 *
 * 测试需启动:
 *    app-eureka(一个或集群)
 *    app-product(一个或多个)
 *    app-zuul-gateway(注释掉zuul相关测试时可以不启动)
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "panzer.vor.mic")
@EnableFeignClients(basePackages = "panzer.vor.mic.feign")
public class FeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }
}
