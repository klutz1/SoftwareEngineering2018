package edu.nd.se2018.homework.homework3;

import java.util.ArrayList;
import java.util.List;

public class Main {												//Main executes a sample race
	public static void main(String args[]) {
		String output;
		
		//data structure to store horses
	    List<Horse> horseList = new ArrayList<Horse>();
		Horse h1 = new Horse("Blizzard", 25, new SlowStartStrategy());
		Horse h2 = new Horse("Snap", 35, new SteadyRunStrategy());
		Horse h3 = new Horse("Katie", 22, new EarlySprintStrategy());
		
		//add each of the horses to the list
		horseList.add(h1);
		horseList.add(h2);
		horseList.add(h3);
		
		Race myrace = new Race();
		
		//start the race but check for any errors first
		if (myrace.start(horseList) == "error") {
			System.exit(0);
		};
	}
}