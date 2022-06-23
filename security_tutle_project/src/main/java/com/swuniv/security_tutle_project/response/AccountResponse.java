package com.swuniv.security_tutle_project.response;


import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountResponse {
    private Long userNum;
    private String userId;
    private String userPassword;
    private String userName;
    private String userIntegrationPwd;
}
