package at.johnny.security.resourceserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ResourceServer2Application {
    public static void main(String[] args) {
        SpringApplication.run(ResourceServer2Application.class, args);
    }
}
