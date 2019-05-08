package at.johnny.security.resourceserver1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServer1Config extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/hello").permitAll()
                .anyRequest().authenticated();
    }

    /**
     * for remote AuthenticationServer
     * @return
     */
    @Bean
    public RemoteTokenServices remoteTokenService(){
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setClientId("client_1");
        tokenServices.setClientSecret("123456");
        tokenServices.setCheckTokenEndpointUrl("http://localhost:8181/oauth/check_token");
        tokenServices.setTokenName("token");
        return tokenServices;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("resource1");
        resources.tokenServices(remoteTokenService());
    }
}
