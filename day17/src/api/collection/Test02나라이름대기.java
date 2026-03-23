package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test02나라이름대기 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
			List<String> country = new ArrayList<>();
			
			String name = null;
			
			while(true) {
				System.out.print("나라 : ");
				name = sc.nextLine();
				
				boolean check = country.contains(name);
				if(check) {
					break;
				}
				else {
					country.add(name);
				}
			}
			System.out.print("[GameOver]");
			System.out.println("★".repeat(10));
			System.out.println("나라 수" + country.size());
			System.out.println("나라 목록" + country.toString());
		
	}
}
