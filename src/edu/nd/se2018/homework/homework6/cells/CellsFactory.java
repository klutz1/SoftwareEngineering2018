package edu.nd.se2018.homework.homework6.cells;

import edu.nd.se2018.homework.homework6.movement.MapBuilder;

public class CellsFactory {
	
	public CellsFactory() {}
	
	public void drawCell(int iPos, int jPos, Cell kindOfCell, MapBuilder theMap) {

		switch(kindOfCell) {

		case OPENCELL:
	 		theMap.setCell(new OpenCell(iPos, jPos));
			break;
		
		case WALLCELL:
			theMap.setCell(new WallCell(iPos, jPos));
			break;
		
		case WINNINGCELL:
			theMap.setCell(new WinningCell(iPos, jPos));
			break;
		
		case PIECECELL:
			theMap.setCell(new PieceCell(iPos, jPos));
			break;
		case PORTALCELL:
			theMap.setCell(new PortalCell(iPos, jPos));
			break;
		}
		
	}

}