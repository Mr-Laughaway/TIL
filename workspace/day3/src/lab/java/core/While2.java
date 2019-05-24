package lab.java.core;

import java.util.Scanner;

public class While2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner scanner = new Scanner(System.in);
		int n;
		int count = 0;
		while(true) {
			n = scanner.nextInt();
			if( n == 0)
				break;
						
			if( n%3 != 0 && n%5 != 0 ) 
				count++;
		}
		scanner.close();
		System.out.println(count);
	}

}
