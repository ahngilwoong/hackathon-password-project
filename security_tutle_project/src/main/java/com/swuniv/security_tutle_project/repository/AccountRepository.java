package com.swuniv.security_tutle_project.repository;

import com.swuniv.security_tutle_project.entity.Account;
import com.swuniv.security_tutle_project.response.AccountResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
        Optional<AccountResponse> findByUserId(String userId);
        boolean existsByUserId(String userId);
}
