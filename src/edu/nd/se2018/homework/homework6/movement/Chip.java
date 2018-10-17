package edu.nd.se2018.homework.homework6.movement;

import java.awt.Point;

import edu.nd.se2018.homework.homework6.cells.*;
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
		
		theMap.setCell(new WinningCell(23,23));
		
		
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
	
	
	//move Chip up if possible
	public Point goUp(MapBuilder theMap) {
		if (chipsPosition.y-1 > 0 && theMap.getCell(chipsPosition.x, chipsPosition.y-1).canBeWalkedOn()) {
			if (theMap.getCell(chipsPosition.x, chipsPosition.y-1).isPiece() == 1) {
				theMap.decrementPiecesRemaining();
			}
			else if (theMap.getCell(chipsPosition.x, chipsPosition.y-1).isPortal() == 1) {
				chipsPosition = portalBehavior(chipsPosition, 1);
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
				chipsPosition = portalBehavior(chipsPosition, 2);
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
				chipsPosition = portalBehavior(chipsPosition, 3);
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
				chipsPosition = portalBehavior(chipsPosition, 4);
			}
			return new Point(chipsPosition.x-1, chipsPosition.y);
		}
		else {
			return chipsPosition; 
		}
	}
	
	
	public Point portalBehavior(Point pt, int dir) {
	//dir: 1 is up, 2 is down, 3 is right, 4 is right
	//Portals @ locations (22,5), (4,11), (7,21), (3,3), (6, 19)
		Point temp;
		temp = new Point(8, 8);
		switch(dir) {
		
		//moving up
		case 1: 
			if (pt.x == 3 && pt.y == 4) {
				temp.x = 3;
				temp.y = 16;
			}
			else if (pt.x == 7 && pt.y == 22) {
				temp.x = 12;
				temp.y = 12;
			}
			else if (pt.x == 4 && pt.y == 12) {
				temp.x = 14;
				temp.y = 2;
			}
			else if (pt.x == 22 && pt.y == 6) {
				temp.x = 20;
				temp.y = 20;
			}
			else if (pt.x == 6 && pt.y == 20) {
				temp.x = 6;
				temp.y = 12;
			}
			break;
			
		//moving down
		case 2:
			if (pt.x == 3 && pt.y == 2) {
				temp.x = 3;
				temp.y = 16;
			}
			else if (pt.x == 7 && pt.y == 20) {
				temp.x = 12;
				temp.y = 12;
			}
			else if (pt.x == 4 && pt.y == 10) {
				temp.x = 14;
				temp.y = 2;
			}
			else if (pt.x == 22 && pt.y == 4) {
				temp.x = 20;
				temp.y = 20;
			}
			else if (pt.x == 6 && pt.y == 18) {
				temp.x = 6;
				temp.y = 12;
			}
			break;
			
		//moving right
		case 3:
			if (pt.x == 2 && pt.y == 3) {
				temp.x = 3;
				temp.y = 16;
			}
			else if (pt.x == 6 && pt.y == 21) {
				temp.x = 12;
				temp.y = 12;
			}
			else if (pt.x == 3 && pt.y == 11) {
				temp.x = 14;
				temp.y = 2;
			}
			else if (pt.x == 21 && pt.y == 5) {
				temp.x = 20;
				temp.y = 20;
			}
			else if (pt.x == 5 && pt.y == 19) {
				temp.x = 6;
				temp.y = 12;
			}
			break;
			
		//moving left	
		case 4:
			if (pt.x == 4 && pt.y == 3) {
				temp.x = 3;
				temp.y = 16;
			}
			else if (pt.x == 8 && pt.y == 21) {
				temp.x = 12;
				temp.y = 12;
			}
			else if (pt.x == 5 && pt.y == 11) {
				temp.x = 14;
				temp.y = 2;
			}
			else if (pt.x == 23 && pt.y == 5) {
				temp.x = 20;
				temp.y = 20;
			}
			else if (pt.x == 7 && pt.y == 19) {
				temp.x = 6;
				temp.y = 12;
			}
			break;
		}
		
		return temp;
	}
	
}