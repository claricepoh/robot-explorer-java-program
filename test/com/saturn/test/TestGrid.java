package com.saturn.test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.saturn.Grid;

public class TestGrid {

	@Test
	public void generalTest() {
		Grid instance = Grid.getInstance(new String[] {"4", "5"});
		
		assertEquals(4, instance.getMaxCoordinateX());
		assertEquals(5, instance.getMaxCoordinateY()); 
		
	        instance.createRobotExplorer(new String[]{"1", "2", "N"});
		
		instance.instructRobotExplorer(new String[]{"R", "M", "M"});
		
		instance.printStatus();
	}

}
