package edu.nd.se2018.homework.homework4;


import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.soap.Node;

import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Random;

public class OceanMap {
	final int size = 25;
	
	public OceanMap(int size, int islandNum) {
		size = this.size;
	}
	
	int[][] oceanGrid = new int[25][25];
	
	final int scale = 50;
	
	ObservableList<Node> root;
	public void drawMap(ObservableList<javafx.scene.Node> root) {
		//setIslands();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				oceanGrid[i][j] = 0;
			}
		}
			
		int k = 0;
		while (k < 10) {
			Random rand = new Random();
			int x = rand.nextInt(9);
			int y = rand.nextInt(9);
			if (oceanGrid[x][y] == 0) {
				oceanGrid[x][y] = 2;
				k++;
			}
		}
		for (int h = 0; h < size; h++) {
			for (int d = 0; d < size; d++) {
				Rectangle rect = new Rectangle(h*scale, d*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				if (oceanGrid[h][d] == 2) {
					rect.setFill(Color.GREEN);
					root.add(rect);
				}
				else {
					rect.setFill(Color.PALETURQUOISE);
					root.add(rect);
				}
				
			}
		}
	}

	public Point getPirateLocation(PirateShip pirate) {
		return pirate.getPirateLocation();
	}
	
	public Point getShipLocation(Ship ship) {
		return ship.getShipLocation();
	}
	public Point getStartPoint(){
		Random rand = new Random();
		boolean placed = false;
		while (!placed) {
			int x = rand.nextInt(9);
			int y = rand.nextInt(9);
			if (oceanGrid[x][y] == 0) {
				return new Point(x, y);
			}
		}
		return new Point(0,0);
	}

}