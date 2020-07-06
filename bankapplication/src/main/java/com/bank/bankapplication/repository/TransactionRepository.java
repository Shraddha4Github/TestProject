package com.bank.bankapplication.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bankapplication.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	public List<Transaction> findTop5ByFromAccountOrderByDateDesc(Long accountNo);
}
