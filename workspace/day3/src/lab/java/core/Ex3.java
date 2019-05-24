package lab.java.core;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		int n1, n2, dummy;
		System.out.print("두 개의 정수를 입력하세요 => ");
		n1 = scanner.nextInt();
		n2 = scanner.nextInt();
		scanner.close();
		
		if( n1 > n2) {
			dummy = n1;
			n1 = n2;
			n2 = dummy;
		}
		
		for(int i = n1; i <= n2; i++) {
			System.out.printf("%d ", i);
		}
		

	}

}
