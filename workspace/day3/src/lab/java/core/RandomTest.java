package lab.java.core;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int rnum = (int)(Math.random()*100);
		Random r = new Random();
		int rnum2 = r.nextInt(100)+1;
		System.out.println(rnum);
		System.out.println(rnum2);
	}

}
