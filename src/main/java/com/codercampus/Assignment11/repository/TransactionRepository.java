package com.codercampus.Assignment11.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.codercampus.Assignment11.domain.Transaction;

@Repository
public class TransactionRepository {
	private List<Transaction> transactions = new ArrayList<>(100);
	@Value("${file.name}")
	private String fileName;
	
	
	public TransactionRepository() {
		super();
		populateData();
	}

	public List<Transaction> findAll() {
		return transactions;
	}

	@SuppressWarnings("unchecked")
	private void populateData() {
		System.out.println(fileName);

		// TODO transactions.txt in application file & clear why it's not working with
		// @value annotation?
		
		try (FileInputStream fileInputStream = new FileInputStream(fileName);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
			this.transactions = (List<Transaction>) objectInputStream.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Transaction findById(Long transactionId) {
		return transactions.get(transactionId.intValue());
	}

}
