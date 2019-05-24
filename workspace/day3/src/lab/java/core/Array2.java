package lab.java.core;

public class Array2 {

	public static void main(String[] args) {

		//System.out.println(args[0]);
		//System.out.println(args[1]);
		int num = Integer.parseInt(args[0]);
		if(num%2 == 0) {
			System.out.println(args[0] + "는 짝수");
		}
		else {
			System.out.println(args[0] + "는 홀수");
		}

	}

}
