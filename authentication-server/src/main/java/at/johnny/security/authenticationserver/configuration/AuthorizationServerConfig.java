package at.johnny.security.authenticationserver.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    //for jwt
    @Autowired
    private TokenStore jwtTokenStore;

    //for jwt
    @Autowired
    private AccessTokenConverter accessTokenConverter;

    private String DEMO_RESOURCE_ID = "resource1";

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client_1")
                .secret(bCryptPasswordEncoder.encode("123456"))
                .accessTokenValiditySeconds(7200)
                .resourceIds(DEMO_RESOURCE_ID)
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("select")
                .authorities("client")

                .and()
                .withClient("client_2")
                .secret(bCryptPasswordEncoder.encode("123456"))
                .accessTokenValiditySeconds(7200)
                .resourceIds(DEMO_RESOURCE_ID)
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("select")
                .authorities("client");
    }

    /**
     * for get and check Token
     *
     * @param security
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        //allow send client_id and client_secret in params
        //otherwise headers:{Authorization: 'Basic client_id:client_secret in base64}
        security.allowFormAuthenticationForClients();
        security.checkTokenAccess("isAuthenticated()");
//        security.checkTokenAccess("permitAll()");
    }

    /**
     * for authorizedGrantType password,
     * without this method return error Unsupported grant type: password
     *
     * @param endpoints
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .authenticationManager(authenticationManager)
                .tokenStore(jwtTokenStore) //jwt
                .accessTokenConverter(accessTokenConverter); //jwt
    }

}
