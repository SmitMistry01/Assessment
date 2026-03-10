package in.cg.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.cg.beans.Student;

public class MainMethod {

	public static void main(String[] args) {

		String config_loc = "/in/cg/resource/applicationContext.xml";

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(config_loc);

		Student stu1 = (Student) context.getBean("stu_1");
		System.out.println(stu1);

	}
}