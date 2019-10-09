package panzer.vor.mic.client.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * Created by luozc on 2019-09-17
 */
@Configuration
public class RestConfig {
    @Bean
    // @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders getHeaders() { // 要进行一个Http头信息配置
        HttpHeaders headers = new HttpHeaders(); // 定义一个HTTP的头信息
        String auth = "admin:admin"; // 认证的原始信息
        byte[] encodedAuth = Base64.getEncoder()
                .encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization", authHeader);
        return headers;
    }

    /**
     * @LoadBalanced 全局权重规则，所有服务调用都使用该权重规则
     *
     * 局部权重规则  @RibbonClient(name = "APP-PRODUCT",configuration = RestConfig.class)，只对APP-PRODUCT服务生效
     */
    @Bean
    public IRule ribbonRule() {
        return new com.netflix.loadbalancer.RandomRule();
    }
}
