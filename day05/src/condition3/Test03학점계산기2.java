package condition3;

public class Test03학점계산기2 {
	public static void main(String[] args) {
		//입력
		String grade = "A+";
		int score = 70;
		
		//처리
		if(score >= 90 && score <=100) {
			grade = "A+";
		}
		else if(score >= 80) {
			grade = "A";
		}
		else if(score >= 70) {
			grade = "B";
		}
		else if(score >= 60) {
			grade = "C";
		}
		else {
			grade = "F";
		}
		
		switch(grade) {
		case "A+":		
		break;
		case "A":
			break;
		case "B":
			break;
		case "C":
			break;
		default:
		break;
		}
		//출력
		
		System.out.println("등급 :" + grade);
		System.out.println("점수 :" + score);
	}
}
