package com.cg.pecuniabank.servicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.cg.pecuniabank.dto.Transaction;
import com.cg.pecuniabank.service.PassbookMaintenanceServiceImpl;

public class PassbookMaintenanceServiceImplTest {
	
	  PassbookMaintenanceServiceImpl service=new PassbookMaintenanceServiceImpl();

	
	
	@Test
	public void validateTest1()
	{
		assertTrue(service.validate(LocalDate.of(2020,05,03)));
	}
	
	@Test
	public void accountSummaryTest()
	{
		List<Transaction> list1=new ArrayList<Transaction>();
		Assert.assertEquals(list1,service.accountSummary("234568903011",LocalDate.of(2020,02,17) ,LocalDate.of(2020,02,17) ));
	}
	
}
