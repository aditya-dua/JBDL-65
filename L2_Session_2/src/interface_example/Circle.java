package interface_example;

public class Circle extends Shape implements Area{

	float radius;
	@Override
	public void area() {
		// TODO Auto-generated method stub
		
		this.area = (float) (3.14*radius*radius);
	}

}
