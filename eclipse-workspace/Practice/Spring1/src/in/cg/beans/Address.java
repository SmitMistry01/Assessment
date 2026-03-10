package in.cg.beans;

public class Address {
	private int no;
	private String street;
	private String state;
	
	public void setNo(int no) {
		this.no = no;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Address [no=" + no + ", street=" + street + ", state=" + state + "]";
	}
	
	
}
