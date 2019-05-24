package lab.java.core;

public class Test {
	//속성+기능
	int a; //멤버변수, 인스턴스변수

	public static void main(String[] args) {
		int b; //로컬변수(반드시 초기화가 되어야 한다)
		System.out.println("test");
//		System.out.println(b); //초기화 안 해서 오류
		b = 3;
		System.out.println(b);
		
//		System.out.println(a); // 객체 생성없이 사용해서 오류
		Test t = new Test();
		System.out.println(t.a);
		
	}

}
