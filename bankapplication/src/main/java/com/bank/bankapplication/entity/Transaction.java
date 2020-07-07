package com.bank.bankapplication.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transid;
	private Long fromAccount;
	private Long toAccount;
	private Long amount;
	private String Trantype;
	private Date date;
	
	
	
	public Integer getTransid() {
		return transid;
	}
	public void setTransid(Integer transid) {
		this.transid = transid;
	}
	public String getTrantype() {
		return Trantype;
	}
	public void setTrantype(String trantype) {
		Trantype = trantype;
	}
	public Long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Long getToAccount() {
		return toAccount;
	}
	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
