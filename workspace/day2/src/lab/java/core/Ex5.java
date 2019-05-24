package lab.java.core;

import java.util.Scanner;

public class Ex5 {

	public static void main(String[] args) {
		// 민수와 기영이의 키와 몸무게를 입력받아 민수가 키도 크고 몸무게도 크면 true 
		//그렇지 않으면 false을 출력하는 프로그램을 작성하시오.
		
		Scanner input = new Scanner(System.in);
		System.out.print("민수의 키 몸무게=> ");
		int a1 = input.nextInt();
		int a2 = input.nextInt();
		System.out.print("기영이의 키 몸무게=> ");
		int b1 = input.nextInt();
		int b2 = input.nextInt();
		
		System.out.println( a1>b1 && a2>b2 ? true : false);
	}

}
