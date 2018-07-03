package com.saturn.test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.saturn.RobotExplorer;
import com.saturn.RobotExplorer.Orientation;
import com.saturn.Grid;

public class TestRobotExplorer {

	@Test
	public void  generalTest() {
		Grid grid = Grid.getInstance(new String[]{"5", "5"});
		
		RobotExplorer robot = new RobotExplorer(grid, new String[]{"1", "2", "N"});
		
		assertEquals(1, robot.getXCoordinate());
		assertEquals(2, robot.getYCoordinate());
		assertEquals(Orientation.NORTH, robot.getOrientation());
		
		robot.instruct('L');
		assertEquals(Orientation.WEST, robot.getOrientation());
		robot.instruct('L');
		assertEquals(Orientation.SOUTH, robot.getOrientation());
		robot.instruct('L');
		assertEquals(Orientation.EAST, robot.getOrientation());
		robot.instruct('L');
		assertEquals(Orientation.NORTH, robot.getOrientation());
		
		robot.instruct('R');
		assertEquals(Orientation.EAST, robot.getOrientation());
		robot.instruct('R');
		assertEquals(Orientation.SOUTH, robot.getOrientation());
		robot.instruct('R');
		assertEquals(Orientation.WEST, robot.getOrientation());
		robot.instruct('R');
		assertEquals(Orientation.NORTH, robot.getOrientation());
		
		boolean status = robot.instruct('M');
		assertTrue(status);
		assertEquals(3, robot.getYCoordinate());
		
		status = robot.instruct('M');
		assertTrue(status);
		assertEquals(4, robot.getYCoordinate());
		
		status = robot.instruct('M');
		assertTrue(status);
		assertEquals(5, robot.getYCoordinate());
		
		// Can't move further from the landing area
		status = robot.instruct('M');
		assertFalse(status);
		assertEquals(5, robot.getYCoordinate());
		
		robot.printFinalPosition();
	}

}
