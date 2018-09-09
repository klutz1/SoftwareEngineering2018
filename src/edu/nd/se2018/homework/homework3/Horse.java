package edu.nd.se2018.homework.homework3;

import java.math.*;

public class Horse {
	String name; 
	Integer number;
	double maxSpeed;
	GeneralStrategy theStrategy;
	Double prevPos;
	Double currPos;
	
	public Horse(String name, int number, double maxSpeed, GeneralStrategy theStrategy) {
		this.name = name;
		this.number = number;
		this.theStrategy = theStrategy;
		this.maxSpeed = maxSpeed;
		this.currPos = 0.0;
		this.prevPos = 0.0;
	}
	
	public void setCurrPos(Double cp) {
		currPos = cp;
	}
	
	public void setPrevPos(Double pp) {
		prevPos = pp;
	}
	
	public double getCurrPos() {
		return this.currPos;
	}
	
	public double getPrevPos() {
		return prevPos;
	}
	
	public void update() {
		this.currPos = this.prevPos + ((theStrategy.horseSpeed(prevPos, this.maxSpeed)/3600) * 25.0);
		System.out.println(this.name + " has run " + (double)Math.round(this.currPos*100d)/100d + " miles.");
		this.prevPos = this.currPos;
	}
}