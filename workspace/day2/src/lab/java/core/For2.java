package lab.java.core;

public class For2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//이중 for문
		for(int r = 1; r < 4; r++) { //행갯수
			for(int c = 1; c < 4; c++) { //열갯수
				System.out.print( "(" + r + "," + c + ")" + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int r = 1; r < 4; r++) { //행갯수
			for(int c = 1; c < 4; c++) { //열갯수
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int r = 1; r <= 5; r++) {
			for(int c = 1; c <= r; c++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int r = 5; r >= 1; r--) {
			for(int c = r; c >= 1; c--) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();

	}

}
