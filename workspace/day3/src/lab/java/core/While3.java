package lab.java.core;

public class While3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i <= 100; i++) {
			int tmp = i;
			
			System.out.printf("i=%d ", tmp);
			do {
				int n = tmp%10;
				if( n!= 0 && n%3 == 0 ) {
					System.out.printf("짝");
				}
				tmp /= 10;
			} while(tmp != 0);
			System.out.println();
		}
	}

}
