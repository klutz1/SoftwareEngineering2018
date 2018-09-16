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
		if (getShipLocation().y > 0 && oceanmap.oceanGrid[xCell][yCell-1] == 0) {
			yCell--;
		}
	}
	
	public void goSouth() {
		if (getShipLocation().y < 9 && oceanmap.oceanGrid[xCell][yCell+1] == 0) {
			yCell++;
		}
	}
	
	public void goEast() {
		if (getShipLocation().x < 9 && oceanmap.oceanGrid[xCell+1][yCell] == 0) {
			xCell++;
		}
		
	}
	
	public void goWest() {
		if (getShipLocation().x > 0 && oceanmap.oceanGrid[xCell-1][yCell] == 0) {
			xCell--;
		}
		
	}
	
	public Point getShipLocation(){
		return new Point(xCell,yCell);
	}
	
} 