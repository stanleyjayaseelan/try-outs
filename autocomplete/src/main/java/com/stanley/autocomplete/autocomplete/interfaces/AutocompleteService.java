package com.stanley.autocomplete.autocomplete.interfaces;

import com.stanley.autocomplete.autocomplete.model.Suggestion;

public interface AutocompleteService {

	public Suggestion getSuggetions(String query);

}
