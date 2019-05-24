package lab.java.core;

import java.util.Scanner;

public class IfEx3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("년도를 입력하세요 => ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();
		
		System.out.println("방법1");
		if( n % 4 == 0) {
			if( n % 400 == 0) {
				System.out.println("윤년입니다.");
			}else if (n % 100 == 0) {
				System.out.println("평년입니다.");
			}else {
				System.out.println("윤년입니다.");
			}
		}else {
			System.out.println("평년입니다.");
		}
		
		System.out.println("\n방법2"); 
		
		
	}
}
