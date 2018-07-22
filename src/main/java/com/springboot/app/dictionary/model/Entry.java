package com.springboot.app.dictionary.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Entry {
	private String[] etymologies;
	private GrammaticalFeature[] grammaticalFeatures;
	private Sense[] senses;

	public String[] getEtymologies() {
		return etymologies;
	}

	public void setEtymologies(String[] etymologies) {
		this.etymologies = etymologies;
	}

	public GrammaticalFeature[] getGrammaticalFeatures() {
		return grammaticalFeatures;
	}

	public void setGrammaticalFeatures(GrammaticalFeature[] grammaticalFeatures) {
		this.grammaticalFeatures = grammaticalFeatures;
	}

	public Sense[] getSenses() {
		return senses;
	}

	public void setSenses(Sense[] senses) {
		this.senses = senses;
	}

}
