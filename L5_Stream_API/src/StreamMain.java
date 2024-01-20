import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> number = Arrays.asList(2,5,6,7,9,11,10,9,13,4,21,5);
		
		System.out.println(number.stream().count());
		
		List<Integer> square = number.stream().map(x->x*x).collect(Collectors.toList());
		
		System.out.println(square);
		
		List<Integer> disNumber= number.stream().distinct().collect(Collectors.toList());
		
		List<Integer> disSquareNumber= number.stream().distinct().map(x->x*x).collect(Collectors.toList());
		
		
		System.out.println(number);
		System.out.println(disNumber);
		System.out.println(disSquareNumber);
		
		List<Integer> evenNumberSquaredSorted = evenSorted(number);
		System.out.println(evenNumberSquaredSorted);
		
		int tot = 0;
		for (Integer integer : number) {
			tot=tot+integer;
		}
		int sum = number.stream().reduce(0, (total,i)->total+i);
		
		System.out.println(sum);
	}
	
	public static List<Integer> evenSorted(List<Integer> list){
		return list.stream().filter(n->n%2==0).map(x->x*x).sorted().collect(Collectors.toList());
	}

}

/**
 * Use Cases
 * Filtering, PreProcessing, Conversion, Reduction,Grouping, Finding/Filtering, SOrting, Counting, Limiting
 **/
