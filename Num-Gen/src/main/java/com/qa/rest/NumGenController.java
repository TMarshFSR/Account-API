package com.qa.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.services.NumberGenService;

@RestController
public class NumGenController {

	private NumberGenService service;

	public NumGenController(NumberGenService service) {
		super();
		this.service = service;
	}

	@GetMapping("/genNum")
	public String generateNumber() {
		return this.service.genNumber();
	}
}
