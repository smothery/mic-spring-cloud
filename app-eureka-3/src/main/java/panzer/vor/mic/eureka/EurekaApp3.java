package panzer.vor.mic.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * 服务注册中心
 *
 * Created by luozc on 2019-09-11
 */
@SpringBootApplication
@EnableEurekaServer
@ComponentScan(basePackages = "panzer.vor.mic")
public class EurekaApp3 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApp3.class,args);
    }
}
