package lab.java.core;

public class For1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		for(int i = 1; i <= 10; i++) {
//			System.out.println(i);
//		}
		
		//1. 1~10까지 누적 합
		//2. 1~10까지의 홀수만 출력
		//3. 1~10까지의 홀수를 역순으로 출력
		//4. A~Z까지 출력
		//5. A~Z까지 역순으로 출력
		
		//1. 1~10까지 누적 합
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println("1~10까지의 합은 " + sum);
		
		//2. 1~10까지의 홀수만 출력
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 1)
				System.out.printf("%d ", i);
		}
		System.out.println();
		
		//3. 1~10까지의 홀수를 역순으로 출력
		for(int	i = 10; i >= 1; i--) {
			if(i % 2 == 1)
				System.out.printf("%d ", i);
		}
		System.out.println();
		
		//4. A~Z까지 출력
		for(int i = 65; i <= 90; i++) {
			System.out.printf("%c ", i);
		}
		System.out.println();
		
		//5. A~Z까지 역순으로 출력
		for(int i = 90; i >= 65; i--) {
			System.out.printf("%c ", i);
		}

	}

}
