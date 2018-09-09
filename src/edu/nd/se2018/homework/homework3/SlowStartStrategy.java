package edu.nd.se2018.homework.homework3;

public class SlowStartStrategy implements GeneralStrategy {
	public double horseSpeed(double mileNum, double mSpeed) {
		if (mileNum <= 6.0) {
			return (0.75*mSpeed);
		}
		else if (mileNum > 6.0 && mileNum <= 9.0) {
			return (0.9*mSpeed);
		}
		else {
			return mSpeed;
		}
	}
}