package com.springboot.app.dictionary.service;

public interface DictionaryService {
	<T> T getMeaning(String word, Class<T> responseType);
	<T> T getSynonyms(String word, Class<T> responseType);
	<T> T getAntonyms(String word, Class<T> responseType);
}
