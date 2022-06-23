package com.swuniv.security_tutle_project.response;


import com.swuniv.security_tutle_project.entity.Account;
import com.swuniv.security_tutle_project.entity.Cipher;
import com.swuniv.security_tutle_project.entity.CipherKey;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CipherResponse {
    private Long cipherNum;
    private CipherKey cipherKey;
    private String realCipher;
    private String userCipher;

    public CipherResponse(Cipher cipher) {
        this.cipherNum = cipher.getCipherNum();
        this.cipherKey = cipher.getCipherKey();
        this.realCipher = cipher.getRealCipher();
        this.userCipher = cipher.getUserCipher();
    }
}
