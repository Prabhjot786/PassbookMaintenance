package com.cg.pecuniabank.dto;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {
	
	private String transAccountId;
	private String transactionId;
	private String transType;
	private double transAmount;
	private LocalDate transDate;
	private String transOption;
	private double balance;
	private boolean transPrint;
		
	public Transaction(String transAccountId,String transType,double transAmount,LocalDate transDate,String transOption, double balance,boolean transPrint,String transactionId)
	{
		this.transAccountId=transAccountId;
		this.transType=transType;
		this.transAmount=transAmount;
		this.transDate=transDate;
		this.transOption=transOption;
		this.balance=balance;
		this.transPrint=transPrint;
		this.transactionId=transactionId;
	}
	
	public boolean isTransPrint() {
		return transPrint;
	}

	public void setTransPrint(boolean transPrint) {
		this.transPrint = transPrint;
	}

	public String getTransAccountId() {
		return transAccountId;
	}

	public void setTransAccountId(String transAccountId) {
		this.transAccountId = transAccountId;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public double getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}

	public LocalDate getTransDate() {
		return transDate;
	}

	public void setTransDate(LocalDate transDate) {
		this.transDate = transDate;
	}

	public String getTransOption() {
		return transOption;
	}

	public void setTransOption(String transOption) {
		this.transOption = transOption;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}
