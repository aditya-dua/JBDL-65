package list;

public class Student implements Comparable<Student>{

	int roll;
	String name;
	double percent;
	
	public Student(int roll, String name, double percent) {
		super();
		this.roll = roll;
		this.name = name;
		this.percent = percent;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", percent=" + percent + "]";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if(this.percent>o.percent) return 1;
		else if(this.percent<o.percent) return -1;
		return 0;
	}
	
	
	
}
