package panzer.vor.mic.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import panzer.vor.mic.feign.config.FeignConfig;
import panzer.vor.mic.feign.service.fallback.IProductServiceFallbackFactory;

/**
 * Created by luozc on 2019-09-26
 */
@FeignClient(name = "APP-PRODUCT", configuration = FeignConfig.class, fallbackFactory = IProductServiceFallbackFactory.class)
public interface IProductService {
    @GetMapping("/client/get")
    String getClient();
}
