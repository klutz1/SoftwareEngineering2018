package edu.nd.se2018.homework.homework6.model.elements;

import java.awt.Point;
import edu.nd.se2018.homework.homework6.model.infrastructure.MapBuilder;

public class Chip {
	
	int xCell;
	int yCell;
	MapBuilder theMap;
	
	//pass in the same instance of the oceanmap that is used in OceanExplorer
	public Chip(int x, int y, MapBuilder theMap) {
		xCell = x;
		yCell = y;
		this.theMap = theMap;
	}
	
	//Ship goes north only if it does not go off the edge and there is no island to the north
	public void goUp() {
		if (getShipLocation().y > 0) {
			yCell--;
		}
	}
	
	//ship goes south only if it does not go off the edge and there is no island to the south
	public void goDown() {
		if (getShipLocation().y < 24) {
			yCell++;
		}
	}
	
	//ship goes east only if it does not go off the edge and there is no island to the east
	public void goRight() {
		if (getShipLocation().x < 24) {
			xCell++;
		}
	}
	
	//ship goes west only if it does not go off the edge and there is no island to the west
	public void goLeft() {
		if (getShipLocation().x > 0) {
			xCell--;
		}
	}
	
	//return the current ship location for the pirates to follow
	public Point getShipLocation() {
		return new Point(xCell,yCell);
	}
} 