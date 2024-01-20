import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StringStreamMain {

	public static void main(String[] args) {
		
		List<String> country = Arrays.asList("India","USA","UK");
		List<String> countries=Arrays.asList();
		country.stream().filter((a)-> StringStreamMain.startsWithTest(a,"U")).forEach(StringStreamMain::myFunction);
		
		country.stream().filter(a-> startsWithTest(a,"U")).forEach(s->System.out.println(s));
		
		String test = countries.stream().reduce("Empty",(str1,str2)->str1+" - "+str2);
		
		System.out.println(test);
	}
	
	
	public static boolean startsWithTest(String s,String startsWith) {
		return s.startsWith(startsWith);
	}
	
	public static void myFunction(String s) {
		System.out.println(s);
	}
	
	
	
}
