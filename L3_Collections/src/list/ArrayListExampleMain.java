package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListExampleMain {
	
	public static void main(String[] args) {
		
		
		ArrayList<String> nameList = new ArrayList<String>();
		
		System.out.println("Size Before:"+nameList.size());
	
		nameList.add("Aditya");
		nameList.add("Rohan");
		nameList.add("David");
		nameList.add("John");
		nameList.add("David");
		
		System.out.println("Size After:"+nameList.size());
		
		nameList.remove(0);
		nameList.remove("David");
		
		System.out.println("Size After Remove:"+nameList.size());
		
		System.out.println("Iterate using For Each");
		
		for (String str : nameList) {
			System.out.println(str);
		}
		
		Iterator<String> nameListIterator = nameList.iterator();
		System.out.println("Iterate using Iterator");
		
		while (nameListIterator.hasNext()) {
			String string = (String) nameListIterator.next();
			System.out.println(string);
		}
		
		for (Iterator iterator = nameList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			
		}
		
		for (int i = 0; i < nameList.size(); i++) {
			System.out.println(nameList.get(i));
			
		}
		
		Collections.sort(nameList,Collections.reverseOrder());
		
		for (int i = 0; i < nameList.size(); i++) {
			System.out.println(nameList.get(i));
			
		}
	}

}
