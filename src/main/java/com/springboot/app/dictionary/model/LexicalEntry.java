package com.springboot.app.dictionary.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class LexicalEntry {
	private Entry[] entries;

	public Entry[] getEntries() {
		return entries;
	}

	public void setEntries(Entry[] entries) {
		this.entries = entries;
	}

}
