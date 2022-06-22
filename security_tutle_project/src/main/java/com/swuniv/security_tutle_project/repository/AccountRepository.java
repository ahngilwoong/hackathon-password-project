package com.swuniv.security_tutle_project.repository;

import com.swuniv.security_tutle_project.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {


}
