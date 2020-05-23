package com.ratna.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratna.microservices.bean.ExchangeValue;
import com.ratna.microservices.repository.ExchangeValueRepository;

@Service
public class CurrencyExchangeService {

	@Autowired
	ExchangeValueRepository exchangeValueRepository;

	public ExchangeValue retrieveExchangeValue(String fromCurrency, String toCurrency) {
		return exchangeValueRepository.findByFromAndTo(fromCurrency, toCurrency);

	}
}
