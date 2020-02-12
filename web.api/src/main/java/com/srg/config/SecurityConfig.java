package com.srg.config;

import com.srg.config.security.AuthProvider;
import com.srg.user.service.UserService;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    UserService userService;

    AuthProvider authProvider;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
           .antMatchers("/static/**")
           .antMatchers("*.ico")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        // TODO: 2020/02/13 passwordEncoder 추가 확인
        http
            .authorizeRequests()
                .antMatchers(
                    "/index",
                    "/login", "/user/**",
                    "/restaurant/**", "/restaurantPosition/**"
                )
                .permitAll()
                .antMatchers("/mypage").access("ROLE_USER")
//                .anyRequest().authenticated()
                .anyRequest().permitAll()
                .and()

            .formLogin()
                .defaultSuccessUrl("/mypage")
                .failureUrl("/login")
                .usernameParameter("id")
                .passwordParameter("password")
                .and()

            .logout()
                .logoutSuccessUrl("/index")
                .invalidateHttpSession(true)
                .and()

            .authenticationProvider(authProvider)

        ;
    }
}
