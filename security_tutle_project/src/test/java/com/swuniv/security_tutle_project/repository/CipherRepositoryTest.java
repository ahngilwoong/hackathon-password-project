package com.swuniv.security_tutle_project.repository;

import com.swuniv.security_tutle_project.entity.Cipher;
import com.swuniv.security_tutle_project.response.CipherResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CipherRepositoryTest {
    @Autowired
    private CipherRepository cipherRepository;

    @Test
    @DisplayName("UserId로 그에 속한 비밀번호들을 가져오기 위한 테스트")
    void getCipherByUserIdTest(){
        List<Cipher> lists =  cipherRepository.findByCipherKey_UserUserId("test");

//        assertThat(lists.size()).isEqualTo(3);
//        assertThat(lists.get(0).getCipherNum()).isEqualTo(1);
//        assertThat(lists.get(1).getCipherNum()).isEqualTo(3);
//        assertThat(lists.get(2).getCipherNum()).isEqualTo(4);

    }
}