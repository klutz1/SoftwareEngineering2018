package edu.nd.se2018.homework.homework6.cells;

import javafx.scene.image.ImageView;

public interface CellType {

	public abstract void setCell(int iVal, int jVal);
	public abstract int getX();
	public abstract int getY();
	public abstract ImageView getImageView();
	public abstract boolean canBeWalkedOn();
}