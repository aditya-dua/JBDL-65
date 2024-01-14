import java.util.Collections;
import java.util.HashSet;

public class HashSetExampleMain {

	public static void main(String[] args) {
		
		
		HashSet<Student> studenSet = new HashSet<Student>();
		Student s = new Student(1, "Aditya");
		Student s1 = new Student(1, "Aditya1");
		Student s2 = new Student(2, "John");
		Student s3 = new Student(3, "David");
		
		studenSet.add(s);
		studenSet.add(s1);
		studenSet.add(s2);
		studenSet.add(s3);
		
		System.out.println("Hashset Size:"+studenSet.size());
		
		for (Student student : studenSet) {
			System.out.println(student);
		}
		
		
	}
}
