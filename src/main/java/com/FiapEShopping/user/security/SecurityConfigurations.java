package com.FiapEShopping.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

	
    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                		
        
                		.requestMatchers(HttpMethod.POST, "/cadastro").permitAll()
                		.requestMatchers(HttpMethod.POST, "itens-carrinho").permitAll()
                		.requestMatchers(HttpMethod.GET, "/api/listarCarrinho").permitAll()
                //		 .requestMatchers(HttpMethod.POST, "/api/adicionarItem/*").permitAll() 
                		.requestMatchers(HttpMethod.GET, "/listarItens").permitAll()
                		.requestMatchers(HttpMethod.POST, "/api/criarCarrinho").permitAll()
                		.requestMatchers(HttpMethod.POST, "/api/listarCarrinho").permitAll()
                		.requestMatchers(HttpMethod.GET, "/listarItensCadastrados").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.GET, "/users").permitAll()
                        
//                        .requestMatchers(HttpMethod.POST, "/cadastro").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/cadastrarNovoItem").hasRole("ADMIN")
                        
                        
                        .anyRequest().authenticated())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}