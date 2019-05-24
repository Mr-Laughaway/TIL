package lab.java.core;

import java.util.Scanner;

public class Switch3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("A B C 중 한 문자만 입력하세요 => ");
		Scanner input = new Scanner(System.in);
		String st = input.next();
		input.close();
		char ch = st.charAt(0);
		
		switch(ch) {
		case 'A':
		case 'a':
			System.out.println("arrow");
			break;
		case 'B':
		case 'b':
			System.out.println("billion");
			break;
		case 'C':
		case 'c':
			System.out.println("camera");
			break;
		default:
			System.out.println("이 문자는 아직 준비되지 않았습니다.");
		}
		
	}

}
