package interface_example;

public class Square extends Shape implements Area,Perimeter{

	int side;
	@Override
	public void area() {
		// TODO Auto-generated method stub
		this.area = side*side;
	}
	
	public void test() {
		System.out.println("Test Square Class Called");
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		//super.display();
		Area.displayArea();
		System.out.println("The Area of Square is:"+area);
	}

	@Override
	public void peri() {
		// TODO Auto-generated method stub
		
	}

}
