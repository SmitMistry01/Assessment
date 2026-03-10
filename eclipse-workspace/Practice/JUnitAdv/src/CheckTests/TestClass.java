package CheckTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestClass {

	@Test
	void checkPalindromeTest() {
		PalindromeCheck p = new PalindromeCheck();
		assertTrue(p.checkPalindrome("naman"));
	}
	
	@Test
	void checkFactorial() {
		FactorialCheck f = new FactorialCheck();
		assertEquals(24,f.fact(4));
		
	}
}
