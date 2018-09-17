//This class initializes the grid values and returns the current location of the pirate and Columbus ships

package edu.nd.se2018.homework.homework4;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import javax.xml.soap.Node;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OceanMap {
	final int size = 25;
	
	int[][] oceanGrid = new int[25][25];
	
	final int scale = 50;
	
	private int startingX;
	private int startingY;
	private int p1x;
	private int p1y;
	ObservableList<Node> root;
		
	//Constructor
	public OceanMap(int size, int islandNum) {
		size = this.size;
	}
	

	public void drawMap(ObservableList<javafx.scene.Node> root) {
		
		//first, initialize all grid values to zero
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				oceanGrid[i][j] = 0;
			}
		}
		
		//place the islands on the grid next--set value to 2
		int k = 0;
		while (k < 10) {
			Random rand = new Random();
			int x = rand.nextInt(9);
			int y = rand.nextInt(9);
			if (oceanGrid[x][y] == 0) {
				oceanGrid[x][y] = 2;
				k++;
			}
		}
		
		//if value of grid = 0: ocean
		//if value of grid = 2: island
		for (int h = 0; h < size; h++) {
			for (int d = 0; d < size; d++) {
				Rectangle rect = new Rectangle(h*scale, d*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				if (oceanGrid[h][d] == 2) {
					rect.setFill(Color.GREEN);
					root.add(rect);
				}
				else {
					rect.setFill(Color.PALETURQUOISE);
					root.add(rect);
				}
				
			}
		}
	}

	//return current pirate location as x,y coordinates
	public Point getPirateLocation(PirateShip pirate) {
		return pirate.getPirateLocation();
	}
	
	//return current ship location as x,y coordinates
	public Point getShipLocation(Ship ship) {
		return ship.getShipLocation();
	}
	
	//place the ship in a random ocean location
	public Point getStartPoint(){
		Random rand = new Random();
		boolean placed = false;
		while (!placed) {
			int x = rand.nextInt(9);
			int y = rand.nextInt(9);
			if (oceanGrid[x][y] == 0) {
				startingX = x;
				startingY = y;
				return new Point(x, y);
			}
		}
		return new Point(0,0);
	}
	
	//place pirate 1, but not on top of another ship or island
	public Point getPirate1StartPoint() {
		Random rand = new Random();
		boolean pl = false;
		while (!pl) {
			int x = rand.nextInt(9);
			int y = rand.nextInt(9);
			if (oceanGrid[x][y] == 0) {
				if (x == startingX && y == startingY) {
					//do nothing: iterate through loop again
					//Columbus ship is already located here
				}
				else {
					p1x = x; 
					p1y = y;
					return new Point(x, y);
				}
			}
		}
		return new Point(0,0);
	}

	//place second pirate randomly, but not on top of island or another ship
	public Point getPirate2StartPoint() {
		Random rand = new Random();
		boolean p = false;
		while (!p) {
			int x = rand.nextInt(9);
			int y = rand.nextInt(9);
			if (oceanGrid[x][y] == 0) {
				if (x == startingX && y == startingY) {
					//do nothing; Columbus ship is located here
					
				}
				else if (x == p1x && y == p1y) {
					//do nothing; the other pirate is already located here
				}
				else {
					//if no conflict, place the second pirate ship
					return new Point(x, y);
				}
			}
		}
		return new Point(0,0);
	}
}