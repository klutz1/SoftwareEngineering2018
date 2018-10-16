package edu.nd.se2018.homework.homework6.movement;

import java.awt.Point;


import edu.nd.se2018.homework.homework6.cells.ChipCell;
import edu.nd.se2018.homework.homework6.cells.OpenCell;
import javafx.collections.ObservableList;
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
	
	
	public void moveChip(KeyEvent keyPressed, Pane root) {
		theMap = theMap.returnOnlyMap() ;
		
		theMap.setCell(new OpenCell(chipsPosition.x, chipsPosition.y));
		
		root.getChildren().add(theMap.getCell(chipsPosition.x, chipsPosition.y).getImageView());
		
		switch (keyPressed.getCode()) {
		case RIGHT: 
			chipsPosition = goRight(theMap);
			break;
		case LEFT:
			chipsPosition = goLeft(theMap);
			break;
		case UP:
			chipsPosition = goUp(theMap);
			break;
		case DOWN:
			chipsPosition = goDown(theMap);
			break;
		default:
			break;
		}
		
		theMap.setCell(new edu.nd.se2018.homework.homework6.cells.ChipCell(chipsPosition.x, chipsPosition.y));
		root.getChildren().add(theMap.getCell(chipsPosition.x, chipsPosition.y).getImageView());
		
		//TODO: this is a big problem -- should be only instance
		//theMap.setCell(new ChipCell(chipsPosition.x, chipsPosition.y));
		
	}
	
	public ImageView getImageView() {
		return this.chipImageView;
	}
	
	public Point goUp(MapBuilder theMap) {
		if (chipsPosition.y-1 > 0) {// && theMap.getCell(chipsPosition.x, chipsPosition.y-1).canBeWalkedOn()) {
			System.out.println(chipsPosition);
			System.out.println(theMap.getCell(chipsPosition.x, chipsPosition.y - 1));
			return new Point(chipsPosition.x, chipsPosition.y-1);
		}
		else {return chipsPosition;}
	}
	
	public Point goDown(MapBuilder theMap) {
		return new Point(chipsPosition.x, chipsPosition.y+1);
	}
	
	public Point goRight(MapBuilder theMap) {
		return new Point(chipsPosition.x+1, chipsPosition.y);
	}
	
	public Point goLeft(MapBuilder theMap) {
		return new Point(chipsPosition.x-1, chipsPosition.y);
	}
	
}