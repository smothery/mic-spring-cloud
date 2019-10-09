package panzer.vor.mic.feign.service.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import panzer.vor.mic.feign.service.IProductService;
import panzer.vor.mic.feign.service.IZuulSercice;

/**
 * 消费方无法调用提供方时,将返回FallbackFactory的具体实现(熔断)
 * Created by luozc on 2019-09-27
 */
@Component
public class IZuulServiceFallbackFactory implements FallbackFactory<IZuulSercice> {

    @Override
    public IZuulSercice create(Throwable throwable) {
        return new IZuulSercice() {
            @Override
            public String getProductClient() {
                return "app-feign-service<>product-proxy hystrix fallback:" + throwable.getMessage();
            }

            @Override
            public String getOrderClient() {
                return "app-feign-service<>order-proxy hystrix fallback:" + throwable.getMessage();
            }
        };
    }
}
