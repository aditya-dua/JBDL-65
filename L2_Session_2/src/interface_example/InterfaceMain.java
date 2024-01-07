package interface_example;

public class InterfaceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Square sq = new Square();
		sq.side=10;
		sq.area();
		sq.display();
		sq.test();
		
		Circle c = new Circle();
		c.radius=10;
		c.area();
		c.test();
		c.display();
	}

}
