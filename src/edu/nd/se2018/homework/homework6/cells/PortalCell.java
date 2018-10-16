package edu.nd.se2018.homework.homework6.cells;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PortalCell implements CellType {
	
	Image portalImage;
	ImageView portalImageView;
	Point pos;
	
	public PortalCell(int i, int j) {
		pos = new Point(i, j);
		Image portalImage = new Image("images\\portalPic.PNG", 35, 35, true, true);
		this.portalImageView = new ImageView(portalImage);
		portalImageView.setX(pos.x*35);
		portalImageView.setY(pos.y*35);
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
		return portalImageView;
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
		return 1;
	}
	
}