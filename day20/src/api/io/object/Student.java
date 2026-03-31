package api.io.object;

import java.io.Serializable;

//만약 입출력의 대상이 될 수 있게 하려면 마킹인터페이스 처리 필요
//-버전 정보를 추가해서 일관성을 부여하고 관리할 수 있도록 처리 가능 (serialVersionUID)
//UID ==> 주민번호처럼 고유한번호라 생각
//- 이 중에서도 출력을 원치 않는 항목이 있을 수 있는데.. 필드 앞에 transient 키워드를 붙이면 자동 제외됨
public class Student implements Serializable {
	private static final long serialVersionUID = 1L; // 학생 ver.1
	private String name; //이름
	private transient int level; //학년 (쓰긴 쓸건데 저장할 필요는 없다)
	private int score; //점수
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Student(String name, int level, int score) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", level=" + level + ", score=" + score + "]";
	}
	
	
	
	
}
