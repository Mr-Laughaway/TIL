package lab.java.core;

import java.util.Scanner;

public class JuminCheck {

	public static void main(String[] args) {
		System.out.print("주민번호 입력(예:123456-891234): ");
		Scanner input = new Scanner(System.in);
		String juminStr = input.next();
		input.close();
		int[] jumin = new int[13];
		int[] weight = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
		
		int index = 0;
		for(int i = 0; i < juminStr.length(); i++) {
			char ch = juminStr.charAt(i);
			if(ch != '-') {
				jumin[index] = ch - '0';
				index++;
			}
		}
		
		//Show input
		for(int n : jumin) {
			System.out.printf("%d ", n);
		}
		System.out.println();
		
		//Check Digit
		int sum = 0;
		for(int i = 0; i < weight.length; i++) {
			sum += jumin[i] * weight[i];
		}
		int digit = 11 - (sum % 11);
		if(digit > 9) {
			digit %= 10;
		}
		System.out.println("Check Digit: " + digit);
		
		//Validation
		if(jumin[12] == digit) {
			System.out.println("CORRECT");
		}
		else {
			System.out.println("INCORRECT");
		}
		
		//성별
		if(jumin[6] %2 == 1) 
			System.out.println("남");
		else 
			System.out.println("여");
		
		//출생년대
		if(jumin[6] < 3)
			System.out.println("1900년대 출생자");
		else
			System.out.println("2000년대 출생자");
		
	}

}
