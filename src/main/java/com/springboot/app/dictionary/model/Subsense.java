package com.springboot.app.dictionary.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Subsense {
	private Synonym[] synonyms;
	private Synonym[] antonym;

	public Synonym[] getAntonym() {
		return antonym;
	}

	public void setAntonym(Synonym[] antonym) {
		this.antonym = antonym;
	}

	public Synonym[] getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(Synonym[] synonyms) {
		this.synonyms = synonyms;
	}

}