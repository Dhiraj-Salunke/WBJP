package com.cdac.component;

import org.springframework.stereotype.Component;

@Component("spellCkr")
public class SpellChecker {

	public void checkSpellingMistakes(String document) {
		System.out.println("code here for checking spelling" + document);
	}
}
