package lab.java.core;

import java.util.Scanner;

public class Switch4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Number? ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		
		switch(n) {
		case 1:
			System.out.println("Scissors");
			break;
		case 2:
			System.out.println("Rock");
			break;
		case 3:
			System.out.println("Paper");
			break;
		default:
			System.out.println("I don't know.");
		}
		
	}

}
