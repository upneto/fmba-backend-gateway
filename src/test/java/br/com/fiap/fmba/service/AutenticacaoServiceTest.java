package br.com.fiap.fmba.service;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.fmba.controller.payload.autenticacao.LoginRequest;
import br.com.fiap.fmba.controller.payload.autenticacao.LoginResponse;
import br.com.fiap.fmba.resources.exception.AutenticatorException;

public class AutenticacaoServiceTest {

//	@TestConfiguration
//    static class AutenticacaoServiceTestConfiguration {        
//		
//		@Bean
//        public AutenticacaoService autenticacaoService() {
//            return new AutenticacaoService();
//        }
//    }
//	
//	@Autowired
//	private AutenticacaoService service;
//	
//	private RestTemplate restTemplate;
//	
//	@Before
//	public void setUp() throws Exception {
//		this.restTemplate = Mockito.mock(RestTemplate.class);
//		ReflectionTestUtils.setField(service, "rest", this.restTemplate);
//	}
//
//	@Test
//	public void testLogin() throws AutenticatorException {
//		
//		LoginResponse obj = LoginResponse.builder()
//				.nome("Mock nome")
//				.token("Mock token")
//				.build();
//		
//		Mockito.when(this.restTemplate.exchange(Mockito.anyString(), HttpMethod.POST, Mockito.any(), LoginResponse.class))
//			.thenReturn(new ResponseEntity<LoginResponse>(obj, HttpStatus.OK));
//		
//		LoginResponse result = this.service.login(LoginRequest.builder().build());
//		assertEquals(result, obj);
//	}
//
//	@Test
//	public void testVerify() {
//		fail("Not yet implemented");
//	}

}
