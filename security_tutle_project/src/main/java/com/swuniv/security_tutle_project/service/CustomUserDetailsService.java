package com.swuniv.security_tutle_project.service;

import com.swuniv.security_tutle_project.exception.UserNotFoundException;
import com.swuniv.security_tutle_project.repository.AccountRepository;
import com.swuniv.security_tutle_project.response.AccountResponse;
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

    private final AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountResponse accountUser = accountRepository.findByUserId(username).orElseThrow(() -> new UserNotFoundException(username + " This user does not exist"));
        return new User(accountUser.getUserId(), accountUser.getUserPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_MEMBER")));
    }


}