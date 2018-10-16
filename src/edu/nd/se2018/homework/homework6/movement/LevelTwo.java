package edu.nd.se2018.homework.homework6.movement;

import javafx.scene.layout.Pane;
import edu.nd.se2018.homework.homework6.cells.CellsFactory;

import edu.nd.se2018.homework.homework6.cells.*;

public class LevelTwo {
	
	private MapBuilder levelTwoMap;
	
	private CellsFactory theFactory;
	private Pane root;
	
	public LevelTwo(Pane root) {
		this.theFactory = new CellsFactory();
		this.root = root;
	};
	
	private void convertToView() {
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				this.root.getChildren().add(levelTwoMap.getCell(i, j).getImageView());
			}
		}
	}
	
	
	public MapBuilder drawLevel() { 
		levelTwoMap = MapBuilder.returnOnlyMap();
		
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				if (i == 0 || i == 24 || j == 0 || j == 24 ) {
					this.theFactory.drawCell(i,  j,  Cell.WALLCELL, levelTwoMap);
				}
			//	else if (i )
				else {
					this.theFactory.drawCell(i, j, Cell.OPENCELL, levelTwoMap);
				}
				
			}
		}
		
		//TODO: fix this
		convertToView();
		
		Chip chip = Chip.getOnlyChip(12, 12);
		levelTwoMap.setCell(chip.getCell());
		root.getChildren().add(chip.getImageView());
		
		return levelTwoMap;
	}
}