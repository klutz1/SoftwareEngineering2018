package edu.nd.se2018.homework.homework5;

import java.util.ArrayList;
import java.util.Collection;

import edu.nd.se2018.homework.homework5.model.infrastructure.MapBuilder;
import edu.nd.se2018.homework.homework5.model.infrastructure.RailwayTracks;
import edu.nd.se2018.homework.homework5.model.infrastructure.Road;
import edu.nd.se2018.homework.homework5.model.infrastructure.gate.CrossingGate;
import edu.nd.se2018.homework.homework5.model.vehicles.Car;
import edu.nd.se2018.homework.homework5.model.vehicles.Train;
import edu.nd.se2018.homework.homework5.view.MapDisplay;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Simulation extends Application{
	
	private Pane root;
	private Scene scene;
	private MapBuilder mapBuilder;
	private MapDisplay mapDisplay;
	
	@Override  
	public void start(Stage stage) throws Exception {
		
		root = new Pane();
		
		// Build infrastructure
		mapBuilder = new MapBuilder();
		mapDisplay = new MapDisplay(root, mapBuilder.getRoads(), mapBuilder.getTracks(),mapBuilder.getAllGates());					
		mapDisplay.drawTracks();		
		mapDisplay.drawRoad();
		mapDisplay.drawGate();
		
		scene = new Scene(root,1200,1000);
		stage.setTitle("Railways");
		stage.setScene(scene);
		stage.show();
				
		// Train
		RailwayTracks track = mapBuilder.getTrack("Royal");
		Train train = new Train(track.getEndX()+100,track.getEndY()-25);
		root.getChildren().add(train.getImageView());
		
		RailwayTracks track2 = mapBuilder.getNewTrack("Katie");
		Train train2 = new Train(0, track2.getEndY()-20);
		root.getChildren().add(train2.getImageView());
		
		for(CrossingGate gate: mapBuilder.getAllGates()) {
			train.addObserver(gate);
			train2.addObserver(gate);
		}
			
				
		// Sets up a repetitive loop i.e., in handle that runs the actual simulation
		new AnimationTimer(){

			@Override
			public void handle(long now) {
			
				createCar();
				train.move();
				train2.moveWesttoEast();
				
				for(CrossingGate gate: mapBuilder.getAllGates())
					gate.operateGate();
				
				if (train.offScreen())
					train.reset();
				
				if (train2.offScreen()) {
					train2.reset();
				}
						
				clearCars();				
			}
		}.start();
	}
	
	// Clears cars as they leave the simulation
	private void clearCars(){
		Collection<Road> roads = mapBuilder.getRoads();
		for(Road road: roads){			
			if (road.getCarFactory()!= null){
				ArrayList<Car> junkCars = road.getCarFactory().removeOffScreenCars();	
				mapDisplay.removeCarImages(junkCars);
			}
		}
	}
	
	private void createCar(){
		Collection<Road> roads = mapBuilder.getRoads();
		for(Road road: roads){
			if (road.getCarFactory() != null){
				if ((int)(Math.random() * 100) == 15){
					Car car = road.getCarFactory().buildCar();
					road.addNumCarsToRoad();
					if (car != null){
						root.getChildren().add(car.getImageView());
					}
				}
			}
		}
	}
	
	public static void main(String[] args){
		launch(args);
	}
}
