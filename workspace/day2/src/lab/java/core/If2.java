package lab.java.core;

import java.util.Scanner;

public class If2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("한 문자만 입력하세요 => ");
		Scanner input = new Scanner(System.in);
		String st = input.next();
		input.close();
		char ch = st.charAt(0);
		if( 47 < ch && ch < 58 ) {
			System.out.println(st + "(은)는 숫자입니다.");
		}else if( 64 < ch && ch < 91){
			System.out.println(st + "(은)는 영문대문자입니다.");
		}else if( 96 < ch && ch < 123){
			System.out.println(st + "(은)는 소문대문자입니다.");
		}
		

	}

}
