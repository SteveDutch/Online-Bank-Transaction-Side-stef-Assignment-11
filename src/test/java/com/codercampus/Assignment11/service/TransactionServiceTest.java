package com.codercampus.Assignment11.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.codercampus.Assignment11.repository.TransactionRepository;

class TransactionServiceTest {

	@Test
	void testSortByDate() {
		TransactionService transSe = new TransactionService();
		TransactionRepository sut = new TransactionRepository();
		
		transSe.sortByDate(sut);
		
		boolean exspectedResult;
		if (sut.findById((long) 1).getDate().isBefore(sut.findById((long) 99).getDate())) {
			exspectedResult = true;} else {exspectedResult = false;}
		System.out.println(sut.findById((long) 1).getDate());
		System.out.println(sut.findById((long) 99).getDate());
		assertEquals(true, exspectedResult);
	}

}
