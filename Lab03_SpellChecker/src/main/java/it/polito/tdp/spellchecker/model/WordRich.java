package it.polito.tdp.spellchecker.model;

public class WordRich {
	
	String word;
	
	public WordRich (String word) {
		this.word=word;
	}

	public String getWord() {
		return this.word;
	}
	
	public static WordRich toWordRich (String s) {
		return new WordRich(s);
	}

}
