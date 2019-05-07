package at.johnny.security.resourceserver1.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        return "good morning " + request.getLocalAddr();
    }

    @GetMapping("/talk")
    public String talk(){
        return "heute ist windig.";
    }

}