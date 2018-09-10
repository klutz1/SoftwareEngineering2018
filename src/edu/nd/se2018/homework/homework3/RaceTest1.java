package edu.nd.se2018.homework.homework3;


import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RaceTest1 {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
	}

	@Before
	public void setUp() throws Exception {
		List<Horse> horseList = new ArrayList<Horse>();
		Horse h1 = new Horse("Blizzard", 25, new SlowStartStrategy());
		Horse h2 = new Horse("Snap", 10, new SteadyRunStrategy());
		Horse h3 = new Horse("Katie", 22, new EarlySprintStrategy());
		
		horseList.add(h1);
		horseList.add(h2);
		horseList.add(h3);
		
		Race myrace = new Race();
		assert(myrace.runRace(horseList) == "Blizzard");
		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After test");
	}

	@Test
	public void test() {
		System.out.println("Running test 1");
	}
	

}
