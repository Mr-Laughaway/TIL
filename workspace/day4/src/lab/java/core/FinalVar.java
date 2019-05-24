package lab.java.core;

public class FinalVar {
	
	public int flag;
	public final int PORT = 3000; //반드시 명시적 초기화가 필요하다.

	public static void main(String[] args) {
		
		FinalVar fv = new FinalVar();
		System.out.println(fv.PORT);
		System.out.println(fv.flag);
//		fv.PORT = 5555;

	}

}
