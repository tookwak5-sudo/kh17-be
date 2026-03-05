package condition3;

public class Test03학점계산기 {
	public static void main(String[] args) {
		// 입력
		int score = 70;
		
		// 처리
		int ten = score / 10;
		String grade;
		switch (ten) {
		case 9: case 100:
			grade = "A+";
			break;
		case 8:
			grade = "A";
			break;
		case 7:
			grade = "B";
			break;
		case 6:
			grade = "C";
			break;
		default:
			grade = "F";
			break;
		}

		// 출력
		System.out.println("등급 :" + grade);
		System.out.println("점수 :" + score);
	}
}
