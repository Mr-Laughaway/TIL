package lab.java.core;

public class BaseBall {
	public static int player = 0;
	public static int outCount = 0;
	public static int strike = 0;
	public static int ball = 0;
	
	public static void getStatus() {
		System.out.print(outCount + " 아웃, " + strike + " 스트라이크, " + ball + " 볼");
	}
	
	public static boolean isStrike() {
		return (int)(Math.random() * 10) % 2 == 0;
	}
}
