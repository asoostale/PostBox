package com.postbox.config;


import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain chain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers("/css/**","/img/**", "/", "/join", "/joinProc", "/ui","/board1","/board-write","/favicon.ico", "/resources/**",
                        "/error", "/src/**", "/post/**").permitAll()
                .anyRequest().authenticated());

        http.formLogin((auth) -> auth
                .loginPage("/login")
                .loginProcessingUrl("/loginProc")

                .defaultSuccessUrl("/")
                .permitAll());


        //session 보안 강화
        http.sessionManagement(auth -> auth
                .sessionFixation().changeSessionId());


        //다중 로그인 최대 2개
        http.sessionManagement((auth) -> auth
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true));


        http.logout((auth) -> auth.logoutUrl("/logout")
                .logoutSuccessUrl("/"));


        return http.build();
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }







}
