package AdvQuest;

public class Validator extends Employee{
	
	public boolean validateName(String name) {
		if(name.length()>8 && (name != null && !name.trim().isEmpty())) return true;
		else return false;
	}
	
	public boolean validateAge(int age) {
		if(age>=18 && age<=60) return true;
		else return false;
	}
	
	public void validate(Employee emp) throws InvalidNameException,InvalidAgeException {
		if(!validateName(emp.getName())) throw new InvalidNameException("Name must be 8 characters long and must not be empty");
		if(!validateAge(emp.getAge())) throw new InvalidAgeException("Age must be 18 to 60 inclusive");
	}
	
}