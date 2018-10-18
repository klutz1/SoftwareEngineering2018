package edu.nd.se2018.homework.homework6.movement;

import javafx.scene.layout.Pane;
import edu.nd.se2018.homework.homework6.cells.CellsFactory;
import edu.nd.se2018.homework.homework6.cells.*;

public class LevelOne {
	
	private MapBuilder levelOneMap;
	
	private CellsFactory theFactory;
	private Pane root;
	private int totalPlacedPieces = 0;
	
	public LevelOne(Pane root) {
		this.theFactory = new CellsFactory();
		this.root = root;
	};
	
	private void convertToView() {
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				this.root.getChildren().add(levelOneMap.getCell(i, j).getImageView());
			}
		}
	}
	
	public MapBuilder drawLevel() { 
		levelOneMap = MapBuilder.returnOnlyMap();
		
		//code responsible for designing the current map
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				if (i == 0 || j == 0 || i == 24 || j == 24) {
					this.theFactory.drawCell(i, j, Cell.WALLCELL, levelOneMap);
				}
				else if (i == 4 && j < 10) {
					this.theFactory.drawCell(i, j, Cell.WALLCELL, levelOneMap);
				}
				else if (i == 9 && j < 15 && j != 0) {
					this.theFactory.drawCell(i, j, Cell.WALLCELL, levelOneMap);
				}
				else if (i == 16 && j > 3 && j != 24) {
					this.theFactory.drawCell(i, j, Cell.WALLCELL, levelOneMap); 
				}
				else if (i == 23 && j == 23) {
					this.theFactory.drawCell(i, j, Cell.WINNINGCELL, levelOneMap);
				}
				else if (i == 16 && j == 1) {
					this.theFactory.drawCell(i, j, Cell.PIECECELL, levelOneMap);
					this.totalPlacedPieces++;
				}
				else if (j == 9) {
					this.theFactory.drawCell(i, j, Cell.WALLCELL, levelOneMap);
				}
				else if (j == 14 && i < 13) {
					this.theFactory.drawCell(i, j, Cell.WALLCELL, levelOneMap);
				}
				else if (i == 13 && j > 13) {
					this.theFactory.drawCell(i, j, Cell.WALLCELL, levelOneMap);
				}
				else if (i == 2 && j == 6) {
					this.theFactory.drawCell(i, j, Cell.PIECECELL, levelOneMap);
					this.totalPlacedPieces++;
				}
				else if (i  == 20 && j == 7) {
					this.theFactory.drawCell(i, j, Cell.PIECECELL, levelOneMap);
					this.totalPlacedPieces++;
				}
				else if (i == 7 && j == 20) {
					this.theFactory.drawCell(i, j, Cell.PIECECELL, levelOneMap);
					this.totalPlacedPieces++;
				}
				else if (i == 22 && j == 12) {
					this.theFactory.drawCell(i, j, Cell.PIECECELL, levelOneMap);
					this.totalPlacedPieces++;
				}
				else if (i == 3 && j == 3) {
					this.theFactory.drawCell(i, j, Cell.PORTALCELL, levelOneMap);
				}
				else if(i == 7 && j == 21) {
					this.theFactory.drawCell(i, j, Cell.PORTALCELL, levelOneMap);
				}
				else if (i == 4 && j == 11) {
					this.theFactory.drawCell(i, j, Cell.PORTALCELL, levelOneMap);
				}
				else if (i == 22 && j == 5) {
					this.theFactory.drawCell(i, j, Cell.PORTALCELL, levelOneMap);
				}
				else if (i == 6 && j == 19) {
					this.theFactory.drawCell(i, j, Cell.PORTALCELL, levelOneMap);
				}
				else {
					this.theFactory.drawCell(i, j, Cell.OPENCELL, levelOneMap);
				}
				
			}
		}
		
		levelOneMap.setPieces(totalPlacedPieces);
		
		//place everything that has changed on the view
		convertToView();
		
		Chip chip = Chip.getOnlyChip(2, 2);
		levelOneMap.setCell(chip.getCell());
		root.getChildren().add(chip.getImageView());
		
		return levelOneMap;
	}
	
}


