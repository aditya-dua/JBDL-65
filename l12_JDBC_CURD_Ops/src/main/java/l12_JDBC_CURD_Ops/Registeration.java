package l12_JDBC_CURD_Ops;

public class Registeration {

	private int id;
	private String first;
	private String last;
	private int age;
	public Registeration(int id, String first, String last, int age) {
		super();
		this.id = id;
		this.first = first;
		this.last = last;
		this.age = age;
	}
	public Registeration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
