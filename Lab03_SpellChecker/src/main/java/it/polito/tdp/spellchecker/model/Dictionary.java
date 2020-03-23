package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {

	Set <String> words;
	
	public Dictionary () {
		words = new HashSet <> ();
	}
	
	/**
	 * Function that loads the entire dictionary of the ({@code language}) selected
	 * @param language language to be loaded in the dictionary
	 * @throws IOException
	 */
	public void loadDictionary (String language) throws IOException {
		words.clear();
		if (language.equals("English")) {
			FileReader f = new FileReader ("English.txt");
			BufferedReader b = new BufferedReader (f);
			String str="";
			while ((str=b.readLine())!=null) {
				words.add(str);
			}
			f.close(); b.close();
		}
		else if(language.equals("Italian")) {
			FileReader f = new FileReader ("Italian.txt");
			BufferedReader b = new BufferedReader (f);
			String str="";
			while ((str=b.readLine())!=null) {
				words.add(str);
			}
			f.close(); b.close();
		}
	}
	
	public boolean containsWordRich(WordRich wr) {
		if (words.contains(wr.getWord()))
			return true;
		else 
			return false;
	}
	
	/**
	 * Given an inputTextList, returns an ArrayList of the words that aren't present in 
	 * the dictionary and therefore are wrong
	 * @param inputTextList List of words to be checked if they are correct
	 * @return ArrayList of wrong words
	 */
	public List <WordRich> spellCheckText (List <WordRich> inputTextList) {
		List <WordRich> list = new ArrayList <> ();
		for (WordRich wr : inputTextList) {
			if (containsWordRich(wr)==false) {
				list.add(wr);
			}
		}
		return list;
	}
}
