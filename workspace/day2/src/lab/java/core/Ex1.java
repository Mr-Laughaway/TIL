package lab.java.core;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.print("국 영 수 과 입력하세요=> ");
		int n1 = input.nextInt();
		int n2 = input.nextInt();
		int n3 = input.nextInt();
		int n4 = input.nextInt();
		input.close();
		int sum = n1 + n2 + n3 + n4;
		
		System.out.printf("sum %d\n", sum);
		System.out.printf("avg %d\n", sum / 4);
	}

}
