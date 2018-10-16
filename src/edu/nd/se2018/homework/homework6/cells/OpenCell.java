package edu.nd.se2018.homework.homework6.cells;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OpenCell implements CellType {
	
	Image openImage;
	ImageView openImageView;
	Point pos;
	
	public OpenCell(int i, int j) {
		pos = new Point(i, j);
		Image openImage = new Image("images\\BlankTile.png", 35, 35, true, true);
		this.openImageView = new ImageView(openImage);
		openImageView.setX(pos.x*35);
		openImageView.setY(pos.y*35);
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
		return openImageView;
	}
	
	@Override
	public boolean canBeWalkedOn() {
		return true;
	}

	@Override
	public int isPiece() {
		// TODO Auto-generated method stub
		return 0;
	}
}