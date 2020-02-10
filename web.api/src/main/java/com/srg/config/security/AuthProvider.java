package com.srg.config.security;

import com.srg.user.entity.User;
import com.srg.user.service.UserAuthentication;
import com.srg.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.util.ObjectUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = authentication.getName();
        String userPw = authentication.getCredentials().toString();
        return authenticate(userId, userPw);
    }

    private Authentication authenticate(String id, String pw) {
        User user = userService.getUserDetail(id);
        if (ObjectUtils.isEmpty(user) || !user.getPassword().equals(pw)) {
            log.error("{} is not exist or password is not equals", id);
            return null;
        }
        UserAuthentication result = new UserAuthentication();
        result.setAuthenticated(true);
        result.setPrincipal(user);

        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
