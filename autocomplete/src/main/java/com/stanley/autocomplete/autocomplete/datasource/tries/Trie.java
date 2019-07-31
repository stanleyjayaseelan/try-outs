package com.stanley.autocomplete.autocomplete.datasource.tries;

import java.util.ArrayList;
import java.util.List;

public class Trie {
	public TrieNode root;

	public Trie() {
		root = new TrieNode(' ');
	}

	public void insertInTrie(String str) {
		int strLen = str.length();
		if (strLen == 0) {
			root.isEndOfString = true;
		} else {
			int i = 0;
			TrieNode current = root, child = null;
			while (i < strLen) {
				child = current.subNode(str.toLowerCase().charAt(i));
				if (child == null) {
					child = new TrieNode(str.toLowerCase().charAt(i));
					current.child.add(child);
				}
				current = child;
				i++;
			}
			current.isEndOfString = true;
			current.leafNodeStr = str.toLowerCase();
		}
	}

	public TrieNode getLocationOfStringInTrie(String str) {
		TrieNode current = this.root, child;
		int strLen = str.length();
		int i = 0;
		while (i < strLen) {
			child = current.subNode(str.toLowerCase().charAt(i));
			if (child != null) {
				current = child;
			} else {
				return null;
			}
			i++;
		}
		if (i == strLen) {
			return current;
		}
		return null;
	}

	public void searchPrefixWords(TrieNode node, List<String> words) {

		if (node.isEndOfString) {
			words.add(node.leafNodeStr);
		}
		for (TrieNode childNode : node.child) {
			searchPrefixWords(childNode, words);
		}

	}

	public boolean searchInTrie(String str) {
		int strLen = str.length();
		if (strLen == 0) {
			return true;
		} else {
			int i = 0;
			TrieNode current = root, child = null;
			while (i < strLen) {
				child = current.subNode(str.charAt(i));
				if (child != null) {
					current = child;
				} else {
					return false;
				}
				i++;
			}
			if (i == strLen) {
				return true;
			}
		}
		return false;
	}

	public List<String> getPrefixWords(Trie trie, String line) {
		List<String> words = new ArrayList<>();
		TrieNode location = trie.getLocationOfStringInTrie(line);
		trie.searchPrefixWords(location, words);
		return words;
	}

}