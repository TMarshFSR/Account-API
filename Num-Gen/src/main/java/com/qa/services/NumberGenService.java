package com.qa.services;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class NumberGenService {

	private Random random = new Random();

	private final String[] characters = { "a", "b", "c" };

	public String genNumber() {
		String accountNumber = "";

		accountNumber += characters[random.nextInt(3)];

		// numDigits will equal either 6,8 or 10
		int numDigits = 0;
		numDigits = 6 + (random.nextInt(3) * 2);

		// loops through 0 to numDigits, and assigns a random number per loop
		for (int i = 0; i < numDigits; i++) {
			accountNumber += random.nextInt(10);
		}

		return accountNumber;
	}

}
