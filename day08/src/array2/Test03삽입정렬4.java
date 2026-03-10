package array2;

public class Test03삽입정렬4 {
	public static void main(String[] args) {
		//배열준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//삽입정렬
		// - 돌아갈 위치를 보관할 변수를 추가
		int position = 2; //0~4까지 변하면 삽입 정렬 끝!
		int backup = data[position];
		for(int i = position - 1; i >= 0; i--) {
			System.out.println(backup > data[i]);
			if(backup > data[i]) {//더 작은 데이터가 발견된다면
				break;
			}
			else {//비교 대상이 더 큰 경우(내가 앞으로 이동해야 하는 경우)
				data[i+1] = data[i]; //뒷칸에 앞의 데이터를 복사
				position--; // 위치를 왼쪽으로 한 칸 조정하겠다
			}
		}	
		System.out.println("position =" + position);
		data[position] = backup; //찾은 위치에 백업데이터를 넣어라!
		
		//출력
		for(int i =0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}	
	
}
