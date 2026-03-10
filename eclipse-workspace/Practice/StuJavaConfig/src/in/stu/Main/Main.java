package in.stu.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.stu.beans.Student;
import in.stu.resource.JavaConfig;

public class Main {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

		Student stu1 = context.getBean(Student.class);
		System.out.println(stu1);

	}
}
