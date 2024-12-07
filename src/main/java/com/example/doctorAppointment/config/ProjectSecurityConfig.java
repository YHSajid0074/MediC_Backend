//package com.example.doctorAppointment.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class ProjectSecurityConfig {
//
//    @Autowired
//    CustomUserDetailsService CustomUserDetailsService;
//
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csr->csr.disable());
//        http.authorizeHttpRequests(authorizeRequests ->
//                                         authorizeRequests.requestMatchers("sajid")
//                                               .permitAll().anyRequest().authenticated());
//
//        http.httpBasic(withDefaults());
//        http.sessionManagement(ses->ses.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        return http.build();
//    }
//
//public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//}
//
//
//   public  AuthenticationProvider authenticationProvider() {
//       DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//       daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
//       daoAuthenticationProvider.setUserDetailsService(CustomUserDetailsService);
//       return daoAuthenticationProvider;
//   }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager();
//    }
//}
