package panzer.vor.mic.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 统一服务熔断器管理组件
 *
 * 触发hystrix fallback后（用消费者或直接调用已集成hystrix的服务提供方接口触发）
 * 在hystrixdashboard 监控面板输入http://localhost:9094/turbine.stream
 *
 * 测试需启动:
 *    app-eureka(一个或集群)
 *    app-hystrix-dashboard
 *    集成熔断器的服务(一个或多个，多个可看到统一管理效果):
 *          app-order-hystrix
 *          app-product-hystrix
 *
 * Created by luozc on 2019-09-29
 */
@SpringBootApplication
@EnableTurbine
public class TurbineApp {
    public static void main(String[] args) {
        SpringApplication.run(TurbineApp.class, args);
    }
}
