package com.cg.pecuniabank.daotest;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.cg.pecuniabank.dao.PassbookMaintenanceDAOImpl;
import com.cg.pecuniabank.dto.Account;
import com.cg.pecuniabank.dto.Transaction;
import com.cg.pecuniabank.util.TransactionRepository;

public class PassbookMaintenanceDaoImplTest 
{
	PassbookMaintenanceDAOImpl passbookmaintenance_dao=new PassbookMaintenanceDAOImpl();
	@Test
	public void accountValidationTest1()
	{
		Assert.assertFalse(passbookmaintenance_dao.accountValidation("123456789012"));
	}
	
	@Test
	public void accountValidationTest2()
	{
		Assert.assertTrue(passbookmaintenance_dao.accountValidation("234568903011"));
	}
	
	@Test
	public void transAccountValidationTest1()
	{
		Assert.assertFalse(passbookmaintenance_dao.transAccountValidation("123456789012"));
	}
	
	@Test
	public void transAccountValidationTest2()
	{
		Assert.assertTrue(passbookmaintenance_dao.accountValidation("234568903011"));
	}
	
	
}
