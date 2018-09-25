package edu.nd.se2018.homework.homework5.model.vehicles;

import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.homework5.model.infrastructure.gate.CrossingGate;
import edu.nd.se2018.homework.homework5.view.CarImageSelector;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * Represents Car object
 *	
 *
 */
public class Car extends Observable implements IVehicle, Observer{
	private ImageView ivCar;
	private double currentX = 0;
	private double currentY = 0;
	private double originalY = 0;
	private boolean gateDown = false;
	private double leadCarY = -1;  // Current Y position of car directly infront of this one
	private double leadCarX = 5;
	private double speed = 0.5;
	public boolean leftMover = false;
	private boolean inTJunction = false;
	public int identifier = 0;
	public int carBehindIndex = 0;
	public int carInFrontIndex = 0;
	public boolean leftMoverInLane = false;
	public Car tempCar;
	public boolean continueMoving = false;
		
	/**
	 * Constructor
	 * @param x initial x coordinate of car
	 * @param y initial y coordinate of car
	 */
	public Car(int x, int y, boolean leftMove){
		this.currentX = x;
		this.currentY = y;
		originalY = y;
		ivCar = new ImageView(CarImageSelector.getImage());
		ivCar.setX(getVehicleX());
		ivCar.setY(getVehicleY());
		leftMover = leftMove;
		identifier = 1;
	}
	
	public double getSpeed() {
		return this.speed;
	}
	public void assignLeftMover() {
		this.leftMover = true;
	}		
	
	@Override
	
	public Node getImageView() {
		return ivCar;
	}
	
	public boolean gateIsClosed(){
		return gateDown;
	}
	
	public double getVehicleX(){
		return currentX;
	}
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){
		
		boolean canMoveVertical = true; 
		boolean canMoveLeft = false;
		
		// First case.  Car is at the front of the stopping line.
		if (gateDown && getVehicleY() < 430 && getVehicleY()> 390)
			canMoveVertical = false;
		
		// Second case. Car is too close to other car.
		if (leadCarY != -1  && getDistanceToLeadCar() < 75)
			canMoveVertical = false;
			
		if (continueMoving) {
			canMoveVertical = true;
		}
		if (this.leftMover == true) {
			
			if (getVehicleY() < 600 && getVehicleY() > 595) {
				canMoveVertical = false;
				canMoveLeft = true;
			}
			
			if (getVehicleX() < 395) {
				canMoveLeft = false;
				canMoveVertical = true;
			}
		}
		
		if (canMoveVertical) {
			currentY+=speed;
			ivCar.setY(currentY);
			setChanged();
			notifyObservers();
		}
		if (canMoveLeft) {
			currentX-=speed;
			ivCar.setX(currentX);
			setChanged();
			notifyObservers();
		}
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
	public void setGateDownFlag(boolean gateDown){
		this.gateDown = gateDown;
	}
	
	public boolean offScreen(){
		if (currentY > 1020)
			return true;
		else
			return false;			
	}
		
	public void reset(){
		currentY = originalY;
	}
	
	
	public double getDistanceToLeadCar(){
		return Math.abs(leadCarY-getVehicleY());
	}
	
	public void removeLeadCar(){
		leadCarY = -1;
	}

	@Override
	public void update(Observable o, Object arg1) {

		if (o instanceof Car){
			
			leadCarY = (((Car)o).getVehicleY());
			
			//remove leadCar from the list
			if (leadCarY > 1020)
				leadCarY = -1;
		}
			
		if (o instanceof CrossingGate){
			CrossingGate gate = (CrossingGate)o;
			
			if(gate.getTrafficCommand()=="STOP")			
				gateDown = true;
			else
				gateDown = false;
					
		}				
	}	
}
