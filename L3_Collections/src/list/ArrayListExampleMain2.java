package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListExampleMain2 {
	
	public static void main(String[] args) {
		
		
		ArrayList<Integer> marksList = new ArrayList<Integer>();
		
		marksList.add(10);
		marksList.add(20);
		marksList.add(30);
		marksList.add(5);
		marksList.add(10);
		marksList.add(50);
		marksList.add(1,60);
		Integer i = 60;
		marksList.remove((Integer)60);
		
		for (Integer integer : marksList) {
			System.out.println(integer);
		}
	}

}
