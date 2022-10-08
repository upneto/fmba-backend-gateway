package br.com.fiap.fmba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.fiap.fmba.controller.payload.ordem.OrdemServicoPayload;
import br.com.fiap.fmba.resources.exception.BusinessException;
import br.com.fiap.fmba.resources.exception.WebServiceException;

@Service
public class OrdemServicoService extends AbstractService {
	
	/**
	 * Variavel injetada pelo contexto Spring
	 * 		'env' = variavel injetada da runtime jvm
	 * 		'.url.backend.ordem_servico' = arquivo application.properties  
	 */
	@Value("${${env}.url.backend.ordem_servico}")
	private String url = null;

	/**
	 * Find
	 * @param id
	 * @return
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public OrdemServicoPayload find(long id) throws WebServiceException, BusinessException {		
		try {
			return super.doGet(this.url + id, OrdemServicoPayload.class);
		}catch (Exception e) {
			throw new WebServiceException(e.getMessage(), e);
		}		
	}

	/**
	 * Find All
	 * @return
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public List<OrdemServicoPayload> findAll() throws WebServiceException, BusinessException {
		try {
			return super.doGet(this.url, new ArrayList<OrdemServicoPayload>());
		}catch (Exception e) {
			throw new WebServiceException(e.getMessage(), e);
		}		
	}

	/**
	 * Insert
	 * @param ordemServico
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	public void insert(OrdemServicoPayload ordemServico) throws WebServiceException, BusinessException {
		try {
			super.doPost(this.url, OrdemServicoPayload.class, ordemServico);
		}catch (Exception e) {
			throw new WebServiceException(e.getMessage(), e);
		}		
	}

	/**
	 * Update
	 * @param ordemServico
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	public void update(OrdemServicoPayload ordemServico) throws WebServiceException, BusinessException {
		try {
			super.doPut(this.url, ordemServico);
		}catch (Exception e) {
			throw new WebServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Delete
	 * @param id
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	public void delete(long id) throws WebServiceException, BusinessException {
		try {
			super.doDelete(this.url);
		}catch (Exception e) {
			throw new WebServiceException(e.getMessage(), e);
		}
	}
}
