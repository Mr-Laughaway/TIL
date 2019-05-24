package lab.java.core;

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		System.out.println(p1.id);
		p1.id = "korea";
		System.out.println(p1.id);
		//p1.name = "대한민국";
		p1.setName("대한민국");
		//System.out.println(p1.name);
		System.out.println(p1.getName());
		
	}

}
