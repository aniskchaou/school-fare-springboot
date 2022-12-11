package com.dev.delta.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Expense {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	ExpenseCategory category;
	String name;
	String date;
	String paymentType;
	String amount;
}
