package edu.nd.se2018.homework.homework3;

public class Horse {
	//Horse characteristics are private member variables
	private String name; 
	double maxSpeed;
	private GeneralStrategy theStrategy;
	private Double prevPos;
	private Double currPos;
	
	//initalize current and previous position of each Horse to 0.0
	//name, strategy, and maxSpeed are set in constructor
	public Horse(String name, double maxSpeed, GeneralStrategy theStrategy) {
		this.name = name;
		this.theStrategy = theStrategy;
		this.maxSpeed = maxSpeed;
		this.currPos = 0.0;
		this.prevPos = 0.0;
	}
	
	//setName method outside constructor
	public void setName(String n) {
		this.name = n;
	}
	
	//set previous position outside constructor
	public void setPrevPos(Double pp) {
		this.prevPos = pp;
	}
	
	//set current position outside constructor
	public void setCurrPos(Double cp) {
		this.currPos = cp;
	}
	
	//set strategy outside constructor
	public void setStrategy(GeneralStrategy gs) {
		this.theStrategy = gs;
	}
	
	//return name
	public String getName() {
		return this.name;
	}
	
	//return previous position
	public double getPrevPos() {
		return this.prevPos;
	}
	
	//return current position
	public double getCurrPos() {
		return this.currPos;
	}
	
	//return strategy
	public GeneralStrategy getStrategy() {
		return this.theStrategy;
	} 
	
	//this is called in each loop iteration
	//position is calculated by multiplying miles per hour by 25.0 seconds
	//this assumes that each loop = 30 seconds of race
	public void update() {
		this.currPos = this.prevPos + ((theStrategy.horseSpeed(prevPos, this.maxSpeed)/3600) * 30.0);
		System.out.println(this.name + " has run " + (double)Math.round(this.currPos*100d)/100d + " miles.");
		//update previous position for next iteration
		this.prevPos = this.currPos;
	}
}