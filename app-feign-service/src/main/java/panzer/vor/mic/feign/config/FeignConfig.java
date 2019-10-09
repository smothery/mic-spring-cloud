package panzer.vor.mic.feign.config;

import com.netflix.loadbalancer.IRule;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by luozc on 2019-09-26
 */
@Configuration
public class FeignConfig {
    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("admin","admin");
    }

    // /**
    //  * @LoadBalanced 全局权重规则，所有服务调用都使用该权重规则
    //  *
    //  * 局部权重规则  @RibbonClient(name = "APP-PRODUCT",configuration = RestConfig.class)，只对APP-PRODUCT服务生效
    //  */
    // @Bean
    // public IRule ribbonRule() {
    //     return new com.netflix.loadbalancer.RandomRule();
    // }

    /**
     * 消费者还要配置
     * logging:
     *   level:
     * @return
     */
    @Bean
    public Logger.Level getFeignLoggerLevel() {
        return feign.Logger.Level.FULL ;
    }
}
