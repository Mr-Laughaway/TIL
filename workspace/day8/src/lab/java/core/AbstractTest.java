package lab.java.core;

abstract class Animal {
	public abstract void move();
	public abstract void eat();
	
	public void slee() {
		System.out.println("zz z z Z");
	}
}


class Dog extends Animal {
	public void move() {
		System.out.println("벌러덩");
	}
	
	public void eat() {
		System.out.println("잡식성");
	}
}



public class AbstractTest {

	public static void main(String[] args) {
//		Animal animal = new Animal();
		Dog dog = new Dog();
		Animal animal = new Dog();
		animal.eat();
		animal.move();
		animal.slee();

	}

}
