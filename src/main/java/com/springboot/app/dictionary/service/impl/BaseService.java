package com.springboot.app.dictionary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.springboot.app.dictionary.service.DictionaryService;

public abstract class BaseService implements DictionaryService {
	private static String baseURL;
	private static String wordEndpoint;
	
	@Autowired
	private RestTemplate restClient;

	@Value("${api.dictionary.base.url}")
	public void setBaseURL(String baseURL) {
		BaseService.baseURL = baseURL;
	}

	@Value("${api.dictionary.word.meaning.endpoint}")
	public void setWordEndpoint(String wordEndpoint) {
		BaseService.wordEndpoint = wordEndpoint;
	}

	protected StringBuilder getWordUrl() {
		StringBuilder urlString = new StringBuilder();
		return urlString.append(baseURL).append(wordEndpoint).append("/en/");
	}

	protected StringBuilder getSynonymUrl(String word) {
		return getWordUrl().append(word).append("/synonyms");
	}

	protected StringBuilder getAntonymUrl(String word) {
		return getWordUrl().append(word).append("/antonyms");
	}
	
	public <T> ResponseEntity<T> executeUrl(String requestUrl, Class<T> responseType) throws RestClientException {
		ResponseEntity<T> jsonResponse = restClient.getForEntity(requestUrl, responseType);
		return jsonResponse;
	}
}
