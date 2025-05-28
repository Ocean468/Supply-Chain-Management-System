package com.supplychain.supply_chain_management_system.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.supplychain.supply_chain_management_system.service.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig {


    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());

        return provider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

            .csrf(customizer -> customizer.disable())
            .securityContext(context -> context
                .requireExplicitSave(false)
            )
            .authorizeHttpRequests(auth -> auth
            .requestMatchers("/login", "/signup", "/error", "/resources/**", "/js/**", "/css/**", "/webjars/**", "/views/**").permitAll()
            // .requestMatchers("/api/customers/products").permitAll() // Allow browsing products
            // .requestMatchers("/api/customers/cart/**").hasAuthority("CUSTOMER") // Only customers can access cart
            // .requestMatchers("/api/admin/**").hasRole("ADMIN") // Restrict admin routes
            // .requestMatchers("/api/vendor/**").hasRole("VENDOR") // Restrict vendor routes

             // Role-based access
            .requestMatchers("/farmer/**").hasRole("FARMER")
            .requestMatchers("/buyer/products", "/order/place", "/buyer/**").hasAuthority("BUYER")
            .requestMatchers("/admin/**").hasAuthority("ADMIN")
            .anyRequest().authenticated()
            
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard", true)
                .permitAll()
            )
            .httpBasic(customizer -> customizer.disable())
            .logout(logout -> logout    
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            )
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/login", "/logout","/signup","/api/**") // Adjust paths based on your needs
            );

        return http.build();
    }

}







// @Configuration
// public class SecurityConfig {

//     @Autowired
//     private CustomUserDetailsService userDetailsService;

//     @Bean
//     public BCryptPasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public DaoAuthenticationProvider authenticationProvider() {
//         DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//         authProvider.setUserDetailsService(userDetailsService);
//         authProvider.setPasswordEncoder(passwordEncoder());
//         return authProvider;
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/signup", "/login", "/css/**", "/js/**").permitAll()
//                 .anyRequest().authenticated()
//             )
//             .formLogin(form -> form
//                 .loginPage("/login")
//                 .loginProcessingUrl("/login")
//                 .defaultSuccessUrl("/dashboard", true)
//                 .failureUrl("/login?error=true")
//                 .permitAll()
//             )
//             .logout(logout -> logout
//                 .logoutUrl("/logout")
//                 .logoutSuccessUrl("/login?logout=true")
//                 .permitAll()
//             )
//             .csrf(csrf -> csrf.disable());

//         return http.build();
//     }
// }
