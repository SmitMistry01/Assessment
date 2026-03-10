package in.stu.beans;
import java.util.*;


public class Subject {
	
	private List<String> l;

	public List<String> getL() {
		return l;
	}

	public void setL(List<String> l) {
		this.l = l;
	}

	@Override
	public String toString() {
		return "Subject [l=" + l + "]";
	}

	
}	
