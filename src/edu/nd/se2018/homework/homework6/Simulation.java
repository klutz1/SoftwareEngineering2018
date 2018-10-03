package edu.nd.se2018.homework.homework6;

import java.awt.Point;

import edu.nd.se2018.homework.homework6.model.infrastructure.MapBuilder;
import edu.nd.se2018.homework.homework6.model.elements.Chip;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Simulation extends Application {

	//25 x 25 grid of squares
	final int dimensions = 25;		
	final int scalingFactor = 50;
	
	Pane root;
	Scene scene;
	MapBuilder theMap;
	Chip chip;
	
	Image chipImage;
	ImageView chipImageView;
	
	@Override
	public void start(Stage oceanStage) throws Exception {
		theMap = new MapBuilder(dimensions);
		
		root = new AnchorPane();
		theMap.drawMap(root.getChildren());
		
		scene = new Scene(root, 500, 500);
		Point startPosition = theMap.getStartPoint();
		
		//ship starts in a random location not on an island
		chip = new Chip(startPosition.x, startPosition.y, theMap);	
			
		//call the function to place images on the grid
		loadImages();
		
		oceanStage.setTitle("Chip's Challenge");
		oceanStage.setScene(scene);
		oceanStage.show();
		
		startMoving(scene);
	
	}
	
	public void loadImages() {
		
		//add the Columbus image to the ImageView
		Image chipImage = new Image("images\\blueCar.png", 50, 50, true, true);
		chipImageView = new ImageView(chipImage);
		chipImageView.setX(theMap.getShipLocation(chip).x*scalingFactor);
		chipImageView.setY(theMap.getShipLocation(chip).y*scalingFactor);
		root.getChildren().add(chipImageView);
		
	}
	
	private void startMoving(Scene scene) {
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
		
		@Override
		public void handle(KeyEvent ke) {
			switch(ke.getCode()) {
				case RIGHT: 
					chip.goRight();
					break;
				case LEFT:
					chip.goLeft();
					break;
				case UP:
					chip.goUp();
					break;
				case DOWN:
					chip.goDown();
					break;
				default:
					break;
			
				}
			
				chipImageView.setX(theMap.getShipLocation(chip).x*scalingFactor);
				chipImageView.setY(theMap.getShipLocation(chip).y*scalingFactor);
			}
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

