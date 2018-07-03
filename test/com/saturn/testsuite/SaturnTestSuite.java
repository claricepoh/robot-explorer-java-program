package com.saturn.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.saturn.test.*;

@RunWith(Suite.class)
@SuiteClasses({
	TestGrid.class,
	TestRobotExplorer.class,
	TestInputFormatter.class
})

public class SaturnTestSuite {
}
