package edu.nd.se2018.homework.homework6.movement;

import edu.nd.se2018.homework.homework6.cells.CellType;
import edu.nd.se2018.homework.homework6.movement.LevelOne;

public class MapBuilder {
	
	final private static int Gridsize = 25;
	private static MapBuilder onlyMap = null;
	private CellType[][] theGrid;
	//private LevelOne levOne;
	private int pieces;
	
	public MapBuilder() {
		theGrid = new CellType[Gridsize][Gridsize];
		pieces = 0;
	}
	 
	public static MapBuilder returnOnlyMap() {
		if (onlyMap == null) {
			return new MapBuilder();
		}
		else {
			return onlyMap;
		}
	}
	
	public CellType getCell(int xVal, int yVal) {
		return theGrid[xVal][yVal];
	}
	
	public void setCell(CellType theCell) {
		theGrid[theCell.getX()][theCell.getY()] = theCell;
	}
	
	public int decrementPiecesRemaining() {
		this.pieces = this.pieces - 1;
		return this.pieces;
	}
	
	public void setPieces(int num) {
		this.pieces = num;
	}
	
	public int getPieces() {
		return pieces;
	}
	
	
}