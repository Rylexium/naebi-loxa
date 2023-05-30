package com.selftesting.selftesting.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        // нужно всё сделать как для обычного веб-контролера
        return http
                .csrf()
                .disable()
                    .authorizeHttpRequests()
                    .requestMatchers("/auth/**", "/registration/**", "/login-form/**",
                            "/tests/**", "/adte/**", "/adus/**", "/teso/**",
                            "/ui/tests/**", "/ui/admin_tests/**", "/ui/admin_users/**", "/ui/test_solution/**").permitAll()
                    .anyRequest()
                    .authenticated()
                .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authenticationProvider(authenticationProvider)
                    .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

//        return http.csrf().disable().authorizeHttpRequests()
//                .requestMatchers("/**").permitAll().and().build();
    }

}
