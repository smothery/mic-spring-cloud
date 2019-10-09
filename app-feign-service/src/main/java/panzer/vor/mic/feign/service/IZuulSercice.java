package panzer.vor.mic.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import panzer.vor.mic.feign.config.FeignConfig;
import panzer.vor.mic.feign.service.fallback.IZuulServiceFallbackFactory;

/**
 * Created by luozc on 2019-09-30
 */
@FeignClient(name = "APP-ZUUL-GATEWAY", configuration = FeignConfig.class, fallbackFactory = IZuulServiceFallbackFactory.class)
public interface IZuulSercice {
    @GetMapping("/product-proxy/client/get")
    String getProductClient();

    @GetMapping("/order-proxy/client/get")
    String getOrderClient();
}
