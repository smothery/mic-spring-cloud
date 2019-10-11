package panzer.vor.mic.stream.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import panzer.vor.mic.entity.Product;
import panzer.vor.mic.entity.User;
import panzer.vor.mic.stream.provider.service.IMessageProvider;

import java.util.UUID;

/**
 * Created by luozc on 2019-10-10
 */
@SpringBootApplication
public class StreamProviderApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(StreamProviderApp.class, args);
    }

    @Autowired
    private IMessageProvider iMessageProvider;
    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public void run(String... args) throws Exception {
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setProductName(applicationName);
        product.setProductDesc(applicationName);
        iMessageProvider.send(product);

        Thread.sleep(5000);

        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername(applicationName);
        iMessageProvider.sendUser(user);
    }
}
