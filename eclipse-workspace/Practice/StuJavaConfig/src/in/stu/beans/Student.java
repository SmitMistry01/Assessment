package in.stu.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
	private int id;
	private String name, email;
	
	@Autowired
	private Address a;
	@Autowired
	private Subject s;
	
	public Student(int id, String name, String email, in.stu.beans.Address a, Subject s) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.a = a;
		this.s=s;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]" + "\n" + a + "\n" +s;
	}
}