package br.com.fiap.fmba.service;

import java.util.List;
import java.util.Map.Entry;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractService {

	/**
	 * Constroi String com parametros (Query Param)
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String buildParans(Entry<String, Object>... params) {
		StringBuilder sb = new StringBuilder();
		for(Entry<String, Object> param : params) {
			if(!sb.toString().isEmpty()) {
				sb.append("&");
			}
			sb.append(param.getKey()).append("=").append(param.getValue());
		}
		return sb.toString();
	}
	
	/**
	 * GET
	 * @param <RESPONSE>
	 * @param url
	 * @param listResponseClass
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <RESPONSE> List<RESPONSE> doGet(String url, List<RESPONSE> listResponseClass, Entry<String, Object>... params) {
		StringBuilder finalUrl = new StringBuilder(url);
		if(params != null && params.length > 0) {
			finalUrl.append("?").append(this.buildParans(params));
		}
		RestTemplate rest = new RestTemplate();
		return rest.getForObject(finalUrl.toString(), listResponseClass.getClass());
	}
	
	/**
	 * GET
	 * @param <T>
	 * @param url
	 * @param responseClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <RESPONSE> RESPONSE doGet(String url, Class<RESPONSE> responseClass, Entry<String, Object>... params) {
		StringBuilder finalUrl = new StringBuilder(url);
		if(params != null && params.length > 0) {
			finalUrl.append("?").append(this.buildParans(params));
		}
		RestTemplate rest = new RestTemplate();
		return rest.getForObject(finalUrl.toString(), responseClass);
	}
	
	/**
	 * POST
	 * @param <RESPONSE>
	 * @param <BODY>
	 * @param url
	 * @param responseClass
	 * @param body
	 * @return
	 */
	protected <RESPONSE, BODY> RESPONSE doPost(String url, Class<RESPONSE> responseClass, BODY body) {
		RestTemplate rest = new RestTemplate();
		HttpEntity<BODY> request = new HttpEntity<>(body);
		return rest.postForObject(url, request, responseClass);
	}
	
	/**
	 * PUT
	 * @param <RESPONSE>
	 * @param <BODY>
	 * @param url
	 * @param responseClass
	 * @param body
	 * @return
	 */
	protected <BODY> void doPut(String url, BODY body) {
		RestTemplate rest = new RestTemplate();
		HttpEntity<BODY> request = new HttpEntity<>(body);
		rest.put(url, request);
	}
	
	/**
	 * Delete
	 * @param url
	 * @return
	 */
	protected void doDelete(String url) {
		RestTemplate rest = new RestTemplate();
		rest.delete(url);
	}
	
}
