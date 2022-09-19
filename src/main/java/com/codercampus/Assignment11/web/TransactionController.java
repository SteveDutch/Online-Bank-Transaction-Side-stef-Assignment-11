package com.codercampus.Assignment11.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionController {
	
	@Autowired
	TransactionService transactionService = new TransactionService();
	TransactionRepository transRepo = new TransactionRepository();
	
	@GetMapping("/transactions")
	public String getTransactions (ModelMap model) {
		List<Transaction> history = transactionService.sortByDate(transRepo).findAll();
		System.out.println(history);
		Transaction transaction = new Transaction();
		model.put("transaction", transaction);
		model.put("history", history);
		return "transactions";
	}
	// FIXME click on ID zeigt nächsthöhere IF / ID+1
	@GetMapping("/transactions/{transactionId}")
	public String getId (@PathVariable Long transactionId, ModelMap model) {
		Transaction transaction = transactionService.findById(transactionId);
		model.put("transaction", transaction);
		return "transactionID";
	}

}
