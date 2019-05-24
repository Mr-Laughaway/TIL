package lab.java.core;

public class Array3 {
	public static void main(String[] args) {
		String word = args[0];
		int len = word.length();
		
		for(int i = len -1; i >= 0; i--) {
			System.out.print(word.charAt(i));
		}
		System.out.println();
	}
}
