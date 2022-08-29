package com.mindera.game.utils;

import java.util.List;

public interface Utils {

	String convertToString(char[] currentChars);

	List<String> convertToArrayList(String[] words);

	char[] getAsteriskChars(String string);

	char[] getMatchedChars(String word, char[] chars, char inputChar);
	
}
