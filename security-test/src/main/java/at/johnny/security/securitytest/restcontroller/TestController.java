package at.johnny.security.securitytest.restcontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        return "ni hao " + request.getLocalName();
    }

    @GetMapping("/talk")
    public String talk(){
        return "Es ist schoen heute.";
    }

    @GetMapping("/me")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails user){
        return user;
    }
}
