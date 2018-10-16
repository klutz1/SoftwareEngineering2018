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
import edu.nd.se2018.homework.homework6.movement.MapBuilder;

public class Main extends Application {

	Chip chip;
	Stage theStage;
	Pane root;
	Scene scene;
	private MapBuilder theMap;
	
	@Override
	public void start(Stage stage) throws Exception {
		root = new AnchorPane();
		
		scene = new Scene(root, 875, 875);
		theStage = stage;
		
		stage.setTitle("Chip's Challenge");
		stage.setScene(scene);
		stage.show();
		
		startLevelOne();
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
					chip.moveChip(ke, root);
				}
				if(ke.getCode() == KeyCode.B) {
					updateLevel();
				}
			}
		 	
		});
	}
		
	public void startLevelOne() {
		root.getChildren().clear();
		theMap = new LevelOne(root).drawLevel();
		chip = Chip.getOnlyChip();
	}
	
	
	public void updateLevel() {
		root.getChildren().clear();
	//	theMap = new LevelTwo(root).drawLevel();
		
	};
	
	
	public static void main(String[] args) {
		launch(args);
	}
}