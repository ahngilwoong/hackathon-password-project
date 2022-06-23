package com.swuniv.security_tutle_project.repository;

import com.swuniv.security_tutle_project.entity.Account;
import com.swuniv.security_tutle_project.response.AccountResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
        Optional<Account> findByUserId(String userId);
        boolean existsByUserId(String userId);
        @Query("select DISTINCT a.userNum from Account a where a.userId = ?1")
        Long findMemberNumByMemberId(String memberId);
}
