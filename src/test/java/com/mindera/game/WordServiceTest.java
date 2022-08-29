package com.mindera.game;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mindera.game.service.WordService;

class WordServiceTest {
	
	WordService wordServcie;
	

    @BeforeEach                                         
    void setUp() {
    	wordServcie = new WordService();
    }
  
    
    @Test      
    @DisplayName("Ensure get all words")
    void testGetWords() {
    	String[]  words = {"apple", "dog", "cat", "book"};
        assertTrue(Arrays.equals(words, wordServcie.getWords()));  
    
    }
    
    @Test                                               
    @DisplayName("Ensure get random word in word list")   
    void testGetRandomWord() {
        String[]  words = {"apple", "dog", "cat", "book"};
        String word = wordServcie.getRandomWord(words);
        assertNotNull(word);
        assertTrue(Arrays.asList(words).contains(word));
    }  
   
}

