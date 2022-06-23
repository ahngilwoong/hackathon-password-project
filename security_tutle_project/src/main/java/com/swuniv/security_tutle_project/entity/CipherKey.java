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
@Table(name = "cipherkey")
public class CipherKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cipherkey_num", nullable = false)
    private Long cipherKeyNum;
    @ManyToOne
    @JoinColumn(name = "user_num")
    private Account user;
    private String domainName;
    private String cipherKey;
}
