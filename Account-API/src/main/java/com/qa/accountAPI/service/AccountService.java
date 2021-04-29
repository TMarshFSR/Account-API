package com.qa.accountAPI.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.accountAPI.domain.Account;
import com.qa.accountAPI.repo.AccountRepo;

@Service
public class AccountService {

	// inject dependencies (services)
	// custom rest template from 'config', used for load balancing and name
	// resolution (i.e. don't need localhost)
	// jms template for messaging
	private AccountRepo repo;
	private final RestTemplate rest;
	private JmsTemplate jms;

	public AccountService(AccountRepo repo, RestTemplate rest, JmsTemplate jms) {
		super();
		this.repo = repo;
		this.rest = rest;
		this.jms = jms;
	}

	public Account register(Account account) {

		String accNumber = this.rest.getForObject("http://number-gen-api/genNum", String.class);
		account.setAccountNumber(accNumber); // sets this as the AccountNumber

		String prizeAsString = this.rest.getForObject("http://prize-gen-api/genPrize/" + accNumber, String.class);
		Integer prize = Integer.parseInt(prizeAsString);
		account.setPrize(prize); // sets the prize

		Account registeredAccount = this.repo.save(account); // saves this instance and returns it
		jms.convertAndSend("account-queue", "" + registeredAccount); // sends account to queue
		return registeredAccount;
	}
}
