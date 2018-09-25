package edu.nd.se2018.homework.homework5.model.vehicles;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import edu.nd.se2018.homework.homework5.model.infrastructure.Direction;
import edu.nd.se2018.homework.homework5.model.vehicles.Car;
import edu.nd.se2018.homework.homework5.model.infrastructure.gate.CrossingGate;
import java.util.Vector;

/**
 * Very basic car factory.  Creates the car and registers it with the crossing gate and the car infront of it.
 * @author jane
 *
 */
public class CarFactory {
	
	private Collection<CrossingGate> gates = null;
	private Car previousCar = null;
	private ArrayList<Car> cars = new ArrayList<Car>();
	Direction direction;
	Point location;
	int carCountOne = 0;
	int carCountTwo = 1000;
	Vector<Car> roadOneCars = new Vector<Car>();
	Vector<Car> roadTwoCars = new Vector<Car>();
	
	public CarFactory(){}
	
	public CarFactory(Direction direction, Point location, Collection<CrossingGate> gates){
		this.direction = direction;
		this.location = location;
		this.gates = gates;
	}
	
	// create random speed for car & assign as left mover if necessary
	public Car buildCar(){
		
		if (previousCar == null || location.y < previousCar.getVehicleY()-100){
			Car car = new Car(location.x,location.y, false);	
	
			if (location.x > 700) {
				car.identifier = carCountTwo;
				carCountTwo++;
				roadTwoCars.add(car);
			}
			else {
				car.identifier = carCountOne;
				carCountOne++;
				roadOneCars.add(car);
			}
			
			double speedVariable = (Math.random() * 10)/10;
			car.setSpeed((2-speedVariable)*0.75); 

			// randomly determine if this car can move left 
			if (location.x > 700) {
				if (Math.random()*10 < 3 && roadTwoCars.size() > 1) {
						car.assignLeftMover();
				}
			}
			
			// All cars created by this factory must be aware of crossing gates in the road
			for(CrossingGate gate: gates){
				gate.addObserver(car);
				if(gate != null && gate.getTrafficCommand()=="STOP")
					car.setGateDownFlag(true);
			}
			
			// Each car must observe the car in front of it so it doesn't collide with it.
			if (previousCar != null)
				previousCar.addObserver(car);
			previousCar = car;
			
			cars.add(car);
			
			return car;
		} else 
			return null;
	}
	
	//function to change observers
	public void changeTrainMovement() {
		Car tempCar;
		for (int i = 0; i < roadTwoCars.size(); i++)  {

			if (roadTwoCars.get(i).leftMover == true) {
				
				//delete observers once reached the point of crossing over
				if (roadTwoCars.get(i).getVehicleY() > 593) {
					tempCar = roadTwoCars.get(i);
					
					//remove the car behind it as an observer
					if (roadTwoCars.size() - i >= 1) {
						tempCar.deleteObservers();
					}
						
					roadOneCars.add(roadTwoCars.get(i));
										
					roadTwoCars.remove(i);
					
					//change who the car is observing
					if (roadTwoCars.size() > 1) {
						if (i != 0 && i != roadTwoCars.size()) {
							roadTwoCars.get(i-1).addObserver(roadTwoCars.get(i));					
						}
						else {
							roadTwoCars.get(i).continueMoving = true;
						}	
					}
				}
			}
		}
	}

	// We will get a concurrency error if we try to delete cars whilst iterating through the array list
	// so we perform this in two stages.
	// 1.  Loop through the list and identify which cars are off the screen.  Add them to 'toDelete' array.
	// 2.  Iterate through toDelete and remove the cars from the original arrayList.
	public ArrayList<Car> removeOffScreenCars() {
		
		// Removing cars from the array list.
		ArrayList<Car> toDelete = new ArrayList<Car>();
		for(Car car: cars){
			car.move();					
			if (car.offScreen()) {
				toDelete.add(car);
			}
		}   
		for (Car car: toDelete) {
			if (car.identifier >= 1000) {
				roadTwoCars.remove(car);
			}
			else {
				roadOneCars.remove(car);
			}
			cars.remove(car);
		}
		return toDelete;
	}
}
