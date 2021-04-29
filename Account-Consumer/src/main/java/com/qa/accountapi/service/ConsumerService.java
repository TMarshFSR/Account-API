package com.qa.accountapi.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

	@JmsListener(destination = "account-queue")
	public void receiveAccount(String account) {
		System.out.println("Received <" + account + ">");
	}

}
