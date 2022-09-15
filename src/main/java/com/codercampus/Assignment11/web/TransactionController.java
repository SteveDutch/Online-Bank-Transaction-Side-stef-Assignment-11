package com.codercampus.Assignment11.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Controller
public class TransactionController {
	
	TransactionRepository transRepo = new TransactionRepository();
	
	@GetMapping("/transactions")
	public String getTransactions (ModelMap model) {
		List<Transaction> history = transRepo.findAll();
		System.out.println(history);
		Transaction transaction = new Transaction();
		model.put("transaction", transaction);
		model.put("history", history);
		return "transactions";
	}

}
