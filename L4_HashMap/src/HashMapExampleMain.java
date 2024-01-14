import java.util.HashMap;
import java.util.Map;

public class HashMapExampleMain {

	public static void main(String[] args) {
		
		
		HashMap<Student, Integer> hm = new HashMap<Student, Integer>();
		
		Student s = new Student(1, "Aditya");
		Student s1 = new Student(1, "Aditya");
		Student s2 = new Student(2, "John");
		Student s3 = new Student(3, "David");
		
		
		hm.put(s, 100);
		hm.put(s1, 95);
		hm.put(s2, 80);
		hm.put(s3, 50);
		//hm.put(s, 99);
		
		System.out.println(s.equals(s3));
		
		System.out.println("HashMap Size:"+hm.size());
		
		
		
		
	}
}
