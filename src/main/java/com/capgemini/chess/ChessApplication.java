package com.capgemini.chess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@ComponentScan("com.capgemini")
@SpringBootApplication
public class ChessApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessApplication.class, args);
	}
}
