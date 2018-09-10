package edu.nd.se2018.homework.homework3;

public class Horse {
	private String name; 
	double maxSpeed;
	private GeneralStrategy theStrategy;
	private Double prevPos;
	private Double currPos;
	
	public Horse(String name, double maxSpeed, GeneralStrategy theStrategy) {
		this.name = name;
		this.theStrategy = theStrategy;
		this.maxSpeed = maxSpeed;
		this.currPos = 0.0;
		this.prevPos = 0.0;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public void setPrevPos(Double pp) {
		this.prevPos = pp;
	}
	
	public void setCurrPos(Double cp) {
		this.currPos = cp;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPrevPos() {
		return this.prevPos;
	}
	
	public double getCurrPos() {
		return this.currPos;
	}
	public void update() {
		this.currPos = this.prevPos + ((theStrategy.horseSpeed(prevPos, this.maxSpeed)/3600) * 25.0);
		System.out.println(this.name + " has run " + (double)Math.round(this.currPos*100d)/100d + " miles.");
		this.prevPos = this.currPos;
	}
}