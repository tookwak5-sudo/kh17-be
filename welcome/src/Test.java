import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String begin = "2025-05-03";
		String end = "2026-05-03";
		
		LocalDate a = LocalDate.parse(begin);
		LocalDate b = LocalDate.parse(end);
		
		Period p = Period.between(a, b);
		System.out.println(p.getYears());
	}
}
