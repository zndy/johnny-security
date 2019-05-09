package at.johnny.security.resourceserver2.restcontroller;

import at.johnny.security.resourceserver2.feign.LocalFeignClient;
import at.johnny.security.resourceserver2.feign.ResourceServer1FeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    private LocalFeignClient localFeignClient;

    @Autowired
    private ResourceServer1FeignClient resourceServer1FeignClient;

    @GetMapping("/hello1")
    public String callLocalHello(){
        return localFeignClient.callLocalHello();
    }

    @GetMapping("/hello2")
    public String callResourceServer1Hello(){
        return resourceServer1FeignClient.callResourceServer1Hello();
    }
}
