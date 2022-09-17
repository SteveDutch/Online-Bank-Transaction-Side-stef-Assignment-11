package com.codercampus.Assignment11.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository = new TransactionRepository();
	
	public Transaction findById(Long transactionId) {
		return transactionRepository.findById(transactionId);
		
	}
	
	public TransactionRepository sortByDate (TransactionRepository transRepo) {
		transRepo.findAll().sort(Comparator.comparing(Transaction::getDate));
		System.out.println(transRepo.toString() + "from tansSe.rortbyDate");
		return transRepo;
//		return transactions.stream()
//			      .sorted()
//			      .collect(Collectors.toList());
	}


}
