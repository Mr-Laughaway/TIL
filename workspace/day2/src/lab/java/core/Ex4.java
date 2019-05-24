package lab.java.core;

import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.println("3 ≤ N ≤ 5000");
		int n = input.nextInt();
		input.close();
		
		
		
//		System.out.println(
//				(n%5)%3 != 0  &&  n%3 != 0 ? -1 : n/5 + n%5/3
//		);
		
//		boolean check1 = n%5%3 == 0;
//		boolean check2 = n%3 == 0;
//		System.out.println(
//			check1 || check2 ? (check1 ? n/5 + n%5/3 : n/3) : -1
//		);
		// 17 같은 경우 처리가 안 됨 (for  문으로 5를 빼고 5나 3의 배수인 인 경우 까지 빼고, 마지막에 3으로 나눔)
		
		if( 
				( (n-5)%5 == 0 || (n-5)%3 == 0 )
				|| ( (n-3)%5 == 0 || (n-3)%3 == 0  ) 
		) {
			
		}else {
			System.out.println(-1);
		}
	
	}

}
