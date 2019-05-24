package lab.java.core;

public class ArrayTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int matrix1[][] = new int[3][4];
		int matrix2[][] = new int[3][4];
		
		for(int i = 0; i < matrix1.length; i++) {
			for(int j = 0; j < matrix1[i].length; j++) {
				matrix1[i][j] = (int)(Math.random()*12) + 1;
				matrix2[i][j] = (int)(Math.random()*12) + 1;
			}
		}
		
		for(int i = 0; i < matrix1.length; i++) {
			for(int j = 0; j < matrix1[i].length; j++) {
				System.out.printf("%2d ", matrix1[i][j]);
			}
			System.out.printf("\t\t");
			
			for(int j = 0; j < matrix2[i].length; j++) {
				System.out.printf("%2d ", matrix2[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		int sum = 0;
		for(int i = 0; i < matrix1.length; i++) {
			for(int j = 0; j < matrix1[i].length; j++) {
				if(matrix1[i][j] == matrix2[i][j]) {
					System.out.printf("일치하는 숫자 : [%d][%d] = %d\n", i, j, matrix1[i][j]);
					sum++;
				}
			}
		}
		System.out.printf("\n같은 갯수는 %d개", sum);
	}

}
