package package1;


public class Child extends Parent {
	public void access() {
		System.out.println(name);
		name = "package2.child";
		System.out.println(name);
	}
}
