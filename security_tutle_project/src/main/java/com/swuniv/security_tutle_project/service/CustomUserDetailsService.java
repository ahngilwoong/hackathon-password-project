package com.swuniv.security_tutle_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

//    private final AccountAdaptor accountAdaptor;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        Users accountDbUser = accountAdaptor.getUserByIdFromAccountApi(username)
//                .orElseThrow(() -> new UserNotFoundException(username + " No User With That Name Was Found."));
//        return new User(accountDbUser.getUserId(),accountDbUser.getUserPwd(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_MEMBER")));
//
//    }
}