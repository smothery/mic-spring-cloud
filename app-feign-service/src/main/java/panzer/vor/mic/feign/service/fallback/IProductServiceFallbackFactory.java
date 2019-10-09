package panzer.vor.mic.feign.service.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import panzer.vor.mic.feign.service.IProductService;

/**
 * 消费方无法调用提供方时,将返回FallbackFactory的具体实现(熔断)
 * Created by luozc on 2019-09-27
 */
@Component
public class IProductServiceFallbackFactory implements FallbackFactory<IProductService> {

    @Override
    public IProductService create(Throwable throwable) {
        return new IProductService() {
            @Override
            public String getClient() {
                return "app-feign-service<>hystrix fallback:" + throwable.getMessage();
            }
        };
    }
}
