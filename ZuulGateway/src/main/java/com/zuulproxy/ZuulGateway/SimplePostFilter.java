package com.zuulproxy.ZuulGateway;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class SimplePostFilter extends ZuulFilter{

	private final static Logger LOG =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		LOG.log(Level.INFO, "Inside post filter");
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
