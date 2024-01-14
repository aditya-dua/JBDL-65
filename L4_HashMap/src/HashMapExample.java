import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creates a Hashmap with cap of 16 and load factor if .75
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		
		hashMap.put(1, "Aditya");
		hashMap.put(2, "David");
		hashMap.put(3, "John");
		
		
		hashMap.put(3, "Jaun");
		hashMap.put(10, "Aditya");
		hashMap.put(11, "Aditya");
		
		System.out.println("Hashmap Size: "+hashMap.size());
		System.out.println("Hashmap Value at index 3: "+hashMap.get(3));
		
		hashMap.remove(2);
		
		// Entry 
		for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
			System.out.println("Key:"+entry.getKey()+"  Value: "+entry.getValue());
		}
		
		
	}

}
