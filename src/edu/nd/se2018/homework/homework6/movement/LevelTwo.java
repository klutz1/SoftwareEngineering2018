package edu.nd.se2018.homework.homework6.movement;

import javafx.scene.layout.Pane;
import edu.nd.se2018.homework.homework6.cells.*;

public class LevelTwo {
	
	private MapBuilder levelTwoMap;
	private CellsFactory theFactory;
	private Pane root;
	private int totalPlacedPieces = 0;
	
	public LevelTwo(Pane root) {
		this.theFactory = new CellsFactory();
		this.root = root;
	};
	
	
	//display cell to screen
	private void convertToView() {
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				this.root.getChildren().add(levelTwoMap.getCell(i, j).getImageView());
			}
		}
	}
	
	
	//this places all of the walls, pieces, and open squares
	public MapBuilder drawLevel() { 
		levelTwoMap = MapBuilder.returnOnlyMap();
		
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				if (i == 0 || i == 24 || j == 0 || j == 24 ) {
					this.theFactory.drawCell(i, j, Cell.WALLCELL, levelTwoMap);
				}
				else if (i == 12 && j == 13) {
					this.theFactory.drawCell(i, j, Cell.WALLCELL, levelTwoMap);
				}
				else if (i == 11 && j < 24 && j > 6) {
					this.theFactory.drawCell(i, j, Cell.WALLCELL, levelTwoMap);
				}
				else if (i == 13 && j < 14 && j > 9) {
					this.theFactory.drawCell(i, j, Cell.WALLCELL, levelTwoMap);
				}
				else if (i == 23 && j == 23) {
					this.theFactory.drawCell(i, j, Cell.WINNINGCELL, levelTwoMap);
				}
				else if (i > 10 && i < 18 && j == 7) {
					this.theFactory.drawCell(i, j, Cell.WALLCELL, levelTwoMap);
				}
				else if (i == 14 && j == 8) {
					this.theFactory.drawCell(i, j, Cell.PIECECELL, levelTwoMap);
					this.totalPlacedPieces++;
				}
				else if (i == 18 && j > 3 && j < 8) {
					this.theFactory.drawCell(i, j, Cell.WALLCELL, levelTwoMap);
				}
				else if (i > 12 && i < 23 && j == 10) {
					this.theFactory.drawCell(i, j, Cell.WALLCELL, levelTwoMap);
				}
				else if (i == 22 && j < 10 && j > 1) {
					this.theFactory.drawCell(i, j, Cell.WALLCELL, levelTwoMap);
				}
				else if (j == 2 && i > 6 && i < 22) {
					this.theFactory.drawCell(i, j,  Cell.WALLCELL, levelTwoMap);
				}
				else if (i == 7 && j > 2 && j < 18) {
					this.theFactory.drawCell(i, j, Cell.WALLCELL, levelTwoMap);
				}
				else if (i == 9 && j == 4) {
					this.theFactory.drawCell(i, j, Cell.PIECECELL, levelTwoMap);
					this.totalPlacedPieces++;
				}
				else if (i == 5 && j == 11) {
					this.theFactory.drawCell(i, j, Cell.PIECECELL, levelTwoMap);
					this.totalPlacedPieces++;
				}
				else if (i == 2 && j == 22) {
					this.theFactory.drawCell(i, j, Cell.PIECECELL, levelTwoMap);
					this.totalPlacedPieces++;
				}
				else if (i == 3 && j == 20) {
					this.theFactory.drawCell(i, j, Cell.PIECECELL, levelTwoMap);
					this.totalPlacedPieces++;
				}
				else if (i == 3 && j == 3) {
					this.theFactory.drawCell(i, j, Cell.PIECECELL, levelTwoMap);
					this.totalPlacedPieces++;
				}
				else if (i == 5 && j == 12) {
					this.theFactory.drawCell(i, j, Cell.PIECECELL, levelTwoMap);
					this.totalPlacedPieces++;
				}
				else if (i == 2 && j == 8) {
					this.theFactory.drawCell(i, j, Cell.PIECECELL, levelTwoMap);
					this.totalPlacedPieces++;
				}
				else if (i == 22 && j == 22) {
					this.theFactory.drawCell(i, j, Cell.PIECECELL, levelTwoMap);
					this.totalPlacedPieces++;
				}
				else if (i == 16 && j == 16) {
					this.theFactory.drawCell(i, j, Cell.PIECECELL, levelTwoMap);
					this.totalPlacedPieces++;
				}
				else {
					this.theFactory.drawCell(i, j, Cell.OPENCELL, levelTwoMap);
				}
			}
		}
		
		levelTwoMap.setPieces(this.totalPlacedPieces);
	
		convertToView();
		
		//place Chip on the original spot on the board
		Chip chip = Chip.getOnlyChip(12, 12);
		levelTwoMap.setCell(chip.getCell());
		root.getChildren().add(chip.getImageView());
		
		return levelTwoMap;
	}
}