/**
 * @Author Clarice Poh
 * @Description Main Program Entry Point 
 * 
 */

package com.saturn;

import java.util.Scanner;  

public class Saturn {
	
	private static Grid grid; 
	
	public static void main(String[] args) {
		
		InputFormatter inputFormatter = InputFormatter.getInputFormatter(); 
		
		System.out.println(" *** Input the grid size for landing area, follow by a series of position and navigation pertaining to Robot Explorers *** "); 
		
		try(Scanner scanner = new Scanner(System.in)) {
			
			while(scanner.hasNextLine()) {
				String inputString = scanner.nextLine(); 
				
				if (inputString.length() == 0) {
					if (grid != null) {
						System.out.println(" *** Final position for all Robot Explorers *** ");
						grid.printStatus(); 
					}
				} else {
					try {
						// Parse and Validate the received message 
						inputFormatter.parseString(inputString);  
						
						// Process the received message 
						switch(inputFormatter.getState()) {
							case GRID_SIZE_INITIALIZATION:
								{  
									// Only initialize grid once
									if(grid == null) {
										grid = Grid.getInstance(inputFormatter.getStrTokens()); 
									}
								}
								break; 
							case ROBOT_EXPLORER_POSITION_INITIALIZATION:
								{
									if(grid == null) { /* this should not happen */ }
									grid.createRobotExplorer(inputFormatter.getStrTokens()); 	
								}
							    break;
							case ROBOT_EXPLORER_INSTRUCTION_INITIALIZATION:
								{
									if(grid == null) { /* this should not happen */ }
									grid.instructRobotExplorer(inputFormatter.getStrTokens()); 
								}
								break;
							default: 
								// Unexpected state for input message 
								break;
						}
						
						inputFormatter.updateState();
						
					} catch(Exception e) {
						System.out.println("Warning: " + e.toString());
					}
				}
			}
		}

	}
}
