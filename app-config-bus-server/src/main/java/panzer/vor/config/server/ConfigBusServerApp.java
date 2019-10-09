package panzer.vor.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * springcloud config bus server(配置中心服务端,带配置刷新功能)
 *
 * 测试需启动:
 *    app-eureka(一个或集群)
 *
 *
 * 集群部署:
 *    注入业务的eureka集群或者单独部署配置中心的eureka集群(因为其他业务的eureka集群可能需要从配置中心获取配置)
 *
 * 配置更改后，需要手动调用config server的刷新接口
 * post http://bus_config_server:port/actuator/bus-refresh
 *
 * Created by luozc on 2019-10-08
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigBusServerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigBusServerApp.class, args);
    }
}
