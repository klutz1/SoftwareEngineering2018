package edu.nd.se2018.homework.homework6.game;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import edu.nd.se2018.homework.homework6.movement.Chip;
import edu.nd.se2018.homework.homework6.movement.LevelOne;
import edu.nd.se2018.homework.homework6.movement.LevelTwo;
import edu.nd.se2018.homework.homework6.movement.MapBuilder;
import edu.nd.se2018.homework.homework6.states.*;

public class Main extends Application {

	Chip chip;
	Stage theStage;
	Pane root;
	Scene scene;
	private MapBuilder theMap;
	MapBuilder overallMap = null;
	private int currentLevel = 0;
	StateImplementation currState;
	
	@Override
	public void start(Stage stage) throws Exception {
		root = new AnchorPane();
		scene = new Scene(root, 875, 875);
		theStage = stage;
		
		stage.setTitle("Chip's Challenge");
		stage.setScene(scene);
		stage.show();
		
		currState = new StateImplementation();
		
		startLevelOne();
		currentLevel = 1;
		overallMap = MapBuilder.returnOnlyMap();
		startMoving(scene);
	}
	
	
	private void startMoving(Scene scene) {
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
		
			@Override
			public void handle(KeyEvent ke) {
				
				if (ke.getCode() == KeyCode.ESCAPE) {
					theStage.close();
				}
				else {
					chip.moveChip(ke, root, theMap, currentLevel);
				}
				
				int temp = currState.getState(theMap.getPieces());
				
				//change the level when enough pieces are gathered
				if (temp == 2 && currentLevel == 1 && chip.getChipsPosition().x == 23 && chip.getChipsPosition().y == 23) {
					updateLevel();
					currentLevel = 2;
				}
				
				//this happens when Chip wins the game
				else if (temp == 2 && currentLevel == 2 && chip.getChipsPosition().x == 23 && chip.getChipsPosition().y == 23) {
					System.out.println("YOU BEAT THE GAME");
					theStage.close();
				}
			}
		 	
		});
	}
		
	
	//draw the first level
	public void startLevelOne() {
		root.getChildren().clear();
		this.theMap = new LevelOne(root).drawLevel();
		System.out.println("How to play: Pick up all of the chips & choose all of the right portals to reach the ending cell");
		chip = Chip.getOnlyChip();
	}
	
	//clear the first level & draw the second level
	public void updateLevel() {
		root.getChildren().clear();
		this.theMap = new LevelTwo(root).drawLevel();
		System.out.println("How to play: Pick up all of the chips but be careful! Every time you leave a cell, a wall is built and you can't go back!");
		chip = Chip.getOnlyChip();
	};
	
	
	public static void main(String[] args) {
		launch(args);
	}
}