package br.com.fiap.fmba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import br.com.fiap.fmba.controller.payload.ordemservico.OrdemServicoRequest;
import br.com.fiap.fmba.resources.exception.BusinessException;
import br.com.fiap.fmba.resources.exception.WebServiceException;
import br.com.fiap.fmba.service.payload.OrdemServicoPayload;

@Service
public class FilaOrdemServicoService extends AbstractService {

	@Autowired
	public FilaOrdemServicoService(RestTemplateBuilder builder) {
	    super(builder);
	}
	
	/**
	 * Variavel injetada pelo contexto Spring
	 * 		'env' = variavel injetada da runtime jvm
	 * 		'.url.backend.ordem_servico' = arquivo application.properties  
	 */
	@Value("${${env}.url.backend.fila_ordem_servico}") 
	private String url = null;
	
	/**
	 * Insert
	 * @param ordemServico
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	public void send(OrdemServicoRequest ordemServico) throws WebServiceException, BusinessException {
		try {
			super.doPost(this.url, OrdemServicoPayload.class, ordemServico);
		}catch (Exception e) {
			throw new WebServiceException(e.getMessage(), e);
		}		
	}
}
