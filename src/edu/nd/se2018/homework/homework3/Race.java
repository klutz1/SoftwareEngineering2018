package edu.nd.se2018.homework.homework3;

import java.util.*;
public class Race {
	
	public String start(List<Horse> horseList) {	
		String horseWinner;
		for (Horse horse: horseList) {
			if (horse.maxSpeed <= 0.0) {
				System.out.println("The horse's speed must be greater than 0");
				return "error";
			}
		}
		horseWinner = runRace(horseList);
		System.out.println(horseWinner + " is the winner.");
		return "";
	}
	public String runRace(List<Horse> horseList) {
		boolean winner = false;
		while (winner == false) {
			for (Horse h: horseList) {
				h.update();
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