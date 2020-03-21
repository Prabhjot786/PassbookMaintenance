package com.cg.pecuniabank.ui;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.cg.pecuniabank.dto.Transaction;

import com.cg.pecuniabank.service.PassbookMaintenanceService;
import com.cg.pecuniabank.service.PassbookMaintenanceServiceImpl;

public class Client {

	public static void main(String[] args)
	{
		PassbookMaintenanceService service=new PassbookMaintenanceServiceImpl();
		List<Transaction> transList=new ArrayList<Transaction>();
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("Press 1 to update the account");
		System.out.println("Press 2 for Account Summary");
		n=sc.nextInt();
		
		if(n==1)
		{
		System.out.println("Enter accountId:");
		String accId=sc.next();
		transList=service.updatePassbook(accId);
		
		System.out.println("   "+"Date"+"     "+"AccountId"+"      "+"TransId"+"   "+"TransOption"+"  "+"TransType"+"  "+"Amount"+" "+"Balance");
		
		for(Transaction t:transList)
		{
		   System.out.println(t.getTransDate()+"  "+t.getTransAccountId()+"    "+t.getTransactionId()+"  "+t.getTransType()+"    "+t.getTransOption()+"    "+t.getTransAmount()+"    "+t.getBalance());
		}
		
		}
		
	    if(n==2)
		{
		System.out.println("Enter accountId:");
		String accountId=sc.next();
		System.out.println("Enter the Date in yyyy,MM,DD format.");
		System.out.println("Enter StartDate:");
		
		String date=sc.next();
		String[] data;
		data=date.split(",");
		int year=Integer.parseInt(data[0]);
		int month=Integer.parseInt(data[1]);
		int day=Integer.parseInt(data[2]);
		LocalDate startDate=LocalDate.of(year, month, day);
		
		System.out.println("Enter EndDate:");
		String date1=sc.next();
		String[] data1;
		data1=date1.split(",");
		int year1=Integer.parseInt(data1[0]);
		int month1=Integer.parseInt(data1[1]);
		int day1=Integer.parseInt(data1[2]);
		LocalDate endDate=LocalDate.of(year1, month1, day1);
		
		
		
		List<Transaction> transList1=service.accountSummary(accountId, startDate, endDate);
		System.out.println("   "+"Date"+"      "+"AccountId"+"    "+"TransOption"+"  "+"TransType"+"   "+"Amount"+"   "+"Balance");
		for(Transaction t:transList1)
		{
			System.out.println(t.getTransDate()+"   "+t.getTransAccountId()+"     "+t.getTransOption()+"      "+t.getTransType()+"     "+t.getTransAmount()+"   "+t.getBalance());
		}
	}
  }
}
