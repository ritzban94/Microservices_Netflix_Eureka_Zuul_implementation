package com.zuulproxy.ZuulGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}
	
	@Bean
	public SimplePreFilter preFilter() {
		return new SimplePreFilter();
	}
	
	@Bean
	public SimpleRouteFilter routeFilter() {
		return new SimpleRouteFilter();
	}
	
	@Bean
	public SimplePostFilter postFilter() {
		return new SimplePostFilter();
	}
	
	@Bean
	public SimpleErrorFilter errorFilter() {
		return new SimpleErrorFilter();
	}

}
