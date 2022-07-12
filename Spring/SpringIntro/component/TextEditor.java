package com.cdac.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("TxtEdtr")
public class TextEditor {

	@Autowired
	private SpellChecker sc;
	
	public void load(String document) {
		System.out.println("some code here for loading " + document);
		
		//SpellChecker sc = new SpellChecker();
		
		sc.checkSpellingMistakes(document);
	}
}
