package panzer.vor.mic.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 脱离eureka使用ribbon
 *
 * 测试需启动:
 *    app-product(一个或多个)
 *
 * Created by luozc on 2019-06-23
 */
@SpringBootApplication
@ComponentScan(basePackages = "panzer.vor.mic")
public class RibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }
}
