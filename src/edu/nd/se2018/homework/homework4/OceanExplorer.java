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
	PirateShip pirate1;
	Image shipImage, pirateShipImage;
	ImageView shipImageView, pirateShipImageView;
	
	@Override
	public void start(Stage oceanStage) throws Exception {
		oMap = new OceanMap(dimensions, islandCount);
		
		root = new AnchorPane();
		oMap.drawMap(root.getChildren());
		
		scene = new Scene(root, 500, 500);
		Point startPosition = oMap.getStartPoint();
		
		
		ship = new Ship(startPosition.x, startPosition.y, oMap);
		
		pirate1 = new PirateShip(4, 4, oMap);
		
		
		loadImages();
		
		oceanStage.setTitle("OceanExplorer");
		oceanStage.setScene(scene);
		oceanStage.show();
		
		ship.addObserver(pirate1);

		startSailing(ship, pirate1);
	}
	
	public void loadImages() {
		Image shipImage = new Image("images\\ColumbusShip.png", 50, 50, true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(oMap.getShipLocation(ship).x*scalingFactor);
		shipImageView.setY(oMap.getShipLocation(ship).y*scalingFactor);
		root.getChildren().add(shipImageView);
		
		Image pirateShipImage = new Image("images\\pirateship.gif", 50, 50, true, true);
		pirateShipImageView = new ImageView(pirateShipImage);
		pirateShipImageView.setX(oMap.getPirateLocation(pirate1).x*scalingFactor);
		pirateShipImageView.setY(oMap.getPirateLocation(pirate1).y*scalingFactor);
		root.getChildren().add(pirateShipImageView);
		

	}
	private void startSailing(Ship ship, PirateShip pirateship) {
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
			
			pirateShipImageView.setX(oMap.getPirateLocation(pirateship).x*scalingFactor);
			pirateShipImageView.setY(oMap.getPirateLocation(pirateship).y*scalingFactor);

			}
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

