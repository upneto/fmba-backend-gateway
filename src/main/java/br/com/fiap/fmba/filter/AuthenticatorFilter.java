package br.com.fiap.fmba.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.fiap.fmba.controller.payload.autenticacao.TokenRequest;
import br.com.fiap.fmba.service.AutenticacaoService;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthenticatorFilter implements Filter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticatorFilter.class);
	
	@Autowired
	private AutenticacaoService autenticacaoService = null;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpServletResponse httpResponse = (HttpServletResponse) response;

	    LOGGER.info("Logging Request  {} : {}", httpRequest.getMethod(), httpRequest.getRequestURI());
	    
	    if(httpRequest.getRequestURI().startsWith("/api")) {
	    	String token = httpRequest.getHeader("JWT_TOKEN");	    
	    	try {			
	    		this.autenticacaoService.verify(new TokenRequest(token));
	    		chain.doFilter(request, response);
	    	}catch (Exception e) {
	    		httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
	    		return;
	    	}
	    }
	    chain.doFilter(request, response);		
	}

}
