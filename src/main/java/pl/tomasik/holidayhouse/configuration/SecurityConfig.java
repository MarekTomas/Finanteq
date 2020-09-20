package pl.tomasik.holidayhouse.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

    /*private final PasswordEncoder passwordEncoder;

    @Bean
    public UserDetailsService userDetailsService(){
        User.builder()
                .username()
                .password(passwordEncoder.encode("password"))
                .roles()
    }*/

}
