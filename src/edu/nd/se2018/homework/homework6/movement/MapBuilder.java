package edu.nd.se2018.homework.homework6.movement;

import edu.nd.se2018.homework.homework6.cells.CellType;

public class MapBuilder {
	
	final private static int Gridsize = 25;
	private static MapBuilder onlyMap = null;
	private CellType[][] theGrid;
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
	
	//return the current cell
	public CellType getCell(int xVal, int yVal) {
		return theGrid[xVal][yVal];
	}
	
	//change the type of the cell
	public void setCell(CellType theCell) {
		theGrid[theCell.getX()][theCell.getY()] = theCell;
	}
	
	//every time Chip gets a piece, subtract from total pieces remaining
	public int decrementPiecesRemaining() {
		this.pieces = this.pieces - 1;
		System.out.println("Pieces remaining: " + this.pieces);
		return this.pieces;
	}
	
	public void setPieces(int num) {
		this.pieces = num;
	}
	
	public int getPieces() {
		return pieces;
	}
	
	
}