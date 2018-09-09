package edu.nd.se2018.homework.homework3;

public class EarlySprintStrategy implements GeneralStrategy {
	public double horseSpeed(double mileNum, double mSpeed) {
		if (mileNum <= 2) {
			return mSpeed;
		}
		else {
			return (0.75*mSpeed);
		}
	}
}