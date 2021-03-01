package com.eureka.eurekaClient;

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
public class EurekaClientApplication implements GreetingsController{

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
        SpringApplication.run(EurekaClientApplication.class, args);
        LOG.log(Level.INFO, "Eureka client started");
    }

    @Override
    public String greeting() {
        return "Hello from " + eurekaClient.getApplication(appName).getName() + " and port: " + portNumber;
    }

	@Override
	public String getData() {
		return "Multiple routes example from " + portNumber;
	}

}

