package edu.nd.se2018.homework.homework6.model.elements;

import java.awt.Point;
import edu.nd.se2018.homework.homework6.model.infrastructure.MapBuilder;

public class Chip {
	
	int xCell;
	int yCell;
	MapBuilder theMap;
	
	//pass in the same instance of the oceanmap that is used in OceanExplorer
	public Chip(int x, int y, MapBuilder mapGrid) {
		xCell = x;
		yCell = y;
		theMap = mapGrid;
	}
	
	//Ship goes north only if it does not go off the edge and there is no island to the north
	public void goUp(MapBuilder grid) {
		if (getChipLocation().y > 0 && grid.theGrid[xCell][yCell-1] != 2) {
			yCell--;
		}
	}
	
	//ship goes south only if it does not go off the edge and there is no island to the south
	public void goDown(MapBuilder grid) {
		if (getChipLocation().y < 24 && grid.theGrid[xCell][yCell+1] != 2) {
			yCell++;
		}
		
	}
	
	//ship goes east only if it does not go off the edge and there is no island to the east
	public void goRight(MapBuilder grid) {
		if (getChipLocation().x < 24 && grid.theGrid[xCell+1][yCell] != 2) {
			xCell++;
		}
	}
	
	//ship goes west only if it does not go off the edge and there is no island to the west
	public void goLeft(MapBuilder grid) {
		if (getChipLocation().x > 0 && grid.theGrid[xCell-1][yCell] != 2) {
			xCell--;
		}
	}
	
	//return the current ship location for the pirates to follow
	public Point getChipLocation() {
		return new Point(xCell,yCell);
	}
} 