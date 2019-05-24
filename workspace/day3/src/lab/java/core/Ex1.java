package lab.java.core;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		float fBase, fHeight;
		char ch;
		while(true) {
			System.out.printf("Base = ");
			fBase = scanner.nextFloat();
			System.out.printf("Height = ");
			fHeight = scanner.nextFloat();
			System.out.printf("Triangle width = %.1f\n", fBase * fHeight / 2);
			
			System.out.printf("Continue? ");
			ch = scanner.next().charAt(0);
			if(ch != 'Y' && ch != 'y')
				break;
		}
		scanner.close();
	}

}
