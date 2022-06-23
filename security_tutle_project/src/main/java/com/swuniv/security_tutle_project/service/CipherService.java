package com.swuniv.security_tutle_project.service;


import com.swuniv.security_tutle_project.entity.Account;
import com.swuniv.security_tutle_project.entity.Cipher;
import com.swuniv.security_tutle_project.entity.CipherKey;
import com.swuniv.security_tutle_project.exception.UserNotFoundException;
import com.swuniv.security_tutle_project.repository.AccountRepository;
import com.swuniv.security_tutle_project.repository.CipherKeyRepository;
import com.swuniv.security_tutle_project.repository.CipherRepository;
import com.swuniv.security_tutle_project.request.CipherRequest;
import com.swuniv.security_tutle_project.response.CipherResponse;
import com.swuniv.security_tutle_project.util.CipherAesUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CipherService {

    private final AccountRepository accountRepository;
    private final CipherKeyRepository cipherKeyRepository;
    private final CipherRepository cipherRepository;

    public List<CipherResponse> findRegisterCipherList(String userId) {
        return cipherRepository.findByCipherKey_UserUserId(userId)
                .stream()
                .map(CipherResponse::new)
                .collect(toList());
    }

    @Transactional
    public String createCipher(String userId, CipherRequest cipherRequest) {
        Account account = accountRepository.findByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException(userId + " This user does not exist"));

        String plainText = account.getUserIntegrationPwd()+cipherRequest.getDomain();
        String encryptText = CipherAesUtils.encrypt(plainText.getBytes(),cipherRequest.getCipherKey()
                .getBytes(),Integer.parseInt(cipherRequest.getStringLength()));

        int checkNum = CipherAesUtils.upperAndSpecialCharInspection(cipherRequest);
        String newEncryptText = CipherAesUtils.convertString(checkNum,encryptText);

        CipherKey cipherKey = CipherKey.builder()
                .user(account)
                .domainName(cipherRequest.getDomain())
                .cipherKey(cipherRequest.getCipherKey())
                .build();

        Cipher cipher = Cipher.builder()
                .cipherKey(cipherKey)
                .realCipher(encryptText)
                .userCipher(newEncryptText)
                .build();

        cipherKeyRepository.save(cipherKey);
        cipherRepository.save(cipher);

        return newEncryptText;
    }
}
