package lab.java.core;

public class TvTest {

	public static void main(String[] args) {
		
		Tv t = new Tv(); //객체 생성
		
		System.out.println(t.color);
		System.out.println(t.power);
		System.out.println(t.channel);
		
		t.power(); //메소드 호출
		System.out.println(t.power);
		t.power(); //메소드 호출
		System.out.println(t.power);
		t.channel = 3;
		System.out.println(t.channel);
		t.channelUp();
		System.out.println(t.channel);
		
		
	}

}
