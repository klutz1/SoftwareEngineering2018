package edu.nd.se2018.homework.homework3;

import java.util.*;
public class Race {
	
	private Horse h1;
	private Horse h2;
	
	List<Horse> horseList = new ArrayList<Horse>();
	
	public void start() {	
		boolean winner = false;
		
		//add horses to race
		Horse h1 = new Horse("Blizzard", 3, 25, new SlowStartStrategy());
		Horse h2 = new Horse("Flicker", 2, 25, new SteadyRunStrategy());
		Horse h3 = new Horse("Claire", 3, 22, new EarlySprintStrategy());
		
		//add horses to list 
		horseList.add(h1);
		horseList.add(h2);
		horseList.add(h3);
		
		while (winner == false) {
			
			for (Horse h: horseList) {
				h.update();
				
				if (h.getCurrPos() >= 10.0) {
					winner = true;
					System.out.println(h.name+" is the winner.");
					break;
				}		
				
			}
			System.out.println("");
			try {
				Thread.sleep(10);
			}
			catch(InterruptedException ex) {
					//do nothing
			}
		}	
	}
	
	
}