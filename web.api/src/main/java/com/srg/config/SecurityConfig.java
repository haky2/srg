package com.srg.config;

import com.srg.config.security.AuthProvider;
import com.srg.user.service.UserService;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
// TODO: 2020/02/10 passwordencoder, vue 연동부분 확인 
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    UserService userService;

    AuthProvider authProvider;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
           .antMatchers("/static/**")
           .antMatchers("*.ico")
           .antMatchers("/login");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
            .antMatchers("/user/**").access("ROLE_USER")
            .antMatchers("/login").permitAll()
            .antMatchers("/**").authenticated();

        http.formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/home")
            .usernameParameter("id")
            .passwordParameter("password");

        http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true);

        http.authenticationProvider(authProvider);

    }
}
