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
	
	@Override
	public void start(Stage oceanStage) throws Exception {
		oMap = new OceanMap(dimensions, islandCount);
		
		root = new AnchorPane();
		oMap.drawMap(root.getChildren());
		
		scene = new Scene(root, 500, 500);
		
		oceanStage.setTitle("OceanExplorer");
		oceanStage.setScene(scene);
		oceanStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


