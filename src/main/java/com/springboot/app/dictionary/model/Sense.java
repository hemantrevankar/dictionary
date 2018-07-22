package com.springboot.app.dictionary.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Sense {
	private String[] definitions;
	private Text[] examples;
	private GrammaticalFeature[] notes;
	@JsonProperty("short_definitions")
	private String[] shortDefinitions;
	private Subsense[] subsenses;
	private Synonym[] synonyms;
	private Synonym[] antonyms;

	public Synonym[] getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(Synonym[] synonyms) {
		this.synonyms = synonyms;
	}

	public Synonym[] getAntonyms() {
		return antonyms;
	}

	public void setAntonyms(Synonym[] antonyms) {
		this.antonyms = antonyms;
	}

	public Subsense[] getSubsenses() {
		return subsenses;
	}

	public void setSubsenses(Subsense[] subsenses) {
		this.subsenses = subsenses;
	}

	public String[] getDefinitions() {
		return definitions;
	}

	public void setDefinitions(String[] definitions) {
		this.definitions = definitions;
	}

	public Text[] getExamples() {
		return examples;
	}

	public void setExamples(Text[] examples) {
		this.examples = examples;
	}

	public GrammaticalFeature[] getNotes() {
		return notes;
	}

	public void setNotes(GrammaticalFeature[] notes) {
		this.notes = notes;
	}

	public String[] getShortDefinitions() {
		return shortDefinitions;
	}

	public void setShortDefinitions(String[] shortDefinitions) {
		this.shortDefinitions = shortDefinitions;
	}

}
