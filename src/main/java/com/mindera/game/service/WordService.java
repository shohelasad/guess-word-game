package com.mindera.game.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class WordService {
	
	//for simplicity words are defined in static string array. words can be read from a file/database/dictionary
	public static String[] words = {"apple", "dog", "cat", "book"};

	public String[] getWords() {
	    //for simplicity return from static array of string 
		return words;
	}
	
	public String getRandomWord(String[] words) {
		Random random = new Random();
		int length = random.nextInt(words.length);
		String word = words[length];

		return word;
	}

}
