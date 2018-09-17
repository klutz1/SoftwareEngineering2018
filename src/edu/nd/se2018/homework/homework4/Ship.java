package edu.nd.se2018.homework.homework4;


import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

//Ship is observed by the pirate ships
public class Ship extends Observable {
	
	int xCell;
	int yCell;
	OceanMap oceanmap;
	
	//pass in the same instance of the oceanmap that is used in OceanExplorer
	public Ship(int x, int y, OceanMap oceanmap) {
		xCell = x;
		yCell = y;
		this.oceanmap = oceanmap;
	}
	
	//Ship goes north only if it does not go off the edge and there is no island to the north
	public void goNorth() {
		if (getShipLocation().y > 0 && oceanmap.oceanGrid[xCell][yCell-1] == 0) {
			yCell--;
		}
		
		//each time the ship moves, notify the observers of a change
		setChanged();
		notifyObservers();
	}
	
	//ship goes south only if it does not go off the edge and there is no island to the south
	public void goSouth() {
		if (getShipLocation().y < 9 && oceanmap.oceanGrid[xCell][yCell+1] == 0) {
			yCell++;
		}
		setChanged();
		notifyObservers();
	}
	
	//ship goes east only if it does not go off the edge and there is no island to the east
	public void goEast() {
		if (getShipLocation().x < 9 && oceanmap.oceanGrid[xCell+1][yCell] == 0) {
			xCell++;
		}
		setChanged();
		notifyObservers();
	}
	
	//ship goes west only if it does not go off the edge and there is no island to the west
	public void goWest() {
		if (getShipLocation().x > 0 && oceanmap.oceanGrid[xCell-1][yCell] == 0) {
			xCell--;
		}
		setChanged();
		notifyObservers();
	}
	
	//return the current ship location for the pirates to follow
	public Point getShipLocation(){
		return new Point(xCell,yCell);
	}
	
} 