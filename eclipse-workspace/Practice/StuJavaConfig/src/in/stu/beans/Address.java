package in.stu.beans;

public class Address {
	private int no;
	private String street;
	private String state;
	
	
	public Address(int no, String street, String state) {
		super();
		this.no = no;
		this.street = street;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [no=" + no + ", street=" + street + ", state=" + state + "]";
	}
	
	
}