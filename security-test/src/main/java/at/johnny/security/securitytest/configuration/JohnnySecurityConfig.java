package at.johnny.security.securitytest.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * define custom resource access permission and login mode
 */
@EnableWebSecurity
public class JohnnySecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private UserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/hello").permitAll()
                .anyRequest().authenticated()
                .and().formLogin() // /logout works only with formLogin and doesn't with HttpBasic
                .and().csrf().disable();
    }

    /**
     * UserDetailsService and passwdEncoder can be defined here
     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("johnny").password(bCryptPasswordEncoder().encode("123")).roles("USER");
//        auth.userDetailsService(myUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
//    }

    /**
     *  custom user and passwd can be defined here
     *
     * @return
     */
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("johnny").password("{noop}123").roles("USER").build());
//        return manager;
//    }
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
