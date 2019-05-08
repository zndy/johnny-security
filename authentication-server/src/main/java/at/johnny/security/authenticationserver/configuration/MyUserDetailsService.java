package at.johnny.security.authenticationserver.configuration;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * define custom user and passwd
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) {
        if (!Objects.equals(s, "johnny")) {
            throw new UsernameNotFoundException(s);
        }
        UserDetails user =
                User.withUsername("johnny")
                        .password("{noop}123")
                        .roles("USER")
                        .build();
        return user;
    }
}
