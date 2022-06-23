package com.swuniv.security_tutle_project.service;


import com.swuniv.security_tutle_project.entity.Account;
import com.swuniv.security_tutle_project.exception.UserNameDuplicateException;
import com.swuniv.security_tutle_project.exception.UserNotFoundException;
import com.swuniv.security_tutle_project.repository.AccountRepository;
import com.swuniv.security_tutle_project.request.PasswordRequest;
import com.swuniv.security_tutle_project.request.SignUpRequest;
import com.swuniv.security_tutle_project.response.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    @Transactional
    public void doSignUp(SignUpRequest signUpRequest) {

        if (accountRepository.existsByUserId(signUpRequest.getUserId())) {
            throw new UserNameDuplicateException(signUpRequest.getUserId() + "는 이미 존재하는 아이디 입니다.");
        }
        // 통합 비밀번호 평문 저장 함부로 한거 생각 하여야함.
        Account account = Account.builder()
                .userId(signUpRequest.getUserId())
                .userPassword(signUpRequest.getUserPassword())
                .userName(signUpRequest.getUserName())
                .userIntegrationPwd(signUpRequest.getUserIntegrationPwd())
                .build();
        accountRepository.save(account);
    }


    public void updateUserPassword(String userId, PasswordRequest passwordRequest) {
        AccountResponse accountResponse = accountRepository.findByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException(userId + " This user does not exist"));
        Account account = accountRepository.findById(accountResponse.getUserNum())
                .orElseThrow(() -> new UserNotFoundException(userId + " This user does not exist"));
        account.setUserPassword(passwordRequest.getReplacePwd());
        accountRepository.save(account);
    }

    public boolean isIntegrationPwdChecked(String userId, String inputText) {
        AccountResponse accountUser = accountRepository.findByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException(userId + " This user does not exist"));
        if (!Objects.equals(accountUser.getUserIntegrationPwd(), inputText)) {
            return false;
        }
        return true;
    }

}
