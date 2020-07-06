package com.bank.bankapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bankapplication.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

	public Account findByAccountNo(Long accountNo);
}
