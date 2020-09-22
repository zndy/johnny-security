package at.johnny.security.resourceserver1.restcontroller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        return "good morning " + request.getLocalAddr();
    }

    @GetMapping("/talk")
    public String talk() {
        return "heute ist windig.";
    }

    @GetMapping("/me")
    public Authentication getCurrentUser(Authentication user) {
        return user;
    }

    @GetMapping("/mee")
    public String token() {
        OAuth2AuthenticationDetails auth = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        String tokenValue = auth.getTokenValue();
        return tokenValue;
    }

}
