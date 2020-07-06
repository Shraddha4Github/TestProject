package com.bank.bankapplication.dto;

import java.util.Date;

public class TransactionDto {
	
	private Long fromAccount;
	private Long toAccount;
	private Long amount;
	private String Tran_type;
	private Date date;
	
	
	
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
	public String getTran_type() {
		return Tran_type;
	}
	public void setTran_type(String tran_type) {
		Tran_type = tran_type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
