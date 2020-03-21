package com.cg.pecuniabank.service;


import java.time.LocalDate;
import java.time.Period;

import java.util.ArrayList;

import java.util.List;

import com.cg.pecuniabank.dao.PassbookMaintenanceDAOImpl;
import com.cg.pecuniabank.dto.Transaction;
import com.cg.pecuniabank.exception.CheckDateException;
import com.cg.pecuniabank.exception.InvalidAccountException;


public class PassbookMaintenanceServiceImpl implements PassbookMaintenanceService {
	
	PassbookMaintenanceDAOImpl dao=new PassbookMaintenanceDAOImpl();
	List<Transaction> transList=new ArrayList<Transaction>();
	
	
	public List<Transaction> updatePassbook(String accountId) {
		try {
			if(accountId.matches("^[0-9]{12}?$")&& accountId.substring(0)!="-")
			{
				boolean accountExist=dao.accountValidation(accountId);
				if(accountExist)
				{
					transList=dao.updatePassbook(accountId);
				}
				else
				{
					throw new InvalidAccountException("Exception:Invalid account Id");
				}
			}
			else
			{
			throw new InvalidAccountException("Exception:Invalid account Id");
			}
		  }
		catch(InvalidAccountException e){
			System.out.println(e);
			}

		return transList;
	}

	public List<Transaction> accountSummary(String accountId, LocalDate startDate, LocalDate endDate) {

      List<Transaction> transList1=new ArrayList<Transaction>();
      try
      {
    	  if(accountId.matches("^[0-9]{12}?$")&& accountId.substring(0)!="-")
    	  {
    	  boolean accountExist=dao.accountValidation(accountId);
    	  boolean transAccountIdExist=dao.transAccountValidation(accountId);
    	  if(accountExist)
    	  {
    		  LocalDate now=LocalDate.now();
    		  Period diff=Period.between(endDate,now);
    		  if(diff.getDays()>0 || diff.getYears()>0 || diff.getMonths()>0)
    		  {	
    			  boolean b=validate(startDate);
	              boolean endDte=validate(endDate);
	              if(b==true && endDte==true)
	              {
	            	  if(transAccountIdExist)
	            	  {
	            		  transList1=dao.accountSummary(accountId,startDate,endDate);
	            		  return transList1;
	            	  }
	            	 
	               }
	              else
	              {
	            	  throw new CheckDateException("Invalid Date");
	               }
	            }
	            else
	            {
	            	throw new CheckDateException("Exception:Invalid Date");
	            }
    		 }
	         else
	         {
					throw new InvalidAccountException("Account doesn't exists");
			   } 
    	  }
    	  else
    	  {
    		  
    		  throw new InvalidAccountException("Invalid Account");
    	  }
    	  }
      catch(CheckDateException | InvalidAccountException e)
      {
    	  System.out.println(e);
    	  }
      return transList1;
      }
	
	
	public boolean validate(LocalDate localDte) {
		String date=localDte.toString();
        String[] data=date.split("-");;
                	 
                	
        Integer[] intarray=new Integer[data.length];
        int i=0;
        for(String str:data)
        {
        	intarray[i]=Integer.parseInt(str);
            i++;
        }
        if(data[0].length()==4) 
        	if(intarray[0]<=2020)
        		if(data[1].length()==2)
        			if(intarray[1]>=1&& intarray[1]<=12)
        				if(data[2].length()==2)
        					if( intarray[2]>=1&& intarray[2]<=31)
        					{
        						return true;
        					}
        return false;
        }
}
