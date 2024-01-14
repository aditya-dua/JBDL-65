import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args) {
		HashSet<String> countries= new HashSet<String>();
		
		countries.add("INDIA");
		countries.add("USA");
		countries.add("UK");
		countries.add("New Zealand");
		countries.add("Sri Lanka");
		countries.add("China");
		
		
		System.out.println("Set Size:"+countries.size());
		countries.add("INDIA");
		System.out.println("Set Size:"+countries.size());
		
		ArrayList<String> countryList = new ArrayList<String>();
		
		countryList.add("INDIA");
		countryList.add("USA");
		countryList.add("UK");
		countryList.add("New Zealand");
		countryList.add("Sri Lanka");
		countryList.add("China");
		countryList.add("INDIA");
		
		HashSet<String> newSet= new HashSet<String>(countryList);
		
		
		
		
	}
}
