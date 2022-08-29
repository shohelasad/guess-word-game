package com.mindera.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mindera.game.utils.StringUtils;
import com.mindera.game.utils.Utils;

class StringUtilsTest {

	Utils utils;

    @BeforeEach                                         
    void setUp() {
    	utils = new StringUtils();
    	
    }

    
    @Test   
    @DisplayName("Convert char to string conversation")   
    void testConvertToString() {
    	char[] word = {'a','p','p','l','e'};
        assertEquals("apple", utils.convertToString(word), "retrun true");  
	}

    @Test                                               
    @DisplayName("Convert string of array to array list")   
	void testConvertToArrayList() {
    	List<String> wordList = Arrays.asList("apple", "dog", "cat", "book");
    	String[] words = new String[]{"apple", "dog", "cat", "book"};
        assertEquals(wordList, utils.convertToArrayList(words),"retrun true"); 
	}
	
    @Test                                               
    @DisplayName("Ensure char to string conversation")   
	void testGetAsteriskChars() {
    	char[] chars = {'*','*','*','*', '*'};
    	char[] asterisk = utils.getAsteriskChars("apple");
    	assertTrue(Arrays.equals(chars, asterisk));
	}
    
    @Test                                               
    @DisplayName("Ensure asterisk string conversation with matched char")   
    public void testGetConvertedChars() {
      String word = "apple";
      char[] chars = {'*','*','*','*', '*'};
      char[] covertedChars = utils.getMatchedChars(word, chars, 'p');
      char[] expected = {'*','p','p','*', '*'};

      assertTrue(Arrays.equals(expected, covertedChars));
    }

}

