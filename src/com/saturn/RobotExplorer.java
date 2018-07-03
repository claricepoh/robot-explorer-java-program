/**
 * @Author Clarice Poh
 * @Description The RobotExplorer class models the position & orientation pertaining to Robot
 * 
 */

package com.saturn;

public class RobotExplorer {
	
	public enum Orientation {
		NORTH,
		SOUTH,
		EAST,
		WEST
	}
	
	private Grid grid; 
	
	private int xCoordinate;   								// representation of x coordinates as in Grid
	private int yCoordinate;   								// representation of y coordinates as in Grid
	private Orientation orientation;        				// representation of four cardinal compass points: North, South, East, West 

	public RobotExplorer(Grid grid, String[] inputStrTokens) {
		this.grid = grid;
		
		xCoordinate = Integer.parseInt(inputStrTokens[0]);  // index 0 represents x-coordinate 
		yCoordinate = Integer.parseInt(inputStrTokens[1]);  // index 1 represents y-coordinate
		
		switch(inputStrTokens[2].toUpperCase()) {           /* index 2 represents cardinal compass points */
			case "N":
				orientation = Orientation.NORTH;
				break;
			case "S": 
				orientation = Orientation.SOUTH;
				break;
			case "E":
				orientation = Orientation.EAST;
				break;
			case "W":
				orientation = Orientation.WEST;
				break;
		}
	}

	public boolean instruct(char cmd) {
		
		switch( Character.toUpperCase(cmd) ) {
			case 'L':
				{
					switch(orientation) {
						case NORTH:
							orientation = Orientation.WEST;
							break;
						case WEST:
							orientation = Orientation.SOUTH;
							break;
						case SOUTH:
							orientation = Orientation.EAST;
							break;
						case EAST:
							orientation = Orientation.NORTH;
							break;
					}
				}
				break;
			case 'R':
				{
					switch(orientation) {
						case NORTH:
							orientation = Orientation.EAST;
							break;
						case EAST:
							orientation = Orientation.SOUTH;
							break;
						case SOUTH:
							orientation = Orientation.WEST;
							break;
						case WEST:
							orientation = Orientation.NORTH;
							break;
					}
				}
				break;
			case 'M':
				{
					switch(orientation) {
						case NORTH:
							if( yCoordinate + 1 <= grid.getMaxCoordinateY() ) {
								yCoordinate += 1; 
							} else {
								return false; 
							}
							break; 
						case WEST:
							if ( xCoordinate - 1 >= grid.getMinCoordinateX() ) {
								xCoordinate -= 1; 
							} else {
								return false;
							}
							break;
						case SOUTH:
							if ( yCoordinate - 1 >= grid.getMinCoordinateY() ) {
								yCoordinate -= 1; 
							} else  {
								return false;
							}
							break;
						case EAST:
							if ( xCoordinate + 1 <= grid.getMaxCoordinateX() ) {
								xCoordinate += 1; 
							} else {
								return false;
							}
							break;
					}
				}
				break;
		}
		return true; 
	}
	
	public void printFinalPosition() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(xCoordinate + " " + yCoordinate + " ");
		
		switch(orientation) {
			case NORTH:
				buffer.append('N');
				break;
			case WEST:
				buffer.append('W');
				break;
			case SOUTH:
				buffer.append('S');
				break;
			case EAST:
				buffer.append('E');
				break;
		}
		
		System.out.println(buffer);
	}
	
	/* for testing purpose */
	public int getXCoordinate() {
		return this.xCoordinate;
	}
	
	public int getYCoordinate() {
		return this.yCoordinate;
	}
	
	public Orientation getOrientation() {
		return this.orientation;
	}
}