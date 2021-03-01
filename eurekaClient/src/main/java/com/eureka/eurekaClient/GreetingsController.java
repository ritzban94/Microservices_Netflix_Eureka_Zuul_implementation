package com.eureka.eurekaClient;

import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingsController {
	@RequestMapping("/greeting")
    String greeting();
	
	@RequestMapping("/getData")
    String getData();
}
