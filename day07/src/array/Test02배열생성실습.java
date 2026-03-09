package array;

public class Test02배열생성실습 {
	public static void main(String[] args) {
		//다음의 데이터들을 배열에 저장하고 출력하세용
		// 키 데이터 : 173, 168, 181, 176, 170
		// 시력 데이터 ; [1.2, 0.4, 0.1, 1.0, 0.8, 0.2, 1.5]
		// 혈액형 데이터 : [A, B, B, AB, O, A, O, A]
		// 요일별 걸음수 : [8420, 12500, 3210, 7890]
		
		int[] heightList = new int[] {173, 168, 181, 176, 170}; //5개 이름을 지을 때 복수형을 뜻하는 이름을 짓도록 하기
		float[] sightList = new float[] {1.2f, 0.4f, 0.1f, 1.0f, 0.8f, 0.2f, 1.5f}; // 7개
		String[] bloodTypes = new String[] {"A", "B", "B", "AB", "O", "A", "O", "A"}; //8개
		int[] steps = new int[] {8420, 12500, 3210, 7890}; // 4개
		
		for(int i = 0; i < heightList.length; i++) {
			System.out.println("키 : " + heightList[i] + "cm");
		}
		System.out.println("---------------");
		
		for(int i = 0; i < sightList.length; i++) {
			System.out.println("시력 : " + sightList[i]);
		}
		System.out.println("---------------");
		
		for(int i = 0; i < bloodTypes.length; i++) {
			System.out.println("혈액형 : " + bloodTypes[i] + "형");
		}
		System.out.println("---------------");
		
		for(int i = 0; i < steps.length; i++) {
			System.out.println("걸음 수 : " + steps[i] + "걸음");
		}
	}
}
