package edu.nd.se2018.homework.homework6;

import java.awt.Component;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.WindowEvent;

import edu.nd.se2018.homework.homework6.model.infrastructure.LevelOne;
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
	final int scalingFactor = 35;
	
	Pane root;
	Scene scene;
	MapBuilder theMap;
	private Chip chip;
	
	Image chipImage, endImag;
	ImageView chipImageView, endImageView;
	
	int levelNum = 1;
	Stage theStage;
	
	//this function is called once
	@Override
	public void start(Stage stage) throws Exception {
		
		root = new AnchorPane();
		
		theMap = new MapBuilder(dimensions, root, scalingFactor);
		chip = new Chip(3, 3, theMap);
		
		theMap.drawLevelOne(root.getChildren());
		
		scene = new Scene(root, 875, 875);
		theStage = stage;
		
	//	Point startPosition = theMap.getStartPoint();
	//	chip = new Chip(startPosition.x, startPosition.y, theMap);	
			
		loadImages();
		//call the function to place images on the grid

		stage.setTitle("Chip's Challenge");
		stage.setScene(scene);
		stage.show();
		
		startMoving(scene);
		
	}
	
	public void loadImages() {

		Image chipImage = new Image("images\\chipRight.png", scalingFactor, scalingFactor, true, true);
		chipImageView = new ImageView(chipImage);
		
	
		Image endImage = new Image("images\\endPoint.PNG", scalingFactor, scalingFactor, true, true);
		endImageView = new ImageView(endImage);
		endImageView.setX(10*scalingFactor);
		endImageView.setY(10*scalingFactor);
		root.getChildren().add(endImageView);
	
		chipImageView.setX(theMap.getChipLocation(chip).x*scalingFactor);
		chipImageView.setY(theMap.getChipLocation(chip).y*scalingFactor);
		root.getChildren().add(chipImageView);
			
	}
	
	
	private void startMoving(Scene scene) {
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
		
		@Override
		public void handle(KeyEvent ke) {
			switch(ke.getCode()) {
				case RIGHT: 
					chip.goRight(theMap);
					break;
				case LEFT:
					chip.goLeft(theMap);
					break;
				case UP:
					chip.goUp(theMap);
					break;
				case DOWN:
					chip.goDown(theMap);
					break;
				case B:
					break;
				case ESCAPE: 
					System.out.println("escape hit");
					theStage.close();
					break;
				default:
					break;
			
				}
			
				chipImageView.setX(theMap.getChipLocation(chip).x*scalingFactor);
				chipImageView.setY(theMap.getChipLocation(chip).y*scalingFactor);
			
				if (theMap.getChipLocation(chip).x == 10 && theMap.getChipLocation(chip).y == 10) {
					theMap.drawLevelTwo(root.getChildren());
					chipImageView.toFront();
				}
				//TODO: this is where to update the images displayed
				
			}
		
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

