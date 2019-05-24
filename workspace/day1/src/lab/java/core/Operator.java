package lab.java.core;

public class Operator {

	public static void main(String[] args) {
		// 단항연산자: +, -(sign 연삼자), (), ++, --, !(not), ~(1의보수)
		int num = -3;
		System.out.println(-num);
		
		int a = 5, b = 7;
		System.out.println(++a + ++b);
		System.out.println("a=" + a + ", b=" + b); //선위 연산자
		//다른 연산자보다 먼저 수행
		System.out.println(a++ + b++);
		System.out.println("a=" + a + ", b=" + b); //후위 연산자
		//후위 연산자는 모든 다른 연산후에 다음 코드로 넘어가기 직전에 ++연산 수행
		
//		System.out.println(!num);
		System.out.println(!false);

		System.out.println(~num);
	}

}
