package com.swuniv.security_tutle_project.repository;

import com.swuniv.security_tutle_project.entity.Cipher;
import com.swuniv.security_tutle_project.response.CipherResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CipherRepository extends JpaRepository<Cipher, Long> {
    List<CipherResponse> findByCipherKey_UserUserId(String userId);
}
