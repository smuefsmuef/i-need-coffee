package ch.fhnw.webec.exercise.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private DaoAuthenticationProvider daoAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginPage("/login").permitAll()
            .defaultSuccessUrl("/")
            .and().authorizeRequests()
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
            .mvcMatchers("/").permitAll()
            .mvcMatchers("/h2-console/**").hasRole("ADMIN")
            .mvcMatchers("/about").permitAll()
            .mvcMatchers("/registration").permitAll()
            .mvcMatchers("/coffemix/**").permitAll()
            .mvcMatchers("/api/**").permitAll() // Permitting for demonstrating purposes only!
            .anyRequest().authenticated()
            .and().csrf()
            .ignoringAntMatchers("/api/**"); // Ignoring for demonstrating purposes only!
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(this.daoAuthenticationProvider);
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        var daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);

        return daoAuthenticationProvider;
    }
}
