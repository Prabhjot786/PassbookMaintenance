package com.cg.pecuniabank.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.pecuniabank.dto.Transaction;

public interface PassbookMaintenanceService
{
	public List<Transaction> updatePassbook(String accountId);
	public List<Transaction> accountSummary(String accountId,LocalDate startDate,LocalDate endDate);
}