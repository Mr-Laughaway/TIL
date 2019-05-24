package lab.java.core;

import java.util.Scanner;


public class While4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int rnum = (int)(Math.random()*100+1);
		Scanner scanner = new Scanner(System.in);
		System.out.printf("문제가 출제되었습니다. 맞춰보세요. (%d)\n", rnum);
		
		int nUser;
		int count = 5;
		while(true) {
			nUser = scanner.nextInt();
			if(nUser == rnum) {
				System.out.println("You Win!!");
				break;
			}
			else if (nUser > rnum)
				System.out.println("Down");
			else
				System.out.println("Up");
			
			count--;
			if(count == 0) {
				System.out.println("I(Computer) Win^^");
			}
			
		}
		scanner.close();
	}

}
