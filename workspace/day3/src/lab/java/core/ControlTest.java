package lab.java.core;

public class ControlTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a1:
		for(int i = 0; i < 3; i++) {
			a2:
			for(int j = 0 ; j < 3; j++) {
				//if(j==1) continue;
				if(j==1) break a1;
				System.out.println("i=" + i + ", j=" + j);
			}
		}
		
		
		//continue를 이용해서 1~10 사이의 짝수만 출력합니다.
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 1 )	continue;
			System.out.println(i);
		}

	}

}
