package com.example.springjwt.day8jwt.config;

import com.example.springjwt.day8jwt.entity.Role;
import com.example.springjwt.day8jwt.services.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


//@AllArgsConstructor
//@NoArgsConstructor
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
    @Autowired
    private  JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public UserDetailsService userDetailsService () {
//        UserDetails admin = User.withUsername("test123")
//                .password(encoder.encode("password"))
//                .roles("ADMIN")
//                .build();
//        UserDetails user = User.withUsername("user")
//                .password(encoder.encode("password"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
        return new UserServiceImpl();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        System.out.println("In security filter chain");
//        try {
//            http.csrf(AbstractHttpConfigurer::disable)
//                    .authorizeHttpRequests(request -> request.requestMatchers("/api/v1/auth/**")
//                            .permitAll()
//                            .requestMatchers("/api/v1/admin").hasAnyAuthority(Role.ADMIN.name())
//                            .requestMatchers("/api/v1/user").hasAnyAuthority(Role.USER.name())
//                            .anyRequest().authenticated())
//                            .sessionManagement(manager-> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                            .authenticationProvider(authenticationProvider()).addFilterBefore(
//                            jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//            return http.build();
//        } catch (Exception e) {
//            System.out.println("Error security chain >>> "+e.getMessage());
//            throw new RuntimeException(e);
//        }
        return httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**").permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/admin").hasAnyAuthority(Role.ADMIN.name())
                .requestMatchers("/api/v1/auth/user").hasAnyAuthority(Role.USER.name())
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

}
