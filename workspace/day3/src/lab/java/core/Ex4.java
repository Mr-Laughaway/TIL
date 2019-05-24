package lab.java.core;

import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("행과 열의 수를 입력하세요 => ");
		Scanner scanner = new Scanner(System.in);
		int r, c;
		r = scanner.nextInt();
		c = scanner.nextInt();
		scanner.close();
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				System.out.printf("%-2d", (i+1)*(j+1));
			}
			System.out.println();
		}
	}

}
