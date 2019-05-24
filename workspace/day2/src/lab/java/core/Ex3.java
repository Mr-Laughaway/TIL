package lab.java.core;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		// 직사각형의 가로와 세로의 길이를 정수형 값으로 입력받은 후 가로의 길이는 5 증가시키고 
		//세로의 길이는 2배하여 저장한 후 가로의 길이 세로의 길이 넓이를 차례로 출력하는 프로그램을 작성하시오.

		Scanner input = new Scanner(System.in);
		System.out.print("직사각형의 가로와 세로를 입력하세요 => ");
		int n1 = input.nextInt() + 5;
		int n2 = input.nextInt() * 2;
		input.close();
		System.out.printf("width = %d\n", n1);
		System.out.printf("length = %d\n", n2);
		System.out.printf("area = %d\n", n1 * n2);
	}

}
