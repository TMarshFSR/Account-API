package com.qa.accountAPI.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.accountAPI.domain.Account;
import com.qa.accountAPI.service.AccountService;

@CrossOrigin
@RestController
public class AccountController {

	private AccountService service;

	public AccountController(AccountService service) {
		super();
		this.service = service;
	}

	@PostMapping("/register")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account registeredAccount = this.service.register(account);
		return new ResponseEntity<Account>(registeredAccount, HttpStatus.CREATED);

	}

}
