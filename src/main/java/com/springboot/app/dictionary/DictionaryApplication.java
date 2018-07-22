package com.springboot.app.dictionary;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DictionaryApplication {
	@Autowired
	private ClientHttpRequestInterceptor requestInterceptor;

	public static void main(String[] args) {
		SpringApplication.run(DictionaryApplication.class, args);
	}
	
	@Bean
	public RestTemplate buildRestTemplate() {
		RestTemplate restClient = new RestTemplate();
		restClient.setInterceptors(Arrays.asList(requestInterceptor));
		return restClient;
	}
}
