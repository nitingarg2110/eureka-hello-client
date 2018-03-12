package com.nitin.eureka.eurekahelloclient.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nitin.eureka.eurekahelloclient.service.HelloResourceService;

@RestController
@RequestMapping("/rest/hello/client")
public class HelloResource {

	private static Logger LOGGER = LoggerFactory.getLogger(HelloResource.class.getName());
	
	@Autowired
	private HelloResourceService helloResourceService;

	@GetMapping
	public String hello() {
		LOGGER.info("Inside hello Method of Resource");
		return helloResourceService.hello();

	}

}
