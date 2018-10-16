package edu.nd.se2018.homework.homework6.movement;

import java.awt.Point;

import edu.nd.se2018.homework.homework6.cells.CellType;
import edu.nd.se2018.homework.homework6.cells.ChipCell;
import edu.nd.se2018.homework.homework6.cells.OpenCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class Chip {
	
	MapBuilder theMap;
	Point chipsPosition;
	private static Chip onlyChip;
	private edu.nd.se2018.homework.homework6.cells.ChipCell currCell;
	private ImageView chipImageView;
	private Image chipImage;
	
	public Chip(int xVal, int yVal) {
		chipsPosition = new Point(xVal, yVal);
		currCell = new edu.nd.se2018.homework.homework6.cells.ChipCell(xVal, yVal);
		Image chipImage = new Image("images\\chipRight.png", 35, 35, true, true);
		this.chipImageView = new ImageView(chipImage);
		chipImageView.setX(yVal*35);
		chipImageView.setY(xVal*35);
	}
	 
	//TODO: fix this
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
	
	public void moveChip(KeyEvent keyPressed, Pane root, MapBuilder theMap) {
		
		theMap.setCell(new OpenCell(chipsPosition.x, chipsPosition.y));
		
		
		//add chip to the new location
		root.getChildren().add(theMap.getCell(chipsPosition.x, chipsPosition.y).getImageView());
		
		theMap.setCell(new OpenCell(chipsPosition.x, chipsPosition.y));
		
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
		
		theMap.setCell(new edu.nd.se2018.homework.homework6.cells.ChipCell(chipsPosition.x, chipsPosition.y));
		root.getChildren().add(theMap.getCell(chipsPosition.x, chipsPosition.y).getImageView());
		
	}
	
	public ImageView getImageView() {
		return this.chipImageView;
	}
	
	public Point goUp(MapBuilder theMap) {
		if (chipsPosition.y-1 > 0 && theMap.getCell(chipsPosition.x, chipsPosition.y-1).canBeWalkedOn()) {
			if (theMap.getCell(chipsPosition.x, chipsPosition.y-1).isPiece() == 1) {
				theMap.decrementPiecesRemaining();
			}
			return new Point(chipsPosition.x, chipsPosition.y-1);
		}
		else {
			return chipsPosition; 
		}
	}
	
	public Point goDown(MapBuilder theMap) {
		if (chipsPosition.y+1 < 24 && theMap.getCell(chipsPosition.x, chipsPosition.y+1).canBeWalkedOn()) {
			if (theMap.getCell(chipsPosition.x, chipsPosition.y+1).isPiece() == 1) {
				theMap.decrementPiecesRemaining();
			}
			return new Point(chipsPosition.x, chipsPosition.y+1);
		}
		else {
			return chipsPosition;
		}
	}
	
	public Point goRight(MapBuilder theMap) {
		if (chipsPosition.x+1 > 0 && theMap.getCell(chipsPosition.x+1, chipsPosition.y).canBeWalkedOn()) {
			if (theMap.getCell(chipsPosition.x+1, chipsPosition.y).isPiece() == 1) {
				theMap.decrementPiecesRemaining();
			}
			return new Point(chipsPosition.x+1, chipsPosition.y);
		}
		else {
			return chipsPosition; 
		}
	}
	
	public Point goLeft(MapBuilder theMap) {
		if (chipsPosition.x-1 > 0 && theMap.getCell(chipsPosition.x-1, chipsPosition.y).canBeWalkedOn()) {
			if (theMap.getCell(chipsPosition.x-1, chipsPosition.y).isPiece() == 1) {
				theMap.decrementPiecesRemaining();
			}
			return new Point(chipsPosition.x-1, chipsPosition.y);
		}
		else {
			return chipsPosition; 
		}
	}
	
}