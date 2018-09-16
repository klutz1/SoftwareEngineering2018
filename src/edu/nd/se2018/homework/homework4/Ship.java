package edu.nd.se2018.homework.homework4;


import java.awt.Point;

public class Ship {
	
	int xCell;
	int yCell;
	OceanMap oceanmap;
	
	public Ship(int x, int y, OceanMap oceanmap) {
		xCell = x;
		yCell = y;
		this.oceanmap = oceanmap;
	}
	public void goNorth() {
		yCell--;
	}
	
	public void goSouth() {
		yCell++;
	}
	
	public void goEast() {
		xCell++;
	}
	
	public void goWest() {
		xCell--;
	}
	
	public Point getShipLocation(){
		return new Point(xCell,yCell);
	}
	
}