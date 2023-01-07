package br.com.fiap.fmba.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ulisses P S Neto
 */
public abstract class AbstractController {

//	@Autowired
//	private HttpServletRequest request = null;
//	
//	@Autowired
//	private AutenticacaoService autenticacaoService = null;
//	
	/** Logger */
	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractController.class);
//
//	/**
//	 * Autentica a requisição pelo token JWT
//	 */
//	public void doAutentica() throws AutenticatorException {
//		
//	    LOGGER.info("Request {}", this.request.getRequestURI());
//	    	    
//    	String token = this.request.getHeader("JWT_TOKEN");
//    	LOGGER.info("Is Tokenized {}", (token != null && !token.isEmpty()));
//    	try {			
//    		this.autenticacaoService.verify(new TokenRequest(token));
//    		LOGGER.info("Request Trusted !!!!");
//    	}catch (Exception e) {
//    		LOGGER.error("Request Fail !!!! ", e);
//    		throw new AutenticatorException(e.getMessage(), e);	    		
//    	}
//	}
}
