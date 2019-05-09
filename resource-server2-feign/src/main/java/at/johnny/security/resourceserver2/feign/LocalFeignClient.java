package at.johnny.security.resourceserver2.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="localFeignClient", url="http://localhost:8072")
public interface LocalFeignClient {
    @GetMapping("/hello")
    String hello();
}
