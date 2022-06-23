package com.swuniv.security_tutle_project.service;


import com.swuniv.security_tutle_project.entity.Account;
import com.swuniv.security_tutle_project.exception.UserNameDuplicateException;
import com.swuniv.security_tutle_project.repository.AccountRepository;
import com.swuniv.security_tutle_project.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    @Transactional
    public void doSignUp(SignUpRequest signUpRequest){
        if (accountRepository.existsByUserId(signUpRequest.getUserId())){
            throw new UserNameDuplicateException(signUpRequest.getUserId() + "는 이미 존재하는 아이디 입니다.");
        }
        Account account = Account.builder()
                .userId(signUpRequest.getUserId())
                .userPassword(signUpRequest.getUserPassword())
                .userName(signUpRequest.getUserName())
                .userEmail(signUpRequest.getUserEmail())
                .userBirthDay(signUpRequest.getUserBirthDay()).build();
        accountRepository.save(account);
    }



}
