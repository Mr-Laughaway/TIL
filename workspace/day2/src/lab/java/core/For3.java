package lab.java.core;

public class For3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//구구단
		for(int i = 1; i <= 9; i++) {
			for(int j = 2; j <= 9; j++) {
				System.out.printf("%dX%d=%2d\t", j, i, i*j);
			}
			System.out.println();
		}

	}

}
