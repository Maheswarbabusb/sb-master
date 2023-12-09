package com.mahesh.master.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {


    @Bean
    public UserDetailsService userDetailsService(){

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
       // UserDetails user =new User("Mahesh","mahesh",new ArrayList<>());
        UserDetails user= User.withUsername("Mahesh").password(bCryptPasswordEncoder().encode("mahesh")).authorities("read").build();
        inMemoryUserDetailsManager.createUser(user);
        return inMemoryUserDetailsManager;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(auth->auth.anyRequest().authenticated()).build();
    }
}
