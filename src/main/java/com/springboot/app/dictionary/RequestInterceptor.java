package com.springboot.app.dictionary;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class RequestInterceptor implements ClientHttpRequestInterceptor {
	@Value("${api.dictionary.app.key}")
	private String app_key;
	
	@Value("${api.dictionary.app.id}")
	private String app_id;

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		request.getHeaders().add(DictionaryUtility.API_HEADER_APP_ID, app_id);
		request.getHeaders().add(DictionaryUtility.API_HEADER_APP_KEY, app_key);
		return execution.execute(request, body);
	}

}
