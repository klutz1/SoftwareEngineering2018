package edu.nd.se2018.homework.homework4;

import java.awt.Point;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;

public class OceanExplorer extends Application {

	//boolean[][] islandMap;
	//10 x 10 grid of squares
	final int dimensions = 10;		
	
	final int scalingFactor = 50;
	
	//10 randomly placed islands on the map
	final int islandCount = 10;
	Pane root;
	Scene scene;
	OceanMap oMap;
	Ship ship;
	PirateShip pirate1, pirate2;
	Image shipImage, pirateShipImage;
	ImageView shipImageView, pirateShipImageView, pirateShipImageView2;
	
	@Override
	public void start(Stage oceanStage) throws Exception {
		oMap = new OceanMap(dimensions, islandCount);
		
		root = new AnchorPane();
		oMap.drawMap(root.getChildren());
		
		scene = new Scene(root, 500, 500);
		Point startPosition = oMap.getStartPoint();
		
		//ship starts in a random location not on an island
		ship = new Ship(startPosition.x, startPosition.y, oMap);	
		
		Point pirate1Pos = oMap.getPirate1StartPoint();
		Point pirate2Pos = oMap.getPirate2StartPoint();
		pirate1 = new PirateShip(pirate1Pos.x, pirate1Pos.y, oMap);
		pirate2 = new PirateShip(pirate2Pos.x, pirate2Pos.y, oMap);			
		
		//call the function to place images on the grid
		loadImages();
		
		oceanStage.setTitle("OceanExplorer");
		oceanStage.setScene(scene);
		oceanStage.show();
		
		//Pirates observe the Columbus ship
		ship.addObserver(pirate1);
		ship.addObserver(pirate2);

		startSailing(scene);
	}
	
	public void loadImages() {
		
		//add the Columbus image to the ImageView
		Image shipImage = new Image("images\\ColumbusShip.png", 50, 50, true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(oMap.getShipLocation(ship).x*scalingFactor);
		shipImageView.setY(oMap.getShipLocation(ship).y*scalingFactor);
		root.getChildren().add(shipImageView);
		
		Image pirateShipImage = new Image("images\\pirateship.gif", 50, 50, true, true);
		pirateShipImageView = new ImageView(pirateShipImage);
		pirateShipImageView2 = new ImageView(pirateShipImage);
		
		//add the first pirate image to the ImageView
		pirateShipImageView.setX(oMap.getPirateLocation(pirate1).x*scalingFactor);
		pirateShipImageView.setY(oMap.getPirateLocation(pirate1).y*scalingFactor);
		
		//Add the second pirate image to the ImageView
		pirateShipImageView2.setX(oMap.getPirateLocation(pirate2).x*scalingFactor);
		pirateShipImageView2.setY(oMap.getPirateLocation(pirate2).y*scalingFactor);
		root.getChildren().add(pirateShipImageView);
		root.getChildren().add(pirateShipImageView2);
		

	}
	private void startSailing(Scene scene) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
		
		//all of the functionality for moving the Columbus ship	
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
			
			//each time Columbus moves, the pirates also move as observers
			pirateShipImageView.setX(oMap.getPirateLocation(pirate1).x*scalingFactor);
			pirateShipImageView.setY(oMap.getPirateLocation(pirate1).y*scalingFactor);
			
			pirateShipImageView2.setX(oMap.getPirateLocation(pirate2).x*scalingFactor);
			pirateShipImageView2.setY(oMap.getPirateLocation(pirate2).y*scalingFactor);
			}
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

