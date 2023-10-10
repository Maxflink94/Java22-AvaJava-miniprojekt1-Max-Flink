package main;

import java.util.Scanner;

import date.Date;
import time.Time;

// Bygga om med 1 switch?
// använda enums som parametrar i klasserna för att sedan skicka med rätt STATE?

public class Clock {
	
	STATE currentState = STATE.CLOCK;
	
	// SET/SHOW (5 states)
	
	enum STATE {
		CLOCK,
		TIME,
		DATE
	}
		
	void mainLoop() {
		
		String userInput = "";
		Scanner sc = new Scanner(System.in);
		
		Time time = new Time();
		Date date = new Date();
		
		while (!userInput.equals("q")) {
			
			currentState = STATE.CLOCK;
			
			System.out.println("Current state: " + currentState);
			System.out.println("Alternativ:");
			System.out.println("1. Tid");
			System.out.println("2. Datum");
			System.out.println("q. Quit");
			
			userInput = sc.nextLine().trim();
			
			switch (userInput) {
				case "1" : {
					currentState = STATE.TIME;
					System.out.println("Current state: " + currentState);
					
					 time.timeMenu();
		             break;
					}
				case "2" : {
					currentState = STATE.DATE;
					System.out.println("Current state: " + currentState);
						
					date.dateMenu();
					break;
				}
				case "q" : {
					System.out.println("Avslutar programmet");
					break;
				}
				default: {
					System.out.println("Ogiltig val.");
	                break;
				}
			}
		}
		sc.close();
	}
}
