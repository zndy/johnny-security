package at.johnny.security.resourceserver2.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="resourceServer1Feign", url="http://localhost:8071")
public interface ResourceServer1FeignClient {
    @GetMapping("/hello")
    public String callResourceServer1Hello();
}
