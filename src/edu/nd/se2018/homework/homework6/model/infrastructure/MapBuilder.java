package edu.nd.se2018.homework.homework6.model.infrastructure;

import java.awt.Point;


import edu.nd.se2018.homework.homework6.model.elements.Chip;
import edu.nd.se2018.homework.homework6.model.infrastructure.LevelOne;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class MapBuilder {
	private int size = 25;
	private int scale = 35;
	public int[][] theGrid = new int[25][25];
	Pane root;
	LevelOne levelone;
	LevelTwo leveltwo;
	Chip chip;
	
	
	//Constructor
	public MapBuilder(int size, Pane root, int gridScale) {
		this.root = root;
		this.scale = gridScale;
		this.size = size;
		levelone = new LevelOne(this.size, this.root, this.scale);
		leveltwo = new LevelTwo(this.size, this.root, this.scale);
	}

	
	public void drawLevelOne(ObservableList<javafx.scene.Node> root) {
		levelone.drawLevel(root, this);
	}
	
	public void drawLevelTwo(ObservableList<javafx.scene.Node> root) {
		leveltwo.drawLevel(root, this);
	}
	
	public Point getChipLocation(Chip chip) {
		return chip.getChipLocation();
	}

	
}