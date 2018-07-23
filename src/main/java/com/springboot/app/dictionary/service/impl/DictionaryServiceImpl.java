package com.springboot.app.dictionary.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

@Component
public class DictionaryServiceImpl extends BaseService {
	private static final Logger logger = LoggerFactory.getLogger(DictionaryServiceImpl.class);

	@Override
	public <T> T getMeaning(String word, Class<T> responseType) {
		String requestUrl = getWordUrl().append(word).toString();
		return getData(requestUrl, responseType);
	}

	@Override
	public <T> T getSynonyms(String word, Class<T> responseType) {
		String requestUrl = getSynonymUrl(word).toString();
		return getData(requestUrl, responseType);
	}

	@Override
	public <T> T getAntonyms(String word, Class<T> responseType) {
		String requestUrl = getAntonymUrl(word).toString();
		return getData(requestUrl, responseType);
	}

	public <T> T getData(String requestUrl, Class<T> responseType) {
		try {
			ResponseEntity<T> jsonResponse = executeUrl(requestUrl, responseType);
			return jsonResponse.getBody();
		} catch (RestClientException ex) {
			logger.error("Error occurred while getting the dictionary meaning");
			throw ex;
		}
	}
	
}
