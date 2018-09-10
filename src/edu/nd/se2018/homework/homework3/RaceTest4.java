package edu.nd.se2018.homework.homework3;

//ABOUT:
//This tests to make sure that there is always more than one horse in a race
//If there is less than 2 horses, return an error.

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RaceTest4 {
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
		Horse h1 = new Horse("Crackle", 30, new SlowStartStrategy());
		
		
		horseList.add(h1);
		
		Race myrace = new Race();
		assert(myrace.start(horseList) == "error");
		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After test");
	}

	@Test
	public void test() {
		System.out.println("Running test 4");
	}
	
}