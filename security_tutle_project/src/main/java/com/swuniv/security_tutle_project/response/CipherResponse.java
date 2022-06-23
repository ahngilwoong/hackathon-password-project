package com.swuniv.security_tutle_project.response;


import com.swuniv.security_tutle_project.entity.Account;
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
    private Long cipherKeyNum;
    private Account user;
    private String domainName;
    private String cipherKey;
}
