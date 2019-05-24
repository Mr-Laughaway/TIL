package lab.java.core;

public class While1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		while(count < 10) {
			System.out.println(++count);
		}
		
		//1. 1~10까지 누적 합
		int sum = 0;
		count = 1;
		while(count <= 10) {
			sum += count;
			count++;
		}
		System.out.println("1~10까지의 합은 " + sum);
		
		//2. 1~10까지의 홀수만 출력
		count = 1;
		while(count <= 10) {
			if(count % 2 == 1) {
				System.out.printf("%d ", count);
			}
			count++;
		}
		System.out.println();
		
		//3. 1~10까지의 홀수를 역순으로 출력
		count = 10;
		while(count >= 1) {
			if(count % 2 == 1) {
				System.out.printf("%d ", count);
			}
			count--;
		}
		System.out.println();
	}

}
