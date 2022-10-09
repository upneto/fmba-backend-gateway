package br.com.fiap.fmba.resources.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.fiap.fmba.resources.exception.AutenticatorException;
import br.com.fiap.fmba.resources.exception.BusinessException;
import br.com.fiap.fmba.resources.exception.WebServiceException;
import br.com.fiap.fmba.resources.exception.handler.payload.ExceptionResponsePayload;

/**
 * @author Ulisses Neto
 */
@RestController
@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Manipulador de exceção para erros do tipo 'AppException'
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(AutenticatorException.class)
	public final ResponseEntity<ExceptionResponsePayload> handleAppExceptions(AutenticatorException exception, WebRequest request){		
		return new ResponseEntity<ExceptionResponsePayload>(ExceptionResponsePayload.builder()
				.code(HttpStatus.UNAUTHORIZED.value())
				.description(exception.getMessage())
				.exception(exception)
				.build(), HttpStatus.UNAUTHORIZED);
	}
	
	/**
	 * Manipulador de exceção para erros do tipo 'AppException'
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)
	public final ResponseEntity<ExceptionResponsePayload> handleAppExceptions(BusinessException exception, WebRequest request){		
		return new ResponseEntity<ExceptionResponsePayload>(ExceptionResponsePayload.builder()
				.code(HttpStatus.UNAUTHORIZED.value())
				.description(exception.getMessage())
				.exception(exception)
				.build(), HttpStatus.UNAUTHORIZED);
	}
	
	/**
	 * Manipulador de exceção para erros do tipo 'AppException'
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(WebServiceException.class)
	public final ResponseEntity<ExceptionResponsePayload> handleAppExceptions(WebServiceException exception, WebRequest request){		
		return new ResponseEntity<ExceptionResponsePayload>(ExceptionResponsePayload.builder()
				.code(HttpStatus.UNAUTHORIZED.value())
				.description(exception.getMessage())
				.exception(exception)
				.build(), HttpStatus.UNAUTHORIZED);
	}
	
}
