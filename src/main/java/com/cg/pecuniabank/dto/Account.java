package com.cg.pecuniabank.dto;

public class Account {

	private String accountId;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public Account(String accountId)
	{
		this.accountId=accountId;
	}

	
}
