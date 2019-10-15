package panzer.vor.mic.sleuth.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;

/**
 * zipkin server 官方不推荐自行搭建。也可以去下载官方的
 *
 * 测试需启动：
 *  app-eureka(一个或集群)
 *
 * 集成zipkin的服务，测试可选择启动
 *  app-client-feign
 *  app-product-hystrix
 *  app-order-hystrix
 *  app-zuul-gateway
 *
 * Created by luozc on 2019-10-11
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinApp {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinApp.class, args);
    }
}
