package lab.java.core;

public class CalcTest {

	public static void main(String[] args) {

		Calc calc = new Calc();
		
		System.out.printf("10 + 5 = %d\n", calc.plus(10, 5));
		System.out.printf("10 - 5 = %d\n", calc.minus(10, 5));
		System.out.printf("10 * 5 = %d\n", calc.multiply(10, 5));
		System.out.printf("10 / 5 = %d\n", calc.div(10, 5));
		System.out.printf("10 %% 5 = %d\n", calc.mod(10, 5));
	}

}
