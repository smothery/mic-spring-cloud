package panzer.vor.mic.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springcloud config bus client(配置中心客户端，带配置刷新功能)
 *
 * 测试需启动:
 *    app-eureka(一个或集群)
 *    app-config-bus-server(一个或集群)
 *
 *
 * Created by luozc on 2019-10-08
 */
@SpringBootApplication
public class BusConfigClientApp {
    public static void main(String[] args) {
        SpringApplication.run(BusConfigClientApp.class, args);
    }
}
