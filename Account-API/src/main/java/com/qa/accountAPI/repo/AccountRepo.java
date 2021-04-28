package com.qa.accountAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.accountAPI.domain.Account;

// Account = name of thing I'm storing
// Long = id type
@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

	Account findByUserName(String userName);

}
