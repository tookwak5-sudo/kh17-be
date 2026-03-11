package oop.basic1;

public class Test01객체지향프로그래밍 {
	public static void main(String[] args) {
		//프래그래밍 코드를 작성
		//목표: "메시지" 4개를 생성
		
		Message a = new Message(); //메세지 1개 생성하세요
		
		a.sender =  "호기심 천국";
		a.content = "지난번 올리신 카메라 팔렸나요?";
		a.time = "오후 1시 35분";
		a.count = 0;
		
		System.out.println(a);// a는 리모컨
		System.out.println(a.sender); //a가 바라보는 대상에 포함된 sender데이터
		System.out.println(a.content); //a가 바라보는 대상에 포함된 content데이터
		System.out.println(a.time); // a가 바라보는 대상에 포함된 time데이터
		System.out.println(a.count); // a가 바라보는 대상에 포함된 count데이터
		
		//메세지 하나 더 생성
		Message b = new Message();
	}
}
