package lab.java.core;

public class ArrayTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] nums;
		int nums2[][];
		int[] nums3[];
		
		nums = new int[5][5];
		nums2 = new int[5][];
		//nums3 = new int[][5];
		
		nums3 = new int[][] { 
			{1,2,3},
			{4,5,6,7},
			{8,9,10,11,12}
		};
		
		System.out.println(nums3.length);
		System.out.println(nums3[0].length);
		System.out.println(nums3[1].length);
		System.out.println(nums3[2].length);
		
		for(int i = 0; i < nums3.length; i++) {
			for(int j = 0; j < nums3[i].length; j++) {
				System.out.printf("%d ", nums3[i][j]);
			}
			System.out.println();
		}

	}

}
