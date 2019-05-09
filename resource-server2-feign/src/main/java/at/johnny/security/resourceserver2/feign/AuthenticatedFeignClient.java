package at.johnny.security.resourceserver2.feign;

import at.johnny.security.resourceserver2.configuration.AuthenticatedFeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "authFeignClient", url = "http://localhost:8071", configuration = AuthenticatedFeignClientConfig.class)
public interface AuthenticatedFeignClient {

    @GetMapping("/talk")
    String talk();

}
