package oop.inherit6;
//상속을 위한 클래스 : 특별한 용도의 클래스
//- 실제로 존재하지 않는 개념적인 내용을 담는 클래스 
//- 무슨 기능이 있어야하는지는 알겠는데 어떻게 하는지는 말할 수 없다.
// - 애매한 경우를 위해서 추상(abstract)이라는 기능을 씀
//추상 클래스 목록에서 'A'라고 구분이 뜸
public  abstract class Phone { //추상 클레스 : 일반클래스에 추상메소드까지 가질 수 있는 상속 관계의 상위 클래스
	public abstract void on(); // 추상 메소드 // 있어야 하지만 설명할 수 없는 내용을 형식만 만들어둘 때 사용
	public abstract void off(); // 추상메소드
	public abstract void call();// 추상 메소드
}
