package pl.januaryevecatherine.todoapp.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pl.januaryevecatherine.todoapp.repositories.UserRepository;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    final UserRepository repo;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/images/**", "/webjars/**", "/login", "/addUser")
                        .permitAll()
                        .requestMatchers("/new").hasAuthority("admin")
                        .requestMatchers("/tasks").hasAnyAuthority("user", "admin")
                        .anyRequest()
                        .authenticated()
                )
                .csrf(CsrfConfigurer::disable)
                .formLogin((formLogin) -> formLogin.defaultSuccessUrl("/tasks").permitAll())
                .logout(LogoutConfigurer::permitAll)
        ;

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider prov = new DaoAuthenticationProvider();
        prov.setUserDetailsService(users());
        prov.setPasswordEncoder(passwordEncoder());
        return prov;
    }

    @Bean
    UserDetailsService users() {
        return new MyUserDetailService(repo);
    }

}
