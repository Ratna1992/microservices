package com.ratna.microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ratna.microservices.bean.ExchangeValue;
import com.ratna.microservices.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Environment prop;

	@Autowired
	CurrencyExchangeService currencyExchangeService;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = currencyExchangeService.retrieveExchangeValue(from, to);
		exchangeValue.setPort(Integer.parseInt(prop.getProperty("local.server.port")));
		logger.debug("{}",exchangeValue);
		return exchangeValue;
	}
}
