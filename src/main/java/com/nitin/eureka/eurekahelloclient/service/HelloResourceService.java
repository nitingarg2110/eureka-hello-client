package com.nitin.eureka.eurekahelloclient.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloResourceService {

	private static Logger LOGGER = LoggerFactory.getLogger(HelloResourceService.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallBack")
	public String hello() {
		LOGGER.info("Inside hello Method of Service");
		String url = "http://HELLO-SERVER-EUREKA-EXAMPLE/rest/hello/server";
		return restTemplate.getForObject(url, String.class);
	}

	public String fallBack() {
		LOGGER.info("Inside hello Method fallback Service");
		return "Fallback Hello World!";
	}

}
