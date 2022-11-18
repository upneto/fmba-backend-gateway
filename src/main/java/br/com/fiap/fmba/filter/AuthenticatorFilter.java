package br.com.fiap.fmba.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

	private static final List<String> PATHS_TO_VALIDATE = Arrays.asList("cliente", "ordem_servico", "veiculo");
	
	/**
	 * @param httpRequest
	 * @return
	 */
	private boolean verificaSeValidaToken(HttpServletRequest httpRequest) {
		boolean toValidate = false;
	    for(String path : PATHS_TO_VALIDATE) {
	    	if(httpRequest.getRequestURI().contains(path)) {
	    		toValidate = true;
	    		break;
	    	}
	    }
		return false;//toValidate;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpServletResponse httpResponse = (HttpServletResponse) response;

	    LOGGER.info("Request {}", httpRequest.getRequestURI());
	    
	    if(this.verificaSeValidaToken(httpRequest)) {
	    	String token = httpRequest.getHeader("JWT_TOKEN");
	    	LOGGER.info("Is Tokenized {}", (token != null && !token.isEmpty()));
	    	try {			
	    		this.autenticacaoService.verify(new TokenRequest(token));
	    		LOGGER.info("Request Trusted !!!!");
	    		chain.doFilter(request, response);
	    	}catch (Exception e) {
	    		LOGGER.info("Request Fail !!!!");
	    		httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
	    		return;
	    	}
	    }
	    else {
	    	chain.doFilter(request, response);
	    }
	}
}
