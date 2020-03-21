package com.cg.pecuniabank.util;

import java.util.ArrayList;
import java.util.List;

import com.cg.pecuniabank.dto.Account;

public class AccountRepository {

	ArrayList<Account> list=new ArrayList<Account>();
	public AccountRepository()
	{
	
	list.add(new Account("123456789100"));
	list.add(new Account("234568903011"));
	list.add(new Account("234567890215"));
	}
	
	public ArrayList<Account> getAccountList()
	{
		return  list;
	}
	
	
}
