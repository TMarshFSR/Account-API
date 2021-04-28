package com.qa.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.services.PrizeGenService;

@RestController
public class PrizeGenController {

	private PrizeGenService service;

	public PrizeGenController(PrizeGenService service) {
		super();
		this.service = service;
	}

	@GetMapping("/genPrize/{accNumber}")
	public String generatePrize(@PathVariable String accNumber) {
		return "" + this.service.genPrize(accNumber);

		// or "return String.valueOf(this.service.genPrize(accNumber));"
	}

}
