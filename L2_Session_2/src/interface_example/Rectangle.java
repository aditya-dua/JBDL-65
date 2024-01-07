package interface_example;

public class Rectangle extends Shape implements Area{

	int len,wid;
	@Override
	public void area() {
		// TODO Auto-generated method stub
		this.area = len*wid;
	}
	

}
