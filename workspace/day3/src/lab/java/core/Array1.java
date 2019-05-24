package lab.java.core;

public class Array1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] score = new int[5]; //선언 및 할당
		System.out.println("score배열의 요소 갯수: " + score.length);
		
		for(int i = 0; i < score.length; i ++) {
			System.out.println("score[" + i + "] = " + score[i]);
		}
		System.out.println();
		
		//배열 선언, 생성, 명시적 초기화
		int[] score2 = new int[] {100, 300, 500, 700, 900, 901, 902};
		System.out.println("score2배열의 요소 갯수: " + score2.length);
		for(int num : score2) {
			System.out.println(num);
		}
		System.out.println();
		
		//배열 선언, 생성, 명시적 초기화
		int[] score3 = {100, 300, 500};
		System.out.println("score3배열의 요소 갯수: " + score3.length);
		for(int num : score3) {
			System.out.println(num);
		}
		
	}

}
