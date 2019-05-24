package lab.java.core;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lotto = new int[6]; // 로또 번호 저장할 배열 방 준비
		
		//1~45 범위에서 난수 생성해서 배열 첫 번째 방에 저장
		//1~45 범위에서 난수 생성해서 배열 두 번째 방에 저장 (같지 않을 때만)
		
		//번호 생성
		int num;
		boolean bSame;
		for(int i = 0; i < lotto.length; i++) {
			while(true) {
				bSame = false;
				num = ((int)(Math.random()*45) + 1);
			
				for(int j = 0; j < i; j++ ) {
					if(num == lotto[j]) {
						bSame = true;
						break;
					}
				}
				
				if(bSame == false) {
					lotto[i] = num;
					break;
				}
			}
		}
		
		
		//bubble sort
		int tmp;
		for(int i = 0; i < lotto.length; i++) {
			for(int j = i+1; j < lotto.length; j++) {
				if( lotto[i] > lotto[j]) {
					tmp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = tmp;
				}
			}
		}
		
		//결과 출력
		for(int n : lotto) {
			System.out.printf("%d ", n);
		}
		
	}

}
