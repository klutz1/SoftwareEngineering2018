package edu.nd.se2018.homework.homework6.cells;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WinningCell implements CellType {
	Image winImage;
	ImageView winImageView;
	Point pos;
	
	public WinningCell(int i, int j) {
		pos = new Point(i, j);
		Image winImage = new Image("images\\endPoint.PNG", 35, 35, true, true);
		this.winImageView = new ImageView(winImage);
		winImageView.setX(pos.x*35);
		winImageView.setY(pos.y*35);
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
		return winImageView;
	}
	
	@Override
	public boolean canBeWalkedOn() {
		return true;
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
