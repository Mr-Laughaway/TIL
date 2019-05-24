package lab.java.core;

import java.util.Scanner;

public class Switch1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("정수를 입력하세요 => ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();
		
		if(n % 2 == 0) {
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}
		
	}

}
