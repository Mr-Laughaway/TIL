package lab.java.core;

public class StaticTest {
	
	public static int snum = 5; //1
	
	static { //Static Initialize Block은 main보다 먼저 수행, 다른 객체보다 먼저 수행
		snum +=5;
	}//2
	

	public static void main(String[] args) {
		System.out.println(snum); //?
		snum /= 4;
		System.out.println(snum);
	}//4
	
	static { //메모리에 초기화해야할 코드 수행(예)
		snum *= 5;
	}//3

}
