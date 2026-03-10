package AdvQuest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

	@Test
	void validNameValidTest1() {
		Validator emp = new Validator();
		emp.setName("Sam Johns");
		assertTrue(emp.validateName(emp.getName()));
	}
	
	@Test
	void validNameInvalidTest1() {
		Validator emp = new Validator();
		emp.setName("Jonathan");
		assertTrue(emp.validateName(emp.getName()));
	}
	
	@Test
	void validAgeValidTest1() {
		Validator emp = new Validator();
		emp.setAge(18);
		assertTrue(emp.validateAge(emp.getAge()));
	}
	
	@Test
	void validAgeInvalidTest1() {
		Validator emp = new Validator();
		emp.setAge(17);
		assertTrue(emp.validateAge(emp.getAge()));
	}
	
	@Test
	void validateInvalidNameTest() {
		Validator emp = new Validator();
		emp.setName("Maria");
		emp.setSal(2000);
		emp.setAge(25);
		
		assertThrows(InvalidNameException.class, () -> {
	        emp.validate(emp);
	    });
	}
	
	@Test
	void validateInvalidAgeTest() {
		Validator emp = new Validator();
		emp.setName("Maria Francis");
		emp.setSal(2000);
		emp.setAge(17);
		
		assertThrows(InvalidAgeException.class, () -> {
	        emp.validate(emp);
	    });
	}
	
	@Test
	void checkAnnualSal() {
		
		Validator emp = new Validator();
		emp.setName("Maria Francis");
		emp.setSal(2000);
		emp.setAge(25);
		
		assertDoesNotThrow(() -> {
	        emp.validate(emp);  
	           
	    });
		
		double result = emp.calAnnualSal();
		assertEquals(25440,result);
	}
	
}