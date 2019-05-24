package lab.java.core;

import java.util.Scanner;

public class IfEx2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("점수를 입력하세요 => ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();
		
		if( 90 <= n ) {
			System.out.println("A");
		}else if( 80 <= n ) {
			System.out.println("B");
		}else if( 70 <= n ) {
			System.out.println("C");
		}else if( 60 <= n ) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
		
	}
}
