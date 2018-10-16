package edu.nd.se2018.homework.homework6.model.infrastructure;


import java.awt.Point;

import edu.nd.se2018.homework.homework6.model.elements.Chip;
import edu.nd.se2018.homework.homework6.model.elements.Piece;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LevelOne {
	
	private int scale;
	private int size;
	
	Chip chip;
	
	Pane root;
	Image wallImage;
	ImageView wallImageView;
	
	Piece pieces;
	
	public LevelOne(int size, Pane root, int gridScale) {
		this.root = root;
		this.scale = gridScale;
		this.size = size;
		pieces = new Piece();
	}
	
	
	public void drawLevel(ObservableList<javafx.scene.Node> root, MapBuilder map) {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map.theGrid[i][j] = 0;
			}
		}
		
		//make the edges of the map the wall
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == 0 || i == size -1) {
					map.theGrid[i][j] = 2;
				}
				else if (j == 0 || j == size - 1) {
					map.theGrid[i][j] = 2;
				}
				if (i == 7 || j == 7) {
					map.theGrid[i][j] = 2;
				}
			}
		}
		map.theGrid[4][7] = 0;
		map.theGrid[7][12] = 0;
		
		
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
		pieces.placePieces(root, map.theGrid, 1);
	}

	Point getChipLocation(Chip chip) {
		return chip.getChipLocation();
	}

}