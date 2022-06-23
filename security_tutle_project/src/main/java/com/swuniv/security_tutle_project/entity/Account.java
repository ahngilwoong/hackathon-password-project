package com.swuniv.security_tutle_project.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_num", nullable = false)
    private Long userNum;
    private String userId;
    private String userPassword;
    private String userName;
    private String userIntegrationPwd;

}
