package com.mindera.game.service;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindera.game.utils.Utils;

@Service
public class GameService {

	//life line defined hard code
	public static int lifeLine = 5;

	@Autowired
	private WordService wordService;

	private Scanner scanner;

	private Utils utils;

	public GameService(Utils utils) {
		this.utils = utils;
	}

	public void startGame() {
		scanner = new Scanner(System.in);
		String[] words = wordService.getWords();
		System.out.println("Word list:");
		System.out.println(utils.convertToArrayList(words));
		System.out.println("User Interation:");

		while (true) {
			System.out.print("Guess the word:");
			String word = wordService.getRandomWord(words);
			// currentWord Is the representation of an asterisk
			char[] asterikChars = utils.getAsteriskChars(word);
			System.out.println(utils.convertToString(asterikChars));
			//execute the game
			int remainLife = lifeLine;
			Set<Character> inputSet = new HashSet<>();	
			while(remainLife > 0) {
				String input = scanner.next();
				char inputChar = input.charAt(0);
				if (duplicateGuess(inputSet,inputChar)) {
					System.out.println("You have already tried this letter");
					continue;
				}
				remainLife--;
				char[] chars = processGuessChar(word, asterikChars, inputChar, remainLife);
				if (new String(chars).equals(word)) {
					System.out.println("You have won the game. The word was " + word);
					break;
				}	
			}
		}
	}
	
	public boolean duplicateGuess(Set<Character> inputSet, char inputChar) {
		if (inputSet.contains(inputChar)) {
			return true;
		}
		inputSet.add(inputChar);
		
		return false;
	}

	public char[] processGuessChar(String word, char[] chars, char inputChar, int remainLife) {
		if (word.indexOf(inputChar) != -1) {
			System.out.print("Correct. ");
			chars = utils.getMatchedChars(word, chars, inputChar);
			System.out.println(utils.convertToString(chars));
		} else {
			System.out.print("Incorrect " + (lifeLine - remainLife) + " life lost. " + remainLife
					+ " remaining. The current word is ");
			System.out.println(utils.convertToString(chars));
		}

		return chars;
	}
}
