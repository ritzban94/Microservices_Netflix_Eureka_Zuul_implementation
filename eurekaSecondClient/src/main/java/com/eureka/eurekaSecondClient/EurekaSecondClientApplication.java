package com.eureka.eurekaSecondClient;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaSecondClientApplication implements SecondController{
	
	@Autowired
    @Lazy
    private EurekaClient eurekaClient;
	
	private final static Logger LOG =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Value("${spring.application.name}")
    private String appName;
    
    @Value("${server.port}")
    private String portNumber;
    
	public static void main(String[] args) {
		SpringApplication.run(EurekaSecondClientApplication.class, args);
		LOG.log(Level.INFO, "Eureka second client started");
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
	    return "Hello from " + eurekaClient.getApplication(appName).getName() + " and port: " + portNumber;
	}

}
