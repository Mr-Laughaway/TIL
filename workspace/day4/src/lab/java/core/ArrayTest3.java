package lab.java.core;

public class ArrayTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int matrix[][] = new int[3][3];
		
		int sum = 0;
		int min = 100;
		int max = 0;
		int count = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int)(Math.random()*100) + 1;
				System.out.printf("%3d ", matrix[i][j]);
				
				sum += matrix[i][j];
				if(min > matrix[i][j]) min = matrix[i][j];
				if(max < matrix[i][j]) max = matrix[i][j];
				
				count++;
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.printf("총  합: %d\n", sum);
		System.out.printf("평  균: %.2f\n", (float)sum / count);
		System.out.printf("최소값: %d\n", min);
		System.out.printf("최대값: %d\n", max);
	}

}
