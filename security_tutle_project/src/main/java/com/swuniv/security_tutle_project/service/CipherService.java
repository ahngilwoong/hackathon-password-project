package com.swuniv.security_tutle_project.service;


import com.swuniv.security_tutle_project.repository.AccountRepository;
import com.swuniv.security_tutle_project.repository.CipherKeyRepository;
import com.swuniv.security_tutle_project.repository.CipherRepository;
import com.swuniv.security_tutle_project.response.CipherKeyResponse;
import com.swuniv.security_tutle_project.response.CipherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CipherService {

    private final AccountRepository accountRepository;
    private final CipherKeyRepository cipherKeyRepository;
    private final CipherRepository cipherRepository;

    public List<CipherResponse> getRegisterCipherList(String userId) {
        return cipherRepository.findByCipherKey_UserUserId(userId)
                .stream()
                .map(CipherResponse::new)
                .collect(toList());
    }

    public void createCipher() {

    }
}
