package lab.java.core;

public class ArrayTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array1[] = new int[10];
		int array2[] = new int[10];
		int array3[] = new int[10];
		
		for(int i = 0; i < array1.length; i++) {
			array1[i] = (int)(Math.random()*100) + 1;
			array2[i] = array1[i];
			array3[i] = array1[i];
		}
		
		for(int i = 0; i < array1.length; i++) {
			System.out.printf("%d ", array1[i]);
		}
		System.out.println();
		
		int count1= 0;
		for(int i = 0; i < array1.length; i++) {
		
			for(int j = i + 1; j < array1.length; j++) {
				count1++;
				if(array1[i] > array1[j]) {
					int tmp = array1[i];
					array1[i] = array1[j];
					array1[j] = tmp;
				
				}
			}
	
		}
		
		for(int i = 0; i < array1.length; i++) {
			System.out.printf("%d ", array1[i]);
		}
		System.out.printf(" : %d회\n", count1);

		
		
		////책 소트
		int count2 = 0;
		for(int i = 0; i < array2.length-1; i ++) {
			boolean changed = false; // 자리바꿈이 발생햇는지 체크한다.
			for(int j = 0; j < array2.length-1-i; j++) {
				count2++;
				if(array2[j] > array2[j+1]) {
					int tmp = array2[j];
					array2[j] = array2[j+1];
					array2[j+1] = tmp;
					changed = true;
				}
			}
			
			if(!changed) break;
		}
		
		for(int i = 0; i < array2.length; i++) {
			System.out.printf("%d ", array2[i]);
		}
		System.out.printf(" : %d회\n", count2);
		
		
		//책 소트2
		int count3 = 0;
		for(int i = 0; i < array3.length-1; i ++) {
//			boolean changed = false; // 자리바꿈이 발생햇는지 체크한다.
			for(int j = 0; j < array3.length-1-i; j++) {
				count3++;
				if(array3[j] > array3[j+1]) {
					int tmp = array3[j];
					array3[j] = array3[j+1];
					array3[j+1] = tmp;
//					changed = true;
				}
			}
			
//			if(!changed) break;
		}
		
		for(int i = 0; i < array3.length; i++) {
			System.out.printf("%d ", array3[i]);
		}
		System.out.printf(" : %d회\n", count3);
	}

}
