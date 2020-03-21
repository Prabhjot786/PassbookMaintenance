package com.cg.pecuniabank.dao;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.pecuniabank.dto.Account;
import com.cg.pecuniabank.dto.Transaction;
import com.cg.pecuniabank.util.AccountRepository;
import com.cg.pecuniabank.util.TransactionRepository;


interface PassbookMaintenanceDAO
{
	public List<Transaction> updatePassbook(String accountId);
	public List<Transaction> accountSummary(String accountId,LocalDate startDate,LocalDate endDate);
	public boolean accountValidation(String accountId);
	
}
    public class PassbookMaintenanceDAOImpl implements PassbookMaintenanceDAO{
	   
	   TransactionRepository transRepository=new TransactionRepository();
	   public List<Transaction> updatePassbook(String accountId) {
		
		List<Transaction> transList=TransactionRepository.getTransList();
		List<Transaction> transList1=transList.stream().filter(t->{
			
        if(t.getTransAccountId().equalsIgnoreCase(accountId))
        {
    	 t.setTransPrint(true);
    	 return true;
        }
        else
        {
    	 return false;
        }
		}).collect(Collectors.toList());
		
		return transList1;
	}

	public List<Transaction> accountSummary(String accountId, LocalDate startDate, LocalDate endDate)
	{	
		List<Transaction> transList=TransactionRepository.getTransList();
	
		List<Transaction> transList1=new ArrayList<Transaction>();
		
			for(Transaction t:transList) {
				if(t.getTransAccountId().equalsIgnoreCase(accountId))
					if(t.getTransDate().isAfter(startDate)) 
                        if(t.getTransDate().isBefore(endDate))
                        {
                        	transList1.add(t);	
                        }
			}
		return transList1;
	}

	public boolean accountValidation(String accountId){
		
		AccountRepository acc=new AccountRepository();
		List<Account> list1=new ArrayList<Account>();
		list1=acc.getAccountList();
		for(Account a:list1)
		{
			if(a.getAccountId().equals(accountId))
			{
				return true;
			}
		}
		return false;
	}
	
     public boolean transAccountValidation(String accountId)
     {
		List<Transaction> list1=TransactionRepository.getTransList();
		for(Transaction t:list1)
		{
			if(t.getTransAccountId().equals(accountId))
			{
				return true;
			}
		}
		return false;
	}
}
