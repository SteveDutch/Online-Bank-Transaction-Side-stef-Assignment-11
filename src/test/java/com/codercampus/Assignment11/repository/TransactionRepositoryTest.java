package com.codercampus.Assignment11.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.codercampus.Assignment11.domain.Transaction;

class TransactionRepositoryTest {

	@Test
	void testTransactionRepository() {
		
		TransactionRepository sut = new TransactionRepository();
		List<Transaction> testList = sut.findAll();
		boolean exspectedResult;
		if (testList.isEmpty()) {
			exspectedResult = false;} 
		else {exspectedResult = true;}
		assertEquals(true, exspectedResult);
		}

	

}

