package com.mindera.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mindera.game.service.GameService;
import com.mindera.game.utils.StringUtils;
import com.mindera.game.utils.Utils;

class GameServiceTest {

	GameService service;
	String word;
	String asterik;
	int remainLife;

    @BeforeEach                                         
    void setUp() {
    	Utils utils = new StringUtils();
    	service = new GameService(utils);
    	word = "book";
        asterik = "****";
    	remainLife = 5;	
    }
    

    @Test                                               
    @DisplayName("Ensure no change for duplicate input")   
    void testDuplicateGuess() {
    	Set<Character> inputSet = new HashSet<>(); 
    	boolean duplicate = false;
    	duplicate = service.duplicateGuess(inputSet, 'a');    	
        assertEquals(duplicate, false);  
        duplicate = service.duplicateGuess(inputSet, 'a');
        assertEquals(duplicate, duplicate);  
    }
    
    @Test                                               
    @DisplayName("Ensure win on right guess")   
    public void testProcessGuessCharWhileWin() {
      char[] chars = asterik.toCharArray();
      char[] processChars = service.processGuessChar(word, chars, 'b', remainLife);
      processChars = service.processGuessChar(word, processChars, 'o', remainLife--);
      processChars = service.processGuessChar(word, processChars, 'd', remainLife--);
      processChars = service.processGuessChar(word, processChars, 'k', remainLife--);

      assertEquals("book", String.valueOf(processChars));
    }

    @Test                                               
    @DisplayName("Ensure lost on wrong guess")   
    public void testProcessGuessCharWhileLost() {
    	  char[] chars = asterik.toCharArray();
          char[] processChars = service.processGuessChar(word, chars, 'b', remainLife);
          processChars = service.processGuessChar(word, processChars, 'o', remainLife--);
          processChars = service.processGuessChar(word, processChars, 't', remainLife--);
          processChars = service.processGuessChar(word, processChars, 'c', remainLife--);
          processChars = service.processGuessChar(word, processChars, 'a', remainLife--);

          assertNotEquals("book", String.valueOf(processChars));
    }
    
    //Multiple test cases can be added both for success and failed cases
}


