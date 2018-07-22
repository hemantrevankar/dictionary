package com.springboot.app.dictionary;

import java.util.ArrayList;
import java.util.List;

import com.springboot.app.dictionary.model.ApiResponse;
import com.springboot.app.dictionary.model.Entry;
import com.springboot.app.dictionary.model.LexicalEntry;
import com.springboot.app.dictionary.model.Result;
import com.springboot.app.dictionary.model.Sense;
import com.springboot.app.dictionary.model.Subsense;
import com.springboot.app.dictionary.model.Synonym;
import com.springboot.app.dictionary.model.Response;

public class DictionaryUtility {
	public static final String API_HEADER_APP_KEY = "app_key";
	public static final String API_HEADER_APP_ID = "app_id";

	public static Response getSynonymList(ApiResponse apiResponse) {
		List<String> synonyms = new ArrayList<>();
		for (Result result : apiResponse.getResults()) {
			for (LexicalEntry lexicalEntry : result.getLexicalEntries()) {
				for (Entry entry : lexicalEntry.getEntries()) {
					for (Sense sense : entry.getSenses()) {
						for (Synonym s : sense.getSynonyms()) {
							synonyms.add(s.getText());
						}
						if (sense.getSubsenses() != null) {
							for (Subsense ss : sense.getSubsenses()) {
								for (Synonym s : ss.getSynonyms()) {
									synonyms.add(s.getText());
								}
							}
						}
					}
				}
			}
		}
		return new Response(synonyms);
	}

	public static Response getAntonymList(ApiResponse apiResponse) {
		List<String> antonyms = new ArrayList<>();
		for (Result result : apiResponse.getResults()) {
			for (LexicalEntry lexicalEntry : result.getLexicalEntries()) {
				for (Entry entry : lexicalEntry.getEntries()) {
					for (Sense sense : entry.getSenses()) {
						for (Synonym s : sense.getAntonyms()) {
							antonyms.add(s.getText());
						}
					}
				}
			}
		}
		return new Response(antonyms);
	}
}
