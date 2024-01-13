package list;

import java.util.ArrayList;
import java.util.Collections;

public class StudentArrayListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student s = new Student(1,"Aditya",80);
		Student s1 = new Student(2,"Aditya1",75);
		Student s2 = new Student(3,"Aditya2",85);
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(s);
		studentList.add(s2);
		studentList.add(s1);
		
		
		for (Student student : studentList) {
			System.out.println(student);
		}
		
		Collections.sort(studentList);
		
		for (Student student : studentList) {
			System.out.println(student);
		}
		
		Collections.sort(studentList,new RollStudentComprator());
		for (Student student : studentList) {
			System.out.println(student);
		}
		
	}

}
