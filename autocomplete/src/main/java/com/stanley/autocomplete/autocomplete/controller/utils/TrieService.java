package com.stanley.autocomplete.autocomplete.controller.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.stanley.autocomplete.autocomplete.datasource.tries.Trie;

@Component
@Scope("singleton")
public class TrieService {

	private Trie trie = new Trie();

	private void initializeTrie() {
		trie.insertInTrie("analyse");
		trie.insertInTrie("book");
		trie.insertInTrie("extend");
		trie.insertInTrie("append");
		trie.insertInTrie("insert");
		trie.insertInTrie("remove");
		trie.insertInTrie("free");
		trie.insertInTrie("clear");
		trie.insertInTrie("blog");
		trie.insertInTrie("what is autocomplete");
		trie.insertInTrie("start");
		trie.insertInTrie("while");
		trie.insertInTrie("basement");
		trie.insertInTrie("Freedom");
		trie.insertInTrie("what is trie datastructure");
	}

	public TrieService() {
		initializeTrie();
	}

	public Trie getTrie() {
		return trie;
	}
}
