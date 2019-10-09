package panzer.vor.mic.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 基于eureka 使用ribbon客户端
 *
 * 测试需启动:
 *    app-eureka(一个或集群)
 *    app-product(产品服务,一个或多个)
 * Created by luozc on 2019-06-23
 */
@SpringBootApplication
@ComponentScan(basePackages = "panzer.vor.mic")
@EnableDiscoveryClient
@EnableEurekaClient
public class EurekaRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaRibbonApplication.class, args);
    }
}
