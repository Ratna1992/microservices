package com.ratna.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ratna.microservices.bean.LimitConfiguration;
import com.ratna.microservices.configuration.Configuration;

@RestController
public class LimitsConfigurationController {
	@Autowired
	Configuration configuration;

	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}

	@GetMapping("/limits-error-callback")
	@HystrixCommand(fallbackMethod = "fallBackMethodHandler")
	public LimitConfiguration callback() {
		throw new RuntimeException("Not Available");
	}

	public LimitConfiguration fallBackMethodHandler() {
		return new LimitConfiguration(10000, 100);
	}

}
