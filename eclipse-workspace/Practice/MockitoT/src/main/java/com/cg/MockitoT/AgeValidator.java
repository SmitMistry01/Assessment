package com.cg.MockitoT;
import java.util.*;

public class AgeValidator {

	private DatabaseAge db;

	public AgeValidator(DatabaseAge db) {
		this.db = db;
	}

	void validateAge(int age) {
		if (age < 0)
			throw new IllegalArgumentException("Age cannot be negative");
		db.saveAge(age);
	}
}
