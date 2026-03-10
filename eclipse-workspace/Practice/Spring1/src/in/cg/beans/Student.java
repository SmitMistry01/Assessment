package in.cg.beans;

public class Student {
	private int id;
	private String name, email;
	private Address a;

	// We can add constructor too by removing setters
	// and pass <constructor-arg value = "102"> instead of <property name value>
	//we use setters when fields can be changed but constructors are immutable
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setA(Address a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]"+ "\n" + a;
	}
}
