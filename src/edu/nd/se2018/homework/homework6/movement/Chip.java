package edu.nd.se2018.homework.homework6.movement;

import java.awt.Point;

import edu.nd.se2018.homework.homework6.cells.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class Chip {
	
	Point chipsPosition;
	private static Chip onlyChip;
	private edu.nd.se2018.homework.homework6.cells.ChipCell currCell;
	private ImageView chipImageView;
	private Image chipImage;
	private Portal p;
	
	public Chip(int xVal, int yVal) {
		chipsPosition = new Point(xVal, yVal);
		currCell = new edu.nd.se2018.homework.homework6.cells.ChipCell(xVal, yVal);
		Image chipImage = new Image("images\\chipRight.png", 35, 35, true, true);
		this.chipImageView = new ImageView(chipImage);
		p = new Portal();
		chipImageView.setX(yVal*35);
		chipImageView.setY(xVal*35);
	} 
	 
	//Implementation of singleton design pattern
	public static Chip getOnlyChip(final int x, final int y) {
		onlyChip = new Chip(x, y);
		return onlyChip;
	}
	
	public static Chip getOnlyChip() {
		return onlyChip;
	}
	
	public edu.nd.se2018.homework.homework6.cells.ChipCell getCell() {
		return currCell; 
	}

	public Point getChipsPosition() {
		return chipsPosition;
	}
	
	
	public void moveChip(KeyEvent keyPressed, Pane root, MapBuilder theMap, int LevelNum) {
		
		//this implements the challenge of level 2
		if (LevelNum == 1) {
			theMap.setCell(new OpenCell(chipsPosition.x, chipsPosition.y));
		}
		else {
			theMap.setCell(new WallCell(chipsPosition.x, chipsPosition.y));
		}
		
		//place the winning cell
		theMap.setCell(new WinningCell(23,23));
		
		
		//add chip to the new location
		root.getChildren().add(theMap.getCell(chipsPosition.x, chipsPosition.y).getImageView());
		
		
		switch (keyPressed.getCode()) {
			case UP: 
				chipsPosition = goUp(theMap);
				break;
			case DOWN:
				chipsPosition = goDown(theMap);
				break;
			case RIGHT:
				chipsPosition = goRight(theMap);
				break;
			case LEFT:
				chipsPosition = goLeft(theMap);
				break;
			default:
				break;
		}
		
		//place Chip in his new cell
		theMap.setCell(new edu.nd.se2018.homework.homework6.cells.ChipCell(chipsPosition.x, chipsPosition.y));
		root.getChildren().add(theMap.getCell(chipsPosition.x, chipsPosition.y).getImageView());
		
	}
	
	public ImageView getImageView() {
		return this.chipImageView;
	}
	
	
	//move Chip up if possible
	public Point goUp(MapBuilder theMap) {
		if (chipsPosition.y-1 > 0 && theMap.getCell(chipsPosition.x, chipsPosition.y-1).canBeWalkedOn()) {
			if (theMap.getCell(chipsPosition.x, chipsPosition.y-1).isPiece() == 1) {
				theMap.decrementPiecesRemaining();
			}
			else if (theMap.getCell(chipsPosition.x, chipsPosition.y-1).isPortal() == 1) {
				chipsPosition = p.portalBehavior(chipsPosition, 1);
			}
			
			return new Point(chipsPosition.x, chipsPosition.y-1);
		}
		else {
			return chipsPosition; 
		}
	}
	
	//move Chip down if possible
	public Point goDown(MapBuilder theMap) {
		if (chipsPosition.y+1 < 24 && theMap.getCell(chipsPosition.x, chipsPosition.y+1).canBeWalkedOn()) {
			if (theMap.getCell(chipsPosition.x, chipsPosition.y+1).isPiece() == 1) {
				theMap.decrementPiecesRemaining();
			}
			else if (theMap.getCell(chipsPosition.x, chipsPosition.y+1).isPortal() == 1) {
				chipsPosition = p.portalBehavior(chipsPosition, 2);
			}
			return new Point(chipsPosition.x, chipsPosition.y+1);
		}
		else {
			return chipsPosition;
		}
	}
	
	
	//move Chip to the right if possible
	public Point goRight(MapBuilder theMap) {
		if (chipsPosition.x+1 > 0 && theMap.getCell(chipsPosition.x+1, chipsPosition.y).canBeWalkedOn()) {
			if (theMap.getCell(chipsPosition.x+1, chipsPosition.y).isPiece() == 1) {
				theMap.decrementPiecesRemaining();
			}
			else if (theMap.getCell(chipsPosition.x+1, chipsPosition.y).isPortal() == 1) {
				chipsPosition = p.portalBehavior(chipsPosition, 3);
			}
			return new Point(chipsPosition.x+1, chipsPosition.y);
		}
		else {
			return chipsPosition; 
		}
	}
	
	//move Chip to the left if possible
	public Point goLeft(MapBuilder theMap) {
		if (chipsPosition.x-1 > 0 && theMap.getCell(chipsPosition.x-1, chipsPosition.y).canBeWalkedOn()) {
			if (theMap.getCell(chipsPosition.x-1, chipsPosition.y).isPiece() == 1) {
				theMap.decrementPiecesRemaining();
			}
			else if (theMap.getCell(chipsPosition.x-1, chipsPosition.y).isPortal() == 1) {
				chipsPosition = p.portalBehavior(chipsPosition, 4);
			}
			return new Point(chipsPosition.x-1, chipsPosition.y);
		}
		else {
			return chipsPosition; 
		}
	}
}