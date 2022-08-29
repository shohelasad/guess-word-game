package com.mindera.game.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StringUtils implements Utils {

	@Override
	public String convertToString(char[] chars) {
		String string = new String(chars);
		
		return string;
	}

	@Override
	public List<String> convertToArrayList(String[] strings) {
		List<String> stringList = new ArrayList<String>(Arrays.asList(strings));
		
		return stringList;
	}
	
	@Override
	public char[] getAsteriskChars(String string) {
		char[] chars = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {
			chars[i] = '*';
		}
		
		return chars;
	}
	
	@Override
	public char[] getMatchedChars(String word, char[] chars, char inputChar) {
		for (int j = 0; j < word.length(); j++) {
			if (inputChar == word.charAt(j))
				chars[j] = inputChar;
		}
		
		return chars;
	}

}
