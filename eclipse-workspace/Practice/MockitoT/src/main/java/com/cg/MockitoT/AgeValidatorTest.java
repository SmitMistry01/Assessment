package com.cg.MockitoT;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import org.hibernate.boot.model.relational.Database;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) //initialize mockito 
//without this @Mock will be null we'll get NullPointerException

public class AgeValidatorTest{
	
	@Mock
	Database db;//mock object of Database.
	//Creates proxy object -> Overrides all methods -> No real logic runs
	
	@InjectMocks
	AgeValidator validator; //create real object and add mock db
	
	@Test
	void testInvalidAge()
	{
//		assertThrows(IllegalArgumentException.class, () -> 
//				validator.validateAge(-1));
	    validator.validateAge(25);
	    verify(db).saveAge(25);
	}
	
}
