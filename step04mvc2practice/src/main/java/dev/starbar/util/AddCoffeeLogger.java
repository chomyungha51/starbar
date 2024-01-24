package dev.starbar.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddCoffeeLogger implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Logger logger = LoggerFactory.getLogger(AddCoffeeLogger.class);
		logger.info("ADD NAME=" + request.getParameter("coffeeName")+" SIZE= " + request.getParameter("coffeeSize")
				+" PRICE = "+ request.getParameter("coffeePrice"));
		chain.doFilter(request, response);

	}

}
