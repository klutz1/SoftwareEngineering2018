package edu.nd.se2018.homework.homework6.model.infrastructure;


import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import javax.xml.soap.Node;

import edu.nd.se2018.homework.homework6.model.elements.Chip;

import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MapBuilder {
	final int size = 25;
	
	public int[][] theGrid = new int[25][25];
	
	final int scale = 35;
	
	private int startingX;
	private int startingY;

	ObservableList<Node> root;
		
	//Constructor
	public MapBuilder(int size) {
		size = this.size;
	}

	public void drawMap(ObservableList<javafx.scene.Node> root) {
		
		//first, initialize all grid values to zero
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				theGrid[i][j] = 0;
			}
		}
		
		for (int h = 0; h < size; h++) {
			for (int d = 0; d < size; d++) {
				Rectangle rect = new Rectangle(h*scale, d*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				if (theGrid[h][d] == 2) {
					rect.setFill(Color.DARKGRAY);
					root.add(rect);
				}
				else {
					rect.setFill(Color.LIGHTGRAY);
					root.add(rect);
				}
			}
		}
	}
	
	public Point getShipLocation(Chip chip) {
		return chip.getShipLocation();
	}
	

	public Point getStartPoint(){
		Random rand = new Random();
		boolean placed = false;
		while (!placed) {
			int x = rand.nextInt(9);
			int y = rand.nextInt(9);
			if (theGrid[x][y] == 0) {
				startingX = x;
				startingY = y;
				return new Point(x, y);
			}
		}
		return new Point(0,0);
	}
	
}