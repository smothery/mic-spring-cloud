package panzer.vor.mic.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springcloud config client(配置中心客户端)
 *
 * 测试需启动:
 *    app-eureka(一个或集群)
 *    app-config-server(一个或集群)
 *
 *
 * Created by luozc on 2019-10-08
 */
@SpringBootApplication
public class ConfigClientApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApp.class, args);
    }
}
