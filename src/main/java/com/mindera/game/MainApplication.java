package com.mindera.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.mindera.game.service.GameService;

@SpringBootApplication
public class MainApplication {
	
	@Autowired
	private GameService service;
	
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void runGameAfterStartup() {
		service.startGame();
	}

}
