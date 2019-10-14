package panzer.vor.mic.sleuth.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;

/**
 * Created by luozc on 2019-10-11
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinApp2 {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinApp2.class, args);
    }
}
