/**
 *  @Author Clarice Poh 
 *  @Description InputFormatter class parse and validate the input message ; 
 *               transition of the input message into different initialized states
 *  	
 */

package com.saturn;

public class InputFormatter {
	
	public enum State {
		GRID_SIZE_INITIALIZATION, 
		ROBOT_EXPLORER_POSITION_INITIALIZATION,
		ROBOT_EXPLORER_INSTRUCTION_INITIALIZATION
	}
	
	private State nextState; 
	private State currentState; 
	private static InputFormatter inputFormatter; 
	private String[] strTokens; 
	
	private InputFormatter() {
		currentState = State.GRID_SIZE_INITIALIZATION; 
	}
	
	public static InputFormatter getInputFormatter() {
		if (inputFormatter == null) {
			inputFormatter = new InputFormatter(); 
		}
		return inputFormatter; 
	}
	
	public State getState() {
		return currentState; 
	}
	
	public void updateState() {
		currentState = nextState; 
	}
	
	public String[] getStrTokens() {
		return strTokens; 
	}
	
	public void parseString (String s) throws Exception {
		s = s.trim().replaceAll(" +", " "); 
		
		switch(currentState) {
			case GRID_SIZE_INITIALIZATION:
				{
					if( parseGridSize(s) ) {
						nextState = State.ROBOT_EXPLORER_POSITION_INITIALIZATION;
					}
				}
				break; 
			case ROBOT_EXPLORER_POSITION_INITIALIZATION: 
				{
					if( parseRobotPosition(s) ) {
						nextState = State.ROBOT_EXPLORER_INSTRUCTION_INITIALIZATION; 
					}
				}
				break; 
			case ROBOT_EXPLORER_INSTRUCTION_INITIALIZATION: 
				{
					if( parseRobotInstruction(s) ) {
						nextState = State.ROBOT_EXPLORER_POSITION_INITIALIZATION; 
					}
				}
			    	break;
		    	default: 
		    		// Unsupported state for input message 
		    		break; 
		}
	}
	
	private boolean validateCoordinate(String strToken) {
		return strToken.matches("\\d+"); 
	}
	
	private boolean parseGridSize(String inputStr) throws Exception {
		
		strTokens = inputStr.split(" "); 
		
		if(strTokens.length != 2) {
			throw new Exception("For grid coordinates, please enter 2 positive integers, separated by space, e.g: 5 5"); 
		}
		
		for(String strToken : strTokens) {
			if( !validateCoordinate(strToken) ) {
				throw new Exception("Grid coordinates must be positive integer"); 
			}
		}
		return true; 
	}
	
	private boolean parseRobotPosition(String inputStr) throws Exception {
		
		strTokens = inputStr.split(" ");
		
		if(strTokens.length != 3) {
			throw new Exception("For robot explorer's position, please enter 2 positive integers, follow by N/W/S/E orientation, separated by space, e.g. 1 2 N"); 
		}
		
		for(int i=0; i<strTokens.length; i++) {
			if (i != (strTokens.length - 1) ) {
				if(!validateCoordinate(strTokens[i])) {
					throw new Exception("Robot Explorer's position must be integer"); 
				}
			} else {
				if ( strTokens[i].length() != 1 || !strTokens[i].toUpperCase().matches("[NWES]") ) {
					throw new Exception("Robot Explorer's orientation must be one of N/W/E/S");
				}
			}
		}
	    return true; 	
	}

	private boolean parseRobotInstruction(String inputStr) throws Exception {
		strTokens = inputStr.split("(?!^)"); 
	
		for(String s : strTokens) {
			if(s.length() != 1 || !s.toUpperCase().matches("[LRM]")) {
				throw new Exception("Robot Explorer's instruction must be a string of L, R, or M, without space in between");
			}
		}
		return true; 
	}
}
