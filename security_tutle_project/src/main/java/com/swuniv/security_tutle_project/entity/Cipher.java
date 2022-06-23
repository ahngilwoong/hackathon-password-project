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
public class Cipher {
    @Id
    @Column(name = "cipher_num", nullable = false)
    private Long cipherNum;
    @OneToOne
    @JoinColumn(name = "cipherkey_num")
    private CipherKey cipherKey;
    private String realCipher;
    private String userCipher;
}
