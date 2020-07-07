package com.bank.bankapplication.dto;

public class AccountDto {

	private Long accountNo;
	private Long availableBalance;
	private String accounttype;
	private Integer custid;
	
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public Long getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(Long availableBalance) {
		this.availableBalance = availableBalance;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public Integer getcustid() {
		return custid;
	}
	public void setcustid(Integer custid) {
		this.custid = custid;
	}
	
	
	
}
