package panzer.vor.mic.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 产品服务
 *
 * Created by luozc on 2019-06-23
 */
@SpringBootApplication
@ComponentScan(basePackages = "panzer.vor.mic")
@EnableDiscoveryClient
@EnableEurekaClient
public class ProductApplication3 {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication3.class, args);
    }
}
