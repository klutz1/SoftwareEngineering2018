package edu.nd.se2018.homework.homework3;

import java.util.*;
public class Race {
	
	//check for errors before starting race
	public String start(List<Horse> horseList) {	
		if (horseList.size() < 2) {
			System.out.println("There must be more than one horse in a race");
			return "error";
		}
		String horseWinner;
		for (Horse horse: horseList) {
			if (horse.getMaxSpeed() <= 0.0) {
				System.out.println("The horse's speed must be greater than 0");
				return "error";
			}
			if (horse.getName() == "") {
				System.out.println("The horse's name cannot be empty");
				return "error";
			}
		}
		horseWinner = runRace(horseList);
		
		//display winner to console
		System.out.println(horseWinner + " is the winner.");
		return "";
	}
	
	//execute the race with a loop
	public String runRace(List<Horse> horseList) {
		boolean winner = false;
		while (winner == false) {
			for (Horse h: horseList) {
				h.update();
				
				//Winner is declared when they reach 10 miles first
				if (h.getCurrPos() >= 10.0) {
					winner = true;
					return h.getName();
				}		
			}
			System.out.println("");
			try {
				Thread.sleep(50);
			}
			catch(InterruptedException ex) {
					//do nothing
			}
		}
		return "";
	}
	
	
}