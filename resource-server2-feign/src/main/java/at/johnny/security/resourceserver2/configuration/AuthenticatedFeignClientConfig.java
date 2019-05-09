package at.johnny.security.resourceserver2.configuration;

import feign.Logger;
import feign.RequestInterceptor;
import org.apache.logging.slf4j.SLF4JLogger;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class AuthenticatedFeignClientConfig {

    private static final String clientId = "client_1";
    private static final String clientSecret = "123456";
    private static final String tokenUri = "http://localhost:8181/oauth/token";
    private static final String scopes = "select";

    @Bean
    public RequestInterceptor oauth2RequestInterceptor(){
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(),resource());
    }

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }


    private ClientCredentialsResourceDetails resource(){
        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setAccessTokenUri(tokenUri);
        resourceDetails.setClientId(clientId);
        resourceDetails.setClientSecret(clientSecret);
        resourceDetails.setGrantType("client_credentials");
        resourceDetails.setScope(Collections.singletonList(scopes));
        return resourceDetails;
    }

}
