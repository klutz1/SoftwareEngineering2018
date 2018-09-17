package edu.nd.se2018.homework.homework4;

import java.util.Observable;
import java.util.Observer;
import java.awt.Point;

//Pirates observe the ship
public class PirateShip implements Observer {
	Point ColumbusPosition;
	Point piratePosition;
	OceanMap oceanmap;
	int px, py;
	
	public PirateShip(int x, int y, OceanMap oceanmap) {
		this.px = x;
		this.py = y;
		this.oceanmap = oceanmap;
	}
	
	//Pirate movement is different than ship movement
	//This is why unique methods are used in PirateShip than in Ship
	//Pirates move one square at a time only if there is no island
	//standing in their way
	public void movePirateShip() {
		boolean moved = false;
		if (ColumbusPosition.x < px && moved == false) {
			if (oceanmap.oceanGrid[px-1][py] != 2) {
				goWest();
				moved = true;
			}
		}
		else if (ColumbusPosition.x > px && moved == false) {
			if (oceanmap.oceanGrid[px+1][py] != 2) {
				goEast();
				moved = true;
			}
		}
		else if (ColumbusPosition.y > py && moved == false) {
			if (oceanmap.oceanGrid[px][py+1] != 2) {
				goSouth();
				moved = true;
			}
		}
		else if (ColumbusPosition.y < py && moved == false) {
			if (oceanmap.oceanGrid[px][py-1]!=2) {
				goNorth();
				moved = true;
			}
		}
	}
	
	public void goNorth() {
		py--;
	}

	public void goSouth() {
		py++;
	}
	
	public void goEast() {
		px++;
	}
	
	public void goWest() {
		px--;
	}
	
	//return the current pirate location
	public Point getPirateLocation(){
		return new Point(px,py);
	}
	
	//if the ship moves, move the pirate ship if possible
	@Override
	public void update(Observable s, Object arg1) {
		if (s instanceof Ship){
			ColumbusPosition = ((Ship)s).getShipLocation();
			movePirateShip();				
		}		
		
	}
}