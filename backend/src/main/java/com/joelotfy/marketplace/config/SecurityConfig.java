package com.joelotfy.marketplace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
public class SecurityConfig {
    
    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            //disable CSRF so postman can make post/put/patch/delete requests
            .csrf(csrf -> csrf.disable())

            //require authentication for all endpoints
            .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())

            //keep basic auth active
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean 
    public PasswordEncoder passwordEncoder() {
        //bcrypt automatically handles salting and hashing
        return new BCryptPasswordEncoder();
    }

    @Bean 
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("user")
            .password(passwordEncoder.encode("password"))
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}
