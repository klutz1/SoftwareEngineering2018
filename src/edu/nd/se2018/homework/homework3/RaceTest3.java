package edu.nd.se2018.homework.homework3;

//ABOUT:
//This test checks to make sure that the horse's name spot is not empty;
//each horse must have a name

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RaceTest3 {
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
		Horse h2 = new Horse("Snap", 30, new SteadyRunStrategy());
		Horse h3 = new Horse("", 30, new EarlySprintStrategy());
		Horse h4 = new Horse("Candace", 23, new EarlySprintStrategy());
		
		
		//h1.setStrategy(new EarlySprintStrategy());
		horseList.add(h1);
		horseList.add(h2);
		horseList.add(h3);
		
		Race myrace = new Race();
		assert(myrace.start(horseList) == "error");
		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After test");
	}

	@Test
	public void test() {
		System.out.println("Running test 3");
	}
	
}
