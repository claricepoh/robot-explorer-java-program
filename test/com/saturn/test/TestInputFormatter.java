package com.saturn.test;

import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;


import com.saturn.InputFormatter;
import com.saturn.InputFormatter.State;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestInputFormatter {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Test
        public void _1_invalidGridSize1() throws Exception {
		
		InputFormatter instance = InputFormatter.getInputFormatter();
		
		assertEquals(State.GRID_SIZE_INITIALIZATION, instance.getState());
	
		exception.expect(Exception.class);
		instance.parseString("5 N");	
	}
	
	@Test
	public void _2_validGridSize2() throws Exception {
		
		InputFormatter instance = InputFormatter.getInputFormatter();
		
		assertEquals(State.GRID_SIZE_INITIALIZATION, instance.getState());
				
		instance.parseString("   5 5");
		instance.parseString("5 5");
		instance.parseString("5 5    ");
		instance.parseString("5      5");
		
		assertArrayEquals(new String[]{"5", "5"}, instance.getStrTokens());
	}
	
	@Test
	public void _3_invalidRobotPosition() throws Exception {
		
		InputFormatter instance = InputFormatter.getInputFormatter();
		
		assertEquals(State.GRID_SIZE_INITIALIZATION, instance.getState());
				
		instance.parseString("5 5");
		
		instance.updateState();
		assertEquals(State.ROBOT_EXPLORER_POSITION_INITIALIZATION, instance.getState());
		
		exception.expect(Exception.class);
		instance.parseString(" 4 5 C");
	}
	
	@Test
	public void _4_validRobotPosition() throws Exception {
		
		InputFormatter instance = InputFormatter.getInputFormatter();
		
		assertEquals(State.ROBOT_EXPLORER_POSITION_INITIALIZATION, instance.getState());
		
		instance.parseString(" 4 5  N");
		assertArrayEquals(new String[]{"4", "5", "N"}, instance.getStrTokens());
	}
	
	@Test
	public void _5_invalidRobotMovement() throws Exception {
		
		InputFormatter instance = InputFormatter.getInputFormatter();
		
		assertEquals(State.ROBOT_EXPLORER_POSITION_INITIALIZATION, instance.getState());
		
		instance.parseString(" 4 5 N");
		instance.updateState();
		assertEquals(State.ROBOT_EXPLORER_INSTRUCTION_INITIALIZATION, instance.getState());
		
		exception.expect(Exception.class);
		instance.parseString("LMMG");
	}
	
	@Test
	public void _6_validRobotMovement() throws Exception {
		
		InputFormatter instance = InputFormatter.getInputFormatter();
		
		assertEquals(State.ROBOT_EXPLORER_INSTRUCTION_INITIALIZATION, instance.getState());
		
		instance.parseString("LMMLMRMM");
		assertArrayEquals(new String[]{"L", "M", "M", "L", "M", "R", "M", "M"}, instance.getStrTokens());
	}

}
