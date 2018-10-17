package edu.nd.se2018.homework.homework6.movement;

import java.awt.Point;

public class Portal {
	
	
	public Point portalBehavior(Point pt, int dir) {
	//dir: 1 is up, 2 is down, 3 is right, 4 is right
	//Portals @ locations (22,5), (4,11), (7,21), (3,3), (6, 19)
		Point temp;
		temp = new Point(8, 8);
		switch(dir) {
		
		//moving up
		case 1: 
			if (pt.x == 3 && pt.y == 4) {
				temp.x = 3;
				temp.y = 16;
			}
			else if (pt.x == 7 && pt.y == 22) {
				temp.x = 12;
				temp.y = 12;
			}
			else if (pt.x == 4 && pt.y == 12) {
				temp.x = 14;
				temp.y = 2;
			}
			else if (pt.x == 22 && pt.y == 6) {
				temp.x = 20;
				temp.y = 20;
			}
			else if (pt.x == 6 && pt.y == 20) {
				temp.x = 6;
				temp.y = 12;
			}
			break;
			
		//moving down
		case 2:
			if (pt.x == 3 && pt.y == 2) {
				temp.x = 3;
				temp.y = 16;
			}
			else if (pt.x == 7 && pt.y == 20) {
				temp.x = 12;
				temp.y = 12;
			}
			else if (pt.x == 4 && pt.y == 10) {
				temp.x = 14;
				temp.y = 2;
			}
			else if (pt.x == 22 && pt.y == 4) {
				temp.x = 20;
				temp.y = 20;
			}
			else if (pt.x == 6 && pt.y == 18) {
				temp.x = 6;
				temp.y = 12;
			}
			break;
			
		//moving right
		case 3:
			if (pt.x == 2 && pt.y == 3) {
				temp.x = 3;
				temp.y = 16;
			}
			else if (pt.x == 6 && pt.y == 21) {
				temp.x = 12;
				temp.y = 12;
			}
			else if (pt.x == 3 && pt.y == 11) {
				temp.x = 14;
				temp.y = 2;
			}
			else if (pt.x == 21 && pt.y == 5) {
				temp.x = 20;
				temp.y = 20;
			}
			else if (pt.x == 5 && pt.y == 19) {
				temp.x = 6;
				temp.y = 12;
			}
			break;
			
		//moving left	
		case 4:
			if (pt.x == 4 && pt.y == 3) {
				temp.x = 3;
				temp.y = 16;
			}
			else if (pt.x == 8 && pt.y == 21) {
				temp.x = 12;
				temp.y = 12;
			}
			else if (pt.x == 5 && pt.y == 11) {
				temp.x = 14;
				temp.y = 2;
			}
			else if (pt.x == 23 && pt.y == 5) {
				temp.x = 20;
				temp.y = 20;
			}
			else if (pt.x == 7 && pt.y == 19) {
				temp.x = 6;
				temp.y = 12;
			}
			break;
		}
		
		return temp;
	}
}