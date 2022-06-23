package com.swuniv.security_tutle_project.request;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountRequest {
    private String userId;
    private String userPassword;
    private String userName;
    private String userIntegrationPwd;
}
