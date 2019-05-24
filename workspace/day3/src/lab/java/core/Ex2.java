package lab.java.core;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		int nOdd = 0;
		int nEven = 0;
		int num;
		
		while( (num = scanner.nextInt()) != 0 ) {
			if(num%2 == 1) 
				nOdd++;
			else
				nEven++;
		}
		scanner.close();
		
		System.out.println("odd : " + nOdd);
		System.out.println("even : " + nEven);

	}

}
