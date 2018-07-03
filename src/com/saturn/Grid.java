/**
 *   @Author Clarice Poh
 *   @Description Grid class models information pertaining to landing area  
 *    
 */

package com.saturn;

import java.util.List;
import java.util.ArrayList; 

public class Grid {
	private static Grid instance; 
	private int maxCoordinateX, maxCoordinateY, minCoordinateX, minCoordinateY; 
	
	private RobotExplorer activeRobotExplorer; 
	private List<RobotExplorer> robotExplorers; 
	
	private Grid (int maxCoordinateX, int maxCoordinateY) {
		this.maxCoordinateX = maxCoordinateX; 
		this.maxCoordinateY = maxCoordinateY; 
		this.minCoordinateX = 0;   // default value
		this.minCoordinateY = 0;   // default value
		robotExplorers = new ArrayList<>(); 
	}
	
	public static Grid getInstance(String[] inputStrTokens) {
		if (instance == null) {
			instance = new Grid( Integer.parseInt(inputStrTokens[0]),    // index 0 represents x-coordinate
				             Integer.parseInt(inputStrTokens[1]) );  // index 1 represents y-coordinate
		}
		return instance; 
	}
	
	public void createRobotExplorer(String[] inputStrTokens) {
		activeRobotExplorer = new RobotExplorer(this, inputStrTokens);
		robotExplorers.add(activeRobotExplorer); 
	}
	
	public void instructRobotExplorer(String[] inputStrTokens) {
		for(String cmd : inputStrTokens) {
			if ( !activeRobotExplorer.instruct(cmd.charAt(0)) ) {
				// The move instruction caused the robot's position exceed the maximum or minimum x, y coordinates of landing area
				// For this case, robot's position remain. 
				// Future Improvement: Display warning to user ?
			}
		}
	}
	
	public int getMaxCoordinateY() {
		return maxCoordinateY; 
	}
	
	public int getMaxCoordinateX() {
		return maxCoordinateX; 
	}
	
	public int getMinCoordinateX() {
		return minCoordinateX; 
	}
	
	public int getMinCoordinateY() {
		return minCoordinateY; 
	}
	
	public void printStatus() {
		for(int i=0; i<robotExplorers.size(); i++) {
			robotExplorers.get(i).printFinalPosition();
		}
	}
}
