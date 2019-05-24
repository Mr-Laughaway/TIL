package lab.java.core;

import java.util.Scanner;

public class IfEx1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("정수를 입력하세요 => ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();
		
		switch(n % 2) {
		case 0:
			System.out.println("짝수");
			break;
		case 1:
			System.out.println("홀수");
		}
		
	}

}
