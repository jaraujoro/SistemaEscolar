package com.sistema.escuela.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    // Solo el PasswordEncoder como bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        //.allowedOrigins("http://192.168.18.195:4200/")
                        .allowedOrigins("*")
                        .allowedMethods("*");
            }
        };
    }

    // Configuración de URLs y login
    /*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/login-usuario", "/registro-usuario", "/usuario/registrar-usuario").permitAll()
                .requestMatchers("/build/**","/css/**", "/js/**", "/img/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login-usuario")
                .loginProcessingUrl("/valid-login")
                .usernameParameter("txt_usuario_login") // coincide con el name del input de usuario
                .passwordParameter("txt_password_login") // coincide con el name del input de contraseña
                .defaultSuccessUrl("/dashboard", true)
                .failureUrl("/login-usuario?error=true")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login-usuario");

        return http.build();
    }
    */
}
