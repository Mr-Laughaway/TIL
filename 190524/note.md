### 인터페이스?

- 사용자(User)와 제공자(Provider)사이에서 매개체(연결) 역할

- 구성요소 

  - public static final 상수속성
  - abstract 메서드(구현 body 없음)
  - static 메서드
  - default 메서드

- 설계시 서로 다른 시스템을 통합할 때 표준화를 위해서 활용

- 클래스는 일원화된 구조(선언 + 구현)이라고 볼수 있으나, 인터페이스는 이원화된 구조 - 인터페이스(선언)는 반드시 인터페이스 구현 클래스가 있어야만 인터페이스에서 선언한 서비스  제공이 가능

  ```public interface 이름 [extends 인터페이스, 인터페이스,..] {...} ```

  ``` public class 이름 implements 인터페이스, 인터페이스,.. {...} ```

- 인터페이스는 reference 변수(객체명) 타입으로 선언 가능

- 인터페이스를 구현한 클래스로 객체 생성 가능 => 다형성 객체





### abstract(추상, 구현이 없음, 선언만 존재함) - 클래스, 메서드

- 일반적으로 abstract 메서드는 클래스 설계시 모든 자식 클래스의 공통 기능을 선언하는 부모 클래스에 정의.
- 부모클래스에 선언된 abstract 메서드는 상속 받은 클래스에서 반드시 override해서 구현 body를 정의해야만 객체 생성이 가능.

- abstract 클래스는 new 사용해서 인스턴스(객체) 생성 불가능합니다. =>abstract메서드가 선언되어 있는 클래스 또는 객체 생성 못하게 클래스 설계할 때 사용

- abstract 메서드가 정의되어 있지 않아도 클래스를 abstract라고 선언할 수 있다.





## Chapter 08 예외처리

### 예외처리

- declare 예외처리 - throwㄴ

- handle 예외처리  - try~catch~finally

  ```try~catch~finally``` , ```try~finally``` ,  ```try~catch(0 or N)```

  ※ catch가 여러번 선언될 경우, 예외클래스의 상속 계층구조의 역순으로 구체적인 예외클래스타입부터 선언

  ```java
  try {
      예외 발생 가능성 문장;
      문장;
  } catch(예외클래스타입 객체) {
      예외 처리 문장;
  } catch(예외클래스타입 객체) {
      예외 처리 문장;
  } finally {
      리소스 정리 등등;
  }
  ```

- 사용자 정의 예외 클래스를 정의할 때는 구체적인 예외 처리 관련 API의 Exception을 상속받아 구체적 송석과 메서드를 추가해서 듦

  사용자 정의 예외 클래스를 정의할 때 Exception을 상속 받아서 예외처리에 필요한 속성과 메서드를 추가해서 만듦



## 예제

#### Product.java

```java
package lab.exercise.entity;

public class Product {
	private String name;
	private int price;
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
}

```



#### IShoppingBiz.java

```java
package lab.exercise.biz;

public interface IShoppingBiz {
	public abstract void printAllProducst();
	public abstract void printPricePerProduct();
	public abstract int calculateTotalPrice();
}

```



#### ShoppingBiz.java

```java
package lab.exercise.biz;



import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import lab.exercise.entity.Product;

public class ShoppingBiz implements IShoppingBiz {
	
	private HashMap<Product, Integer> basket;
	
	public ShoppingBiz() {
		basket = new HashMap<Product, Integer>();
		basket.put(new Product("사과", 1500), 6);
		basket.put(new Product("라면", 1200), 3);
		basket.put(new Product("식용유", 3500), 1);
		basket.put(new Product("과자", 2400), 5);
	}

	@Override
	public void printAllProducst() {
		// TODO Auto-generated method stub
		
		System.out.println("---------------------------------------");
		System.out.printf("%-10s%-10s%-10s%-10s\n", 
        		"   순번", "   품목명", "단가", "구입 갯수");
		System.out.println("---------------------------------------");
		
		Set<Product> keys = basket.keySet();
		Iterator<Product> iter = keys.iterator();
		
		int i = 0;
		while(iter.hasNext()) {
			i++;
			Product p = iter.next();
			String st = String.format("  %-4d%-5s%-5d%3s개\n", 
					i, 
					p.getName(), 
					p.getPrice(), 
					basket.get(p).intValue()
			).replace(" ","  ");
			
			System.out.printf(st);
		}
		System.out.println("---------------------------------------");
	}

	@Override
	public void printPricePerProduct() {
		// TODO Auto-generated method stub
		
		System.out.println("------------------------");
		
		Set<Product> keys = basket.keySet();
		Iterator<Product> iter = keys.iterator();
		
		int i = 0;
		while(iter.hasNext()) {
			i++;
			Product p = iter.next();
			String st = String.format("%d. %s : %d원\n", 
					i, 
					p.getName(), 
					calculateTotalPriceByProduct(p, basket.get(p).intValue())
			).replace(" ", "  ");
			
			System.out.printf(st);
		}
		
		System.out.println("------------------------");

	}
	
	public int calculateTotalPriceByProduct(Product product, int count) {
		return product.getPrice() * count;
	}

	@Override
	public int calculateTotalPrice() {
		// TODO Auto-generated method stub
		
		Set<Product> keys = basket.keySet();
		Iterator<Product> iter = keys.iterator();
		int sum = 0;
		while(iter.hasNext()) {
			Product p = iter.next();
			sum += calculateTotalPriceByProduct(p, basket.get(p).intValue());
		}
		
		return sum;
	}

}

```



