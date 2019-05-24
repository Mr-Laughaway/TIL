package lab.java.core;

import java.util.Scanner;

public class Switch2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("점수를 입력하세요 => ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();
		
		switch( n/10 ) {
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("F");
		}
	}
}
