package com.springboot.app.dictionary.model;

import java.util.List;

public class Response {
	List<String> synonyms;

	public Response(List<String> synonyms) {
		this.synonyms = synonyms;
	}

	public List<String> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(List<String> synonyms) {
		this.synonyms = synonyms;
	}

}
