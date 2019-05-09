package at.johnny.security.resourceserver2.restcontroller;

import at.johnny.security.resourceserver2.feign.LocalFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    private LocalFeignClient localFeignClient;

    @GetMapping("/feign")
    public String feign(){
        return localFeignClient.hello();
    }
}
