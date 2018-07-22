package com.springboot.app.dictionary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.dictionary.DictionaryUtility;
import com.springboot.app.dictionary.model.ApiResponse;
import com.springboot.app.dictionary.model.Response;
import com.springboot.app.dictionary.service.DictionaryService;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {
	@Autowired
	private DictionaryService dictionaryService;

	@RequestMapping(value="/get/{word}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse getMeaning(@PathVariable("word") String word) {
		return dictionaryService.getMeaning(word, ApiResponse.class);
	}

	@RequestMapping(value="/get/synonyms/{word}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getSynonyms(@PathVariable("word") String word) {
		return DictionaryUtility.getSynonymList(dictionaryService.getSynonyms(word, ApiResponse.class));
	}

	@RequestMapping(value="/get/antonyms/{word}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getAntonyms(@PathVariable("word") String word) {
		return DictionaryUtility.getAntonymList(dictionaryService.getAntonyms(word, ApiResponse.class));
	}
}
