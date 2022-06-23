package com.swuniv.security_tutle_project.service;

import com.swuniv.security_tutle_project.entity.Account;
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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> accountUser = accountRepository.findByUserId(username);
        return new User(accountUser.get().getUserId(), accountUser.get().getUserPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_MEMBER")));
    }


}