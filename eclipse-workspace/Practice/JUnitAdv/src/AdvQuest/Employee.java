package AdvQuest;

public class Employee {

	String name;
	double sal;
	int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public double calAnnualSal() {
		if(age>=18 && age<=50) {
			sal += 0.06*sal;
		}
		else if(age >50 && age<=60) {
			sal+=0.07*sal;
		}
		return sal*12;
	}
}
