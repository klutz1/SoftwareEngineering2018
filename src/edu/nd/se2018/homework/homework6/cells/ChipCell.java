package edu.nd.se2018.homework.homework6.cells;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChipCell implements CellType {
	
	private Point pos;
	private ImageView chipImageView;
	private Image chipImage;
			
	public ChipCell(int i, int j) {
		pos = new Point(i, j);
		Image chipImage = new Image("images\\chipRight.png", 35, 35, true, true);
		this.chipImageView = new ImageView(chipImage);
		chipImageView.setX(pos.x*35);
		chipImageView.setY(pos.y*35);
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
		return this.chipImageView;
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