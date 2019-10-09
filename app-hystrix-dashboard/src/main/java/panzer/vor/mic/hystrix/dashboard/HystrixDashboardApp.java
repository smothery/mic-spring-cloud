package panzer.vor.mic.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 熔断器仪表板
 *
 * 仪表板页面 http://hystrix-dashboard-app-host:port/hystrix
 *
 * 监控单个hystrix app 仪表板页面输入:http://hystrin-app-host:port/actuator/hystrix.stream
 *
 * 利用turbine监控服务集群 仪表板页面输入:http://turbine-app-host:port/turbine.stream
 *
 * 测试需启动:
 *    app-eureka(一个或集群)
 *    集成熔断器的服务:
 *          app-order-hystrix
 *          app-product-hystrix
 *
 * Created by luozc on 2019-09-29
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApp {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApp.class, args);
    }
}
