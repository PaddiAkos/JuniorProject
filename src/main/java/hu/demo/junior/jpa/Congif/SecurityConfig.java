package hu.demo.junior.jpa.Congif;

import hu.demo.junior.jpa.service.impl.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final UserService userService;

    public SecurityConfig(UserService userService) {this.userService = userService;}

        @Override
        protected void configure (AuthenticationManagerBuilder auth) throws Exception
        {
                      auth.userDetailsService(userService);
        }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers(HttpMethod.DELETE, "/api/f1/users/**")
                .hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
                 http.csrf().disable();
                 http.headers().frameOptions().disable();
    }

        @Bean
        public BCryptPasswordEncoder passwordEncoder () {
            return new BCryptPasswordEncoder();
        }
    }
