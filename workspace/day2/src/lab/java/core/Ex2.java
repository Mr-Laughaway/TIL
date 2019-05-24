package lab.java.core;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.print("두 정수를 입력하세요=> ");
		int n1 = input.nextInt();
		int n2 = input.nextInt();
		input.close();
		
		System.out.printf("%d / %d = %d...%d", n1, n2, n1 / n2, n1 % n2);

	}

}
