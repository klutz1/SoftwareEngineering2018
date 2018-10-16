package edu.nd.se2018.homework.homework6.cells;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WallCell implements CellType {
	Image wallImage;
	ImageView wallImageView;
	Point pos;
	
	public WallCell(int i, int j) {
		pos = new Point(i, j);
		Image wallImage = new Image("images\\betterWallTile.PNG", 35, 35, true, true);
		this.wallImageView = new ImageView(wallImage);
		wallImageView.setX(pos.x*35);
		wallImageView.setY(pos.y*35);
		
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
		return wallImageView;
	}
	
	@Override
	public boolean canBeWalkedOn() {
		return false;
	}

	@Override
	public int isPiece() {
		return 0;
	}

	@Override
	public int isPortal() {
		return 0;
	}

}