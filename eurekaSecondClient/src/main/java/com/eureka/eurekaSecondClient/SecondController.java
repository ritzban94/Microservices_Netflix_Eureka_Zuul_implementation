package com.eureka.eurekaSecondClient;

import org.springframework.web.bind.annotation.RequestMapping;

public interface SecondController {

	@RequestMapping("/secondClient")
	String getMessage();
}
