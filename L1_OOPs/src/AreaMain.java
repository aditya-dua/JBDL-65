
/**
 * Overloading the area method to have the same name but on the basis of parameter
 * the compiler decides which one is to be called.
 * 
 */
public class AreaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Area a = new Area();
		
		//Square
		a.area(10);
		a.area(4.5f);
		a.area(12, 10);
	}

}
