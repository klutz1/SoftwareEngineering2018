package edu.nd.se2018.homework.homework6.cells;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PieceCell implements CellType {
	Image pieceImage;
	ImageView pieceImageView;
	Point pos;
	
	public PieceCell(int i, int j) {
		pos = new Point(i, j);
		Image pieceImage = new Image("images\\piecePic.PNG", 35, 35, true, true);
		this.pieceImageView = new ImageView(pieceImage);
		pieceImageView.setX(pos.x*35);
		pieceImageView.setY(pos.y*35);
	}
	
	
	@Override
	public void setCell(int i, int j) {
		pos = new Point(i,j);
	}
	
	@Override
	public int getX() {
		return pos.x;	
	}
	
	@Override
	public int getY() {
		return pos.y;
	}
	
	@Override
	public ImageView getImageView() {
		return pieceImageView;
	}
	
	@Override
	public boolean canBeWalkedOn() {
		return true;
	}
	
	@Override
	public int isPiece() {
		return 1;
	}

}