package api.object;

public class Student /* extends Object*/ {
	//public Student();
	
	private String name;
	private int score;
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
}
