package edu.nd.se2018.homework.homework6.model.elements;


import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Piece {
	
	Pane theRoot;
	Image pieceImage;
	ImageView pieceImageView;
	public Piece() {}
	
	public int placePieces(ObservableList<javafx.scene.Node> root, int[][] currentGrid, int LevelNum) {
		if (LevelNum == 1) {
			pieceImage = new Image("images\\Cat.png", 35, 35, true, true);
			pieceImageView = new ImageView(pieceImage);
			pieceImageView.setX(13*35);
			pieceImageView.setY(13*35);
			root.add(pieceImageView);
			currentGrid[13][13] = 2;
		}
		return 1;
	}
}