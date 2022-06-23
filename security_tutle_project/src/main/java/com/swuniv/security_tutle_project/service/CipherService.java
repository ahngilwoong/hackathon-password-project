package com.swuniv.security_tutle_project.service;


import com.swuniv.security_tutle_project.repository.AccountRepository;
import com.swuniv.security_tutle_project.repository.CipherKeyRepository;
import com.swuniv.security_tutle_project.repository.CipherRepository;
import com.swuniv.security_tutle_project.response.CipherKeyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CipherService {

    private final AccountRepository accountRepository;
    private final CipherKeyRepository cipherKeyRepository;
    private final CipherRepository cipherRepository;

    public List<CipherKeyResponse> getRegisterCipherList(String userId) {
        Long userNum = accountRepository.findByUserId(userId).get().getUserNum();
        return null;
    }
}
