package com.bank.bankapplication.dto;

public class AccountDto {

	private Long account_no;
	private String available_Balance;
	private String account_type;
	private Integer Cust_id;
	public Long getAccount_no() {
		return account_no;
	}
	public void setAccount_no(Long account_no) {
		this.account_no = account_no;
	}
	public String getAvailable_Balance() {
		return available_Balance;
	}
	public void setAvailable_Balance(String available_Balance) {
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
