package calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalTest {
	
	//Test case : check a specific piece of code.
	//In JUnit, a test case is typically a method within a class.
	//It scans classes -> find methods @Test -> create obj -> reports pass or fail
	Cal c = new Cal();
	
	@Test //Test method
	void testAdd() {
		int res = c.mul(3, 2);
		//Assertions : verify that the expected results match the actual results
		//It help detect logical errors during development to verify conditions
		//If fails (JVM) throws an AssertionError
		assertEquals(6,res);	
		
	}
	
	@Test
	void checkAdult() {
		assertTrue(c.isAdult(20));
	}
	
}