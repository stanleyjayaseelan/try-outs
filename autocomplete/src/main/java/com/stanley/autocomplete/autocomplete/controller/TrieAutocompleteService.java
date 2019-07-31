package com.stanley.autocomplete.autocomplete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stanley.autocomplete.autocomplete.controller.utils.TrieService;
import com.stanley.autocomplete.autocomplete.datasource.tries.Trie;
import com.stanley.autocomplete.autocomplete.interfaces.AutocompleteService;
import com.stanley.autocomplete.autocomplete.model.Suggestion;

@RestController
public class TrieAutocompleteService implements AutocompleteService {

	@Autowired
	private TrieService trieService;

	@Override
	@RequestMapping(name = "/suggestions", method = RequestMethod.GET, produces = "application/json")
	public Suggestion getSuggetions(@RequestParam(name = "query", required = true, defaultValue = "") String query) {
		Suggestion suggestion = new Suggestion();
		Trie trie = trieService.getTrie();
		suggestion.setWords(trie.getPrefixWords(trie, query));
		return suggestion;
	}

}
