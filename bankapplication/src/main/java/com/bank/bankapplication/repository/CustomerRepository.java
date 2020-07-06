package com.bank.bankapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bankapplication.entity.Customer;

@Repository
public interface CustomerRepository extends  JpaRepository <Customer, Integer>{

	
}
