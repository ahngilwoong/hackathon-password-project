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
@Table(name = "cypherkey")
public class CypherKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cypherkey_num", nullable = false)
    private Long cypherKeyNum;
    @ManyToOne
    @JoinColumn(name = "user_num")
    private Account user;
    private String domainName;
    private String cypherKey;
}
