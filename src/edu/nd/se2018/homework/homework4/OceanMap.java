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
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Rectangle rect = new Rectangle(i*scale, j*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				root.add(rect);
				oceanGrid[i][j] = 0;
			}
		}
	}

	
	public Point getShipLocation(Ship ship) {
		return ship.getShipLocation();
	}
	public Point getStartPoint(){
		return new Point(5,5);
	}

}