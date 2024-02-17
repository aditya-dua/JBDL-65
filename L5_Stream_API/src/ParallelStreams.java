import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

//java.util.concurrent.ForkJoinPool.common.parallelism=4

public class ParallelStreams {

	public static void main(String[] args) {
		List<Integer> number = Arrays.asList(2,5,6,7,9,11,10,9,13,4,21,5);
		ForkJoinPool pool = new ForkJoinPool();
	    //System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","4");

		System.out.println("getCustomParallelism=" +pool.getParallelism());
		//List<Integer> list = number.stream().parallel().collect(Collectors.toList());
		//System.out.println(list);
		number.stream().parallel().forEach(num->System.out.println(num+" ::Thread Name:: "+ Thread.currentThread().getName()));
	}
}
