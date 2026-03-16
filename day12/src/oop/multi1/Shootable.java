package oop.multi1;

//부가 속성으로 사용할 클래스(다중상속용 클래스)
// - 다중상속에서 문제가되는 요소가 모두 제거된 크래스
// - 사실상 추상 메소드 외에는 사용이 불가능하다.
public interface Shootable { // 촬영가능한
		/*public abstract(생략가능) */ void shoot();	 // 촬영가능
}
