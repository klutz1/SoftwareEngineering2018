package edu.nd.se2018.homework.homework4;

import java.awt.Point;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javafx.stage.Stage;

public class OceanExplorer extends Application {
	

	boolean[][] islandMap;
	final int dimensions = 10;
	
	final int scalingFactor = 50;
	final int islandCount = 10;
	Pane root;
	Scene scene;
	OceanMap oMap;
	Ship ship;
	Image shipImage;
	ImageView shipImageView;
	
	@Override
	public void start(Stage oceanStage) throws Exception {
		oMap = new OceanMap(dimensions, islandCount);
		
		
		root = new AnchorPane();
		oMap.drawMap(root.getChildren());
		
		scene = new Scene(root, 500, 500);
		Point startPosition = oMap.getStartPoint();
		
		
		ship = new Ship(startPosition.x, startPosition.y, oMap);
		loadImage();
		
		oceanStage.setTitle("OceanExplorer");
		oceanStage.setScene(scene);
		oceanStage.show();
		
		startSailing(ship);
	}
	
	public void loadImage() {
		Image shipImage = new Image("images\\ColumbusShip.png", 50, 50, true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(oMap.getShipLocation(ship).x*scalingFactor);
		shipImageView.setY(oMap.getShipLocation(ship).y*scalingFactor);
		root.getChildren().add(shipImageView);
		System.out.println("imageadded");
		
	}
	private void startSailing(Ship ship) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
		
		@Override
		public void handle(KeyEvent ke) {
			switch(ke.getCode()) {
				case RIGHT: 
					ship.goEast();
					break;
				case LEFT:
					ship.goWest();
					break;
				case UP:
					ship.goNorth();
					break;
				case DOWN:
					ship.goSouth();
					break;
				default:
					break;
			
				}
			shipImageView.setX(oMap.getShipLocation(ship).x*scalingFactor);
			shipImageView.setY(oMap.getShipLocation(ship).y*scalingFactor);
			}
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

