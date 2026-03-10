package in.stu.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import in.stu.beans.*;
import java.util.*;

@Configuration
public class JavaConfig{
	
	@Bean("address")
	public Address address()
	{
		Address a = new Address(5816,"dafod","maha");
		return a;
	}

	@Bean("subject")
		public Subject subject() {
			Subject s = new Subject();
			ArrayList<String> l = new ArrayList<>();
			l.add("phy");
			l.add("chem");
			l.add("math");
			
			s.setL(l);
			return s;
		}
	
	@Bean("student1")
	public Student student(Address a,Subject s)
	{
		Student s1 = new Student(101,"Smit","smit@gmail.com",a,s);
		return s1;
	}
}