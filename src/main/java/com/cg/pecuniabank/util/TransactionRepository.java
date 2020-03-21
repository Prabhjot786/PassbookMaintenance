package com.cg.pecuniabank.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cg.pecuniabank.dto.Transaction;

public class TransactionRepository {

	private static List<Transaction> transList=new ArrayList<Transaction>();
	public  TransactionRepository()
	{
		transList.add(new Transaction("123456789100","Debit",2000.00,LocalDate.of(2020,01,19),"slip",30000.00,false,"123456789021"));
		transList.add(new Transaction("123456789100","Credit",1000.00,LocalDate.of(2020,01,22),"slip",29000.00,false,"12356728298"));
		transList.add(new Transaction("123456789100","Credit",2000.00,LocalDate.of(2020,02,11),"slip",31000.00,false,"98293829010"));
		transList.add(new Transaction("234568903011","Debit",1800.00,LocalDate.of(2020,01,13),"slip",15000.00,false,"82983802002"));
		transList.add(new Transaction("234568903011","credit",2000.00,LocalDate.of(2020,02,14),"slip",17000.00,false,"76748382832"));
		transList.add(new Transaction("234568903011","credit",5000.00,LocalDate.of(2020,02,17),"slip",23000.00,false,"75636282891"));
		transList.add(new Transaction("234568903011","Debit",2000.00,LocalDate.of(2020,02,17),"slip",21000.00,false,"74829201033"));
	}
	public static List<Transaction> getTransList() {
		return transList;
	}	
	
}
