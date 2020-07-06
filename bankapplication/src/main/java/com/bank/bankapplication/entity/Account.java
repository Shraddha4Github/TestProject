package com.bank.bankapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer account_id;
	private Long accountNo;
	private Long available_Balance;
	private String account_type;
	private Integer Cust_id;
	public Integer getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public Long getAvailable_Balance() {
		return available_Balance;
	}
	public void setAvailable_Balance(Long available_Balance) {
		this.available_Balance = available_Balance;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public Integer getCust_id() {
		return Cust_id;
	}
	public void setCust_id(Integer cust_id) {
		Cust_id = cust_id;
	}

}
