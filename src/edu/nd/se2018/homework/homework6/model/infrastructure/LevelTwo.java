package edu.nd.se2018.homework.homework6.model.infrastructure;


import java.awt.Point;

import edu.nd.se2018.homework.homework6.model.elements.Chip;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LevelTwo {
	
	private int scale;
	private int size;
	
	Chip chip;
	
	Pane root;
	Image wallImage;
	ImageView wallImageView;
	public LevelTwo(int size, Pane root, int gridScale) {
		this.root = root;
		this.scale = gridScale;
		this.size = size;
	}
	
	public void drawLevel(ObservableList<javafx.scene.Node> root, MapBuilder map) {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == 10 && j == 10) {
					//do nothing
				}
				else {
					map.theGrid[i][j] = 0;
				}
			}	
		}
		
		//draw the map
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == size - 1 || j == size - 1 || i == 0 || j == 0) {
					map.theGrid[i][j] = 2;
				}
			}
		}
		
		//place the images on the map
		for (int h = 0; h < size; h++) {
			for (int d = 0; d < size; d++) {
				Rectangle rect = new Rectangle(h*scale, d*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				if (map.theGrid[h][d] == 2) {
					rect.setFill(Color.DARKGRAY);
					root.add(rect);
					wallImage = new Image("images\\betterWallTile.PNG", scale, scale, true, true);
					wallImageView = new ImageView(wallImage);
					wallImageView.setX(h*scale);
					wallImageView.setY(d*scale);
					root.add(wallImageView);
				}
				else {
					rect.setFill(Color.LIGHTGRAY);
					root.add(rect);
				}
			}
		}
		System.out.println("Level two drawn!");
	}
	
	
	public Point getChipLocation(Chip chip) {
		return chip.getChipLocation();
	}
	

}