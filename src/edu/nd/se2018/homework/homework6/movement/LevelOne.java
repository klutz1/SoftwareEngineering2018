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
	/*	for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				if (i == 0 || j == 0 || i == 24 || j == 24) {
					this.root.getChildren().add(levelOneMap.getCell(i,j).getImageView());
				}
				if (i == 4 && j < 10 && j != 0) {
					this.root.getChildren().add(levelOneMap.getCell(i,j).getImageView());
				}
				if (i == 9 && j < 15 && j != 0) {
					this.root.getChildren().add(levelOneMap.getCell(i,j).getImageView());
				}
				if (i == 16 && j > 3 && j != 24) {
					this.root.getChildren().add(levelOneMap.getCell(i,j).getImageView());
				}
				if (i > 0 && i < 4 && j != 0 && j != 24) {
					this.root.getChildren().add(levelOneMap.getCell(i,j).getImageView());
				}
				if (i == 23 && j == 23) {
					this.root.getChildren().add(levelOneMap.getCell(i,j).getImageView());
				}
				if (i > 9 && i < 16 && j != 0 && j != 24) {
					this.root.getChildren().add(levelOneMap.getCell(i,j).getImageView());
				}
				if (i > 4 && i < 9 && j != 0 && j != 24) {
					this.root.getChildren().add(levelOneMap.getCell(i,j).getImageView());
				}
				if (i > 16 && i < 23 && j != 0 && j != 24) {
					this.root.getChildren().add(levelOneMap.getCell(i,j).getImageView());
				}
				if (i == 23 && j != 0 && j < 23) {
					this.root.getChildren().add(levelOneMap.getCell(i,j).getImageView());
				}
				if (i == 4 && j >9 &&j !=24) {
					this.root.getChildren().add(levelOneMap.getCell(i,j).getImageView());
				}
				if (i == 9 && j > 14 && j != 24) {
					this.root.getChildren().add(levelOneMap.getCell(i,j).getImageView());
				}
				
				if (i == 16 && j < 4 && j != 0) {
					this.root.getChildren().add(levelOneMap.getCell(i,j).getImageView());
				}
			}
		}*/
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
				else {
					this.theFactory.drawCell(i, j, Cell.OPENCELL, levelOneMap);
				}
				
			}
		}
		
		levelOneMap.setPieces(totalPlacedPieces);
		
		//TODO: fix this
		convertToView();
		
		Chip chip = Chip.getOnlyChip(2, 2);
		levelOneMap.setCell(chip.getCell());
		root.getChildren().add(chip.getImageView());
		
		return levelOneMap;
		
	}
	
}