#### ShoppingTest.java

```java
package lab.exercise.test;

import lab.exercise.biz.IShoppingBiz;
import lab.exercise.biz.ShoppingBiz;
import lab.exercise.util.CommonUtil;

public class ShoppingTest {
	
	public static void printMenu() {
		System.out.println("===== << 메뉴 >> =====");
		System.out.println("1. 장바구니 목록 출력");
		System.out.println("2. 품목별 가격 출력");
		System.out.println("3. 총 구입 가격 출력");
		System.out.println("9. 종료");
		System.out.println("====================");
	}

	public static void main(String[] args) {
		IShoppingBiz biz = new ShoppingBiz();
		

		while(true) {
			printMenu();
			System.out.print("## 메뉴 입력 : ");
			
			int n = -1;
			try {
				n = Integer.parseInt(CommonUtil.getUserInput());
			}
			catch(NumberFormatException e) {
				//뭐 특별히 할 필요는 없을 듯
			}
			
			if(n == 9) {
				System.out.println("\n프로그램을 종료합니다. Bye~ Bye~");
				break;
			}
			
			switch(n) {
			case 1:
				biz.printAllProducst();
				break;
			case 2:
				biz.printPricePerProduct();
				break;
			case 3:
				System.out.println("총 구입 가격: " + biz.calculateTotalPrice());
				break;
			default:
				System.out.println("[에러] 메뉴를 잘못 입력하였습니다.");
				continue;
			}
		}
	}

}

```



#### 실행결과

```
===== << 메뉴 >> =====
1. 장바구니 목록 출력
2. 품목별 가격 출력
3. 총 구입 가격 출력
9. 종료
====================
## 메뉴 입력 : asdf
[에러] 메뉴를 잘못 입력하였습니다.
===== << 메뉴 >> =====
1. 장바구니 목록 출력
2. 품목별 가격 출력
3. 총 구입 가격 출력
9. 종료
====================
## 메뉴 입력 : 1
---------------------------------------
   순번        품목명    단가        구입 갯수     
---------------------------------------
    1      식용유    3500      1개
    2      사과      1500      6개
    3      라면      1200      3개
    4      과자      2400      5개
---------------------------------------
===== << 메뉴 >> =====
1. 장바구니 목록 출력
2. 품목별 가격 출력
3. 총 구입 가격 출력
9. 종료
====================
## 메뉴 입력 : 2
------------------------
1.  식용유  :  3500원
2.  사과  :  9000원
3.  라면  :  3600원
4.  과자  :  12000원
------------------------
===== << 메뉴 >> =====
1. 장바구니 목록 출력
2. 품목별 가격 출력
3. 총 구입 가격 출력
9. 종료
====================
## 메뉴 입력 : 3
총 구입 가격: 28100
===== << 메뉴 >> =====
1. 장바구니 목록 출력
2. 품목별 가격 출력
3. 총 구입 가격 출력
9. 종료
====================
## 메뉴 입력 : 4
[에러] 메뉴를 잘못 입력하였습니다.
===== << 메뉴 >> =====
1. 장바구니 목록 출력
2. 품목별 가격 출력
3. 총 구입 가격 출력
9. 종료
====================
## 메뉴 입력 : 9

프로그램을 종료합니다. Bye~ Bye~

```







