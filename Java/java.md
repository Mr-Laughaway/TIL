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



#### 예제 1) 마트에서 장보기

##### Product.java

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



##### IShoppingBiz.java

```java
package lab.exercise.biz;

public interface IShoppingBiz {
	public abstract void printAllProducst();
	public abstract void printPricePerProduct();
	public abstract int calculateTotalPrice();
}

```



##### ShoppingBiz.java

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



##### ShoppingTest.java

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



##### 실행결과

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



#### 예제 2) ArrayList 사용법

##### ArrayListTest.java

```java
package lab.java.core;

import java.util.ArrayList;
import java.util.Iterator;

import lab.exercise.entity.Product;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Product> aList = new ArrayList();
		aList.add(new Product("사과", 1500));
//		aList.set(0, new Product("라면", 1000));
		aList.add(new Product("라면", 1000));
		
		for(int i = 0; i < aList.size(); i++) {
			System.out.println(aList.get(i).getName());
		}
		
		
		for(Product p : aList) {
			System.out.println(p.getName());
		}
		
		Iterator<Product> iter = aList.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next().getName());
		}
	}

}

```



#### 예제 3) 고객 관리 프로그램



#### 오류의 종류

- compile error - 문법적 문제, 언어 규칙에 맞지 않는 문제

- runtime error - 실행시에 발생되는 오류 - 논리 오류, 로직 오류

  - Error - 프로그램 적으로 수정할 수 없음, 무겁고 치명적인 오류

  - RuntimeException의 하위 Exception - 프로그램적으로 수정하면 정상적으로 프로그램 흐름을 정상적으로 유도할 수 있음

    

#### 자바의 Exception

- Checked exception 

  실행 범위가 JRE를 벗어나는 경우의 코드에 대해서는 컴파일시에 check를 해주므로 미리 처리하면 됨 (IOException, Socket 관련 Exception, SQLException 등등)

- unchecked exception

  실행 범위가 JRE를 벗어나지 않고, 사용자 부주의 또는 논리 오류에 의해서 발생될 수 있는 Exception (NullPointerException, ArrayIndexOutOfBoundsException, NumberFormatException 등등)



#### 예외 처리 방식 - declare, handle

- declare 방식 - throws 예외 클래스이름을 메서드 선언부에 선언합니다. 예외처리 대신에 메서드를 호출한 곳으로 예외처리를 떠 넘깁니다.

- handle 방식 - try~catch~finally

  ```java
  try {
  	//에외 발생될 가능성이 있는 문장;
      //문장;
  }
  catch(예외클래스타입 객체) {
      //예외 처리 문장;
  }
  catch(예외클래스타입 객체) {
      //예외 처리 문장;
  }
  finally {
      //예외 발생과 무관한 반드시 수행해야 할 코드 문장;
      //ex) 사용했었떤 자원 정리  .close() 등등 ==> hecked exception... finally block 안에도 try~catch가 올 수 있다.
  }
  ```

- 프로그램 구현시 의도적으로 예외를 발생시켜서 호출한쪽(caller)에게 메시지를 전달해서 호출한쪽(caller)에서 흐름을 제어할 수 있도록 throw new 예외클래스(메시지) 처리합니다.

  - API - java.lang.Throwable (java.lang.Error, java.lang.Exception 등등)

  - 사용자 정의 예외클래스

    ```AccessModifier class XXXException extends 구체적 Exception(API) { //속성 ;//생성자; //기능; ... } ```



### 유용한 코드

- 얕은 복사와 깊은 복사 

  ```.clone() 참조```

  

- Boxing 과 UnBoxing

  ```java
  class BoxingTest {
  	public static void main(String[] args) {
          int n5 = 5;
          Integer i5 = n5; //Boxing
          
          Integer i6 = new Integer(6);
          int n6 = i6; //UnBoxing
      }
  }
  ```



- StringBuffer 와 StringBuilder

  > "멀티스레딩 환경 : StringBuffer,  그외(성능향상) : StringBuilder"

  

- 문자 인코딩 변환

  - ```"가".getBytes("UTF-8");``` 
  - ```String str = new String(utf8_str, "UTF-8");```

  

- Class 객체를 얻는 방법

  - 얻기

    ```Class cObj = new Card().getClass(); //생성된 객체로부터 얻는  방법```

    ```Class cObj = Card.class; // 클래스 리터럴(*.class)로부터 얻는 방법```

    ```Class cObj = Class.forName("Card"); //클래스 이름으로부터 얻는 방법```

  - 생성하기

    ``` Card c = new Card(); //new 연산자를 이용해서 객체 생성```

    ```Card c = Card.class.newInstance(); //Class객체를 이요해서 객체 생성```

    

- 정규표현식(Regular Expression) - ```java.util.regex```

  - ```c[a-z]*``` : c로 시작하는 소문자 영단어
  - ```c[a-z]``` : c로 시작한는 두 글자 소문자 영단어
  - ```. ``` : 모든 한 글자 문자
  - ```.*```  : 모든 문자열
  - ```c\d```  : c와 숫자로 구성된 두자리 문자열
  - ```c[0-9]```  : 상동
  - ```c.*t```  : c로 시작하고 t로 끝나는 모든 문자열
  - ```[b|c].{2}``` : b 또는 c 로 시작하는 세자리 문자열
  - 등등 



### 자바의 정석 1권 마무리 예제

#### IGradeManager.java

```java
package lab.grade.biz;

public interface IGradeManager {
	public static final int PRINT_ALL = 0;
	public static final int PRINT_PASS = 1;
	public static final int PRINT_FAIL = 2;
	
	public void printStudents(int printType);
}

```



#### GradeManager.java

```java
package lab.grade.biz;

import lab.grade.entity.CareerStudent;
import lab.grade.entity.NewStudent;
import lab.grade.entity.Student;

public class GradeManager implements IGradeManager {
	private Student[] students = new Student[30];
	private int cnt = 0;
	
	public GradeManager() {
		students[cnt++] = new NewStudent("10001", "kim", new int[] {74, 70, 80}, false);
		students[cnt++] = new NewStudent("10005", "park", new int[] {90, 90, 100}, false);
		students[cnt++] = new NewStudent("10009", "lee", new int[] {70, 62, 60}, true);
		students[cnt++] = new CareerStudent("20001", "han", new int[] {96, 85, 93}, 1);
		students[cnt++] = new CareerStudent("20005", "nam", new int[] {90, 80, 73}, 2);
		students[cnt++] = new CareerStudent("20009", "choi", new int[] {70, 70, 90}, 1);
	}

	@Override
	public void printStudents(int printType) {
		System.out.println("=====================================================================================");
		System.out.println("사번\t이름\t신입/경력 인턴여부 경력년수\tC       Linux    Java\t총점\t평균\t합격여부");
		System.out.println("=====================================================================================");
		for(int i = 0; i < cnt; i++) {
			if(printType == PRINT_PASS && students[i].isPass() == false)
				continue;
			else if(printType == PRINT_FAIL && students[i].isPass() == true)
				continue;
			
			String st = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s",
					students[i].getStudentNo(),
					students[i].getStudentName(),
					students[i] instanceof NewStudent ? "신입" : "경력",
					students[i] instanceof NewStudent ? 
							(((NewStudent)students[i]).isInternYn() ? "Y" : "N") : "",
					students[i] instanceof CareerStudent ?
							((CareerStudent)students[i]).getCareerYears() : "",
					students[i],
					students[i].isPass() ? "합격" : "불합격"
			);
            
			System.out.println(st);
		}
		System.out.println("=====================================================================================");

	}

}
```



#### Student.java

```java
package lab.grade.entity;

import lab.grade.util.CommonUtil;

public abstract class Student {
	private String studentNo;
	private String studentName;
	private int[] gradeArr;
	
	public Student(String studentNo, String studentName, int[] gradeArr) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.gradeArr = gradeArr;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int[] getGradeArr() {
		return gradeArr;
	}

	public void setGradeArr(int[] gradeArr) {
		this.gradeArr = gradeArr;
	}
	
	public int getTotal() {
		int total = 0;
		for(int n : gradeArr) {
			total += n;
		}
		return total;
	}
	
	public double getAverage() {
		return CommonUtil.round(((double)getTotal()) / gradeArr.length);
	}
	
	public abstract boolean isPass();

	
	@Override
	public String toString() {
		String st = String.format("%d\t%d\t%d\t%d\t%.1f", 
				gradeArr[0],
				gradeArr[1],
				gradeArr[2],
				getTotal(),
				getAverage()
		);
		
		return st;
	}

}

```



#### NewStudent.java

```java
package lab.grade.entity;

public class NewStudent extends Student {
	
	private boolean internYn;
	
	public NewStudent(String studentNo, String studentName, int[] gradeArr, boolean internYn) {
		super(studentNo, studentName, gradeArr);
		this.internYn = internYn;
	}

	@Override
	public boolean isPass() {
		return getAverage() >= 70 ? true : false;
	}

	public boolean isInternYn() {
		return internYn;
	}

	public void setInternYn(boolean internYn) {
		this.internYn = internYn;
	}

}

```



#### CareerStudent.java

```java
package lab.grade.entity;

public class CareerStudent extends Student {
	
	private int careerYears;
	
	public CareerStudent(String studentNo, String studentName, int[] gradeArr, int careerYears) {
		super(studentNo, studentName, gradeArr);
		this.careerYears = careerYears;
	}

	@Override
	public boolean isPass() {
		return getAverage() >= 80 ? true : false;
	}

	public int getCareerYears() {
		return careerYears;
	}

	public void setCareerYears(int careerYears) {
		this.careerYears = careerYears;
	}

}

```



#### CommonUtil.java

```java
package lab.grade.util;

import java.util.Scanner;

public class CommonUtil {
	
	public static String getUserInput() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	
	public static double round(double input) {
		return Double.parseDouble(String.format("%.1f", input));
	}
	
}

```



#### GradeTest.java

```java
package lab.grade.test;

import lab.grade.biz.GradeManager;
import lab.grade.biz.IGradeManager;
import lab.grade.util.CommonUtil;

public class GradeTest {
	
	public static void printMenu() {
		System.out.println("== << 성적 관리 시스템 메뉴 >> ==");
		System.out.println("1. 전체 수강생 출력");
		System.out.println("2. 합격 수강생 출력");
		System.out.println("3. 불합격 수강생 출력");
		System.out.println("9. 종료");
		System.out.println("===========================");
		System.out.print("## 메뉴 입력 => ");
	}

	public static void main(String[] args) {
		
		IGradeManager gm = new GradeManager();
		
		while(true) {
			printMenu();
			int n = -1;
			try {
				n = Integer.parseInt(CommonUtil.getUserInput());
			}
			catch(NumberFormatException e) {
				//특별히 할 일은 없을 듯...
			}
			finally {
				if(n == 9) {
					System.out.println("## 성적 관리 시스템을 종료합니다!!");
					break;
				}
				
				switch(n) {
				case 1:
					gm.printStudents(IGradeManager.PRINT_ALL);
					break;
					
				case 2:
					gm.printStudents(IGradeManager.PRINT_PASS);
					break;
					
				case 3:
					gm.printStudents(IGradeManager.PRINT_FAIL);
					break;
					
				default:
					System.out.println("## 없는 메뉴를 선택하셨씁니다!!");
				}
			}//end of try~catch~finally
		}//end of while

	}//end of main

}

```



### Chapter 9 정리

#### java.lang.Object

- .clone() - 객체 복제

  - 얕은 복사 - 객체의 생성된 주소값을 할당하는 방식 유사(동일한 객체를 참조)
  - 깊은 복사 - 객체의 모든 속성을 새로 생성해서 메모리에 새로운 동일한 객체를 만듦(사용자 정의 클래스를 복제가능도록 하려면 Cloneable 구현해야함)

- .equals() - 객체 생성 주소의 hash값을 비교

- .hashCode()  - 객체 생성 주소의 hash값 리턴

- .getClass()  - 실제 생성된 객체의 타입을 리턴 받을 때 사용

  ```java
  Object o = new Double(3.1);
  Class c = o.getClass();
  ```

- .toString() - 클래스 FullName@hash값



#### Java.lang.String

- 문자열 표현, 불변객체

  ```java
  String s = new String(new byte[]{65,66,67});
  System.out.println(s); //...println(s.toString()) 와 동일
  
  String s2 = "java";
  byte[] bytes = s2.getBytes();
  s2.chartAt(0);
  s2.substring(1,3);
  String newStr = s.concat(s2); // -> s객체 출력하면 "ABC"
  ```

- contains() - 문자/문자열 포함 여부 확인 (true / false)

- .equals() - ```string객체.equals(비교할 String객체)``` -> 문자열의 내용을 비교

- .equalsIgnoreCase() - 대소문자비교X 상동

- .valueOf - primitive data type을 문자열로 변환

- .split(구분자 또는 정규표현식) - 문자열을 구분자로 쪼개어 문자열 배열로...

- .join(결합문자, 문자열 배열) - 문자열 배열의 요소를 하나씩 결합 문자를하여 조합...



#### 가변 문자열은 StringBuffer

```java
StringBuffer sb1 = new StringBuffer("java");
StringBuffer sb2 = new StringBuffer("java");
System.out.println(sb1.equals(sb2)); // false
// String과는 다른 결과
```

- ```sb1.append("& sql");``` //sb1 의 출력 내용은 "java& sql"

  ##### ```String과는 다름 주의!```

- ```sb1.insert(4, " web ");```//sb1 찍어보면 값이 바뀌어 있음

- .remove()

- .length()

- .substring()



### java.lang.Math

```new Math()``` 불가. 모든 속성과 메서드는 ```static```

- abs()
- max()
- min()
- log()
- power()
- sqrt()
- round()
- ceil()
- floor()
- cos()
- ...



#### Wrapping

모두 객체로 구현해야 할 경우, primitive data type 을 객체로 wrapping

```
boolean -> Boolean -> booleanValue() 
byte -> Byte          byteValue()  
short -> Short        shortValue()
char -> Character     charValue()
int -> Integer        intValue()
long -> Long          longValue()
float -> Float        floatValue()
double -> Double      doubleValue()
```



#### java.util.Objects

- .isNull(obj)
- .nonNull(obj)
- .requireNull(obj)
- .requireNonNull(obj)



#### 정규표현식 (regular expression)

1. java.util.regex.Pattern.compile("정규표현식 패턴") => Patter 인스턴스 생성
2. Matcher m = Pattern 인스턴스.matcher("처리할 대상 데이터") =>  Matcher 인스턴스 생성
3. m.matches() => true/false로 리턴

```
[a-zA-Z0-9]
[^0-9] : not
[0-9]? : one
[0-9]+ : zero || one
[0-9]* : zeor || more
{2, 5} : 최소횟수, 최대횟수
{3} : 3회
\\d
\\D
\\w
\\W
\\s
\\S
```



#### 표준 출력

1.5버전 이전에 한글을 포함한 키보드 입려을 받으려면 java.io.InputStream 사용. 바이트 최상위 스트림은 추상클래스.System.in 운영체제에 맞게 InputStream 구현된 객체

문자 스트림은 XXXXReader, XXWriter

```java
//JDK 1.5 이전

try {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    //int n = Integer.parseInt(s);
}
catch(IOException e) {
    //Todo:
}
finally {
    try {
        br.close();
    }
    catche(IOException e){
        //Todo:
    }
}
```

```java
//JDK 1.5 이상

Scanner scan = new Scanner(System.in);
scan.next();
scan.nextLine();
scan.nextInt();
...
    
```

```
//JDK 1.6 이상
System.console()

```



#  





### Chapter 10

#### 1.날짜와 시간

##### 예제

##### CalendarEx2.java

```java
package lab.java.core;

import java.util.Calendar;

public class CalendarEx2 {

	public static void main(String[] args) {
		//요일은 1부터 시작하기 때문에, DAY_OFWEEK[0]은 비워두었다.
		final String[] DAY_OF_WEEK = {"", "일", "월", "화", "수", "목", "금", "토"};
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		//month의 경우 0 부터 시작하기 때문에 8월인 경우, 7로 지정해야 한다.
		//date1.set(2015, Calendar.AUGUST, 15);와 같이 할 수도 있다.
		date1.set(2015, 7, 15); // 2015 8월 15일로 날짜를 설정한다.
		System.out.println("date1은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일이고,");
		System.out.println("date2은 " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일입니다.");
		
		//두 날짜간의 차이르 ㄹ얻으려면, getTimeInMillis() 천분의 일초 단위로 변환해야한다.
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
		System.out.println("그 날(date1)부터 지금(date2)까지 " + difference + "초가 지났습니다.");
		System.out.println("일(day)로 계산하면 " + difference / (24*60*60) + "일입니다."); // 1일 = 24* 60 * 60

	}
	
	public static String toString(Calendar date) {
		
		return date.get(Calendar.YEAR)+ "년 " 
				+ (date.get(Calendar.MONTH)+1 ) + "월 "
				+ date.get(Calendar.DATE) + "일 ";
	}

}


```



##### CalendarEx3.java

```java
package lab.java.core;

import java.util.Calendar;

public class CalendarEx3 {
	public static void main(String[] args) {
		final int[] TIME_UNIT = {3600, 60, 1};
		final String[] TIME_UNIT_NAME = {"시간 ", "분 ", "초 "};
		
		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		
		time1.set(Calendar.HOUR_OF_DAY, 10);
		time1.set(Calendar.MINUTE, 20);
		time1.set(Calendar.SECOND, 30);
		
		time2.set(Calendar.HOUR_OF_DAY, 20);
		time2.set(Calendar.MINUTE, 30);
		time2.set(Calendar.SECOND, 10);
		
		System.out.println(
				"time1 :" + time1.get(Calendar.HOUR_OF_DAY) + "시 " +
				time1.get(Calendar.MINUTE) + "분 " +
				time1.get(Calendar.SECOND) + "초"
		);
		
		System.out.println(
				"time2 :" + time2.get(Calendar.HOUR_OF_DAY) + "시 " +
				time2.get(Calendar.MINUTE) + "분 " +
				time2.get(Calendar.SECOND) + "초"
		);
		
		long difference = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis()) /1000;
		System.out.println("time1과 time2의 차이는 " + difference + "초 입니다.");
		
		String tmp = "";
		for(int i = 0; i < TIME_UNIT.length; i++) {
			tmp += difference/TIME_UNIT[i] + TIME_UNIT_NAME[i];
			difference %= TIME_UNIT[i];
		}
		System.out.println("시분초로 변환하면 " + tmp + "입니다.");
	}
}


```



##### DecimalFormatEx1.java

```java
package lab.java.core;

import java.text.DecimalFormat;

public class DecimalFormatEx1 {

	public static void main(String[] args) {
		double number = 1234567.89;
		String[] pattern = {
			"0",
			"#",
			"0.0",
			"#.#",
			"0000000000.0000",
			"##########.####",
			"#.#-",
			"-#.#",
			"#,###.##",
			"#,####.##",
			"#E0",
			"0E0",
			"##E0",
			"00E0",
			"####E0",
			"0000E0",
			"#.#E0",
			"0.0E0",
			"0.000000000E0",
			"00.00000000E0",
			"000.0000000E0",
			"#.#########E0",
			"##.########E0",
			"###.#######E0",
			"#,###.##+;#,###.##-",
			"#.#%",
			"#.#\u2030",
			"\u00A4 #,###",
			"'#'#,###",
			"''#,###"
		};
		
		for(int i = 0; i < pattern.length; i++) {
			DecimalFormat df = new DecimalFormat(pattern[i]);
			System.out.printf("%19s : %s\n", pattern[i], df.format(number));
		}
	

	}

}


```

```
 //실행 결과
                  0 : 1234568
                  # : 1234568
                0.0 : 1234567.9
                #.# : 1234567.9
    0000000000.0000 : 0001234567.8900
    ##########.#### : 1234567.89
               #.#- : 1234567.9-
               -#.# : -1234567.9
           #,###.## : 1,234,567.89
          #,####.## : 123,4567.89
                #E0 : .1E7
                0E0 : 1E6
               ##E0 : 1.2E6
               00E0 : 12E5
             ####E0 : 123.5E4
             0000E0 : 1235E3
              #.#E0 : 1.2E6
              0.0E0 : 1.2E6
      0.000000000E0 : 1.234567890E6
      00.00000000E0 : 12.34567890E5
      000.0000000E0 : 123.4567890E4
      #.#########E0 : 1.23456789E6
      ##.########E0 : 1.23456789E6
      ###.#######E0 : 1.23456789E6
#,###.##+;#,###.##- : 1,234,567.89+
               #.#% : 123456789%
               #.#‰ : 1234567890‰
            ¤ #,### : ￦ 1,234,568
           '#'#,### : #1,234,568
            ''#,### : '1,234,568

```



##### SimpleDateFormatEx1.java

```java
package lab.java.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatEx1 {

	public static void main(String[] args) {

		Date today = new Date();
		
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
		SimpleDateFormat sdf5, sdf6, sdf7, sdf8, sdf9;
		
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("''yy년 MMM dd일 E요일");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		
		sdf5 = new SimpleDateFormat("오늘은 올 해의 D번째 날입니다.");
		sdf6 = new SimpleDateFormat("오늘은 이 달의 d번째 날입니다.");
		sdf7 = new SimpleDateFormat("오늘은 올 해의 w번째 주입니다.");
		sdf8 = new SimpleDateFormat("오늘은 이 달의 W번째 주입니다.");
		sdf9 = new SimpleDateFormat("오늘은 이 달의 F번째 E요일입니다.");
		
		System.out.println(sdf1.format(today));
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		System.out.println(sdf4.format(today));
		System.out.println();
		System.out.println(sdf5.format(today));
		System.out.println(sdf6.format(today));
		System.out.println(sdf7.format(today));
		System.out.println(sdf8.format(today));
		System.out.println(sdf9.format(today));
		
	}

}

```



##### SimpleDateFormatEx2.java

```java
package lab.java.core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormatEx2 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 9, 3); // 2005년 10월 3일 - Month 는 0~11의 범위를 갖는다.
		
		Date day = cal.getTime(); //Calendar를 Date로 변환
		
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("yy-MM-dd E요일");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		
		System.out.println(sdf1.format(day));
		System.out.println(sdf2.format(day));
		System.out.println(sdf3.format(day));
		System.out.println(sdf4.format(day));
	}
}

```





### Chapter 11

#### 컬렉션 프레임워크

- List

  - ArrayList

    ```java
    package lab.java.core;
    
    
    import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.List;
    import java.util.Vector;
    
    public class ListTest {
    
    	public static void main(String[] args) {
    		
    		//ArrayList example
    		String cars[] = {"k3", "k5", "sm5", "k7", "9", "sm3", "sm5", "sm6", };
    		List<String> alist = new ArrayList<String>();
    		for(String car : cars) {
    			alist.add(car);
    		}
    		System.out.println(alist.size());
    		System.out.println(alist);
    		alist.set(1, "Bentz");
    		System.out.println(alist);
    		alist.remove(5);
    		System.out.println(alist);
    		System.out.println(alist.size());
    		
    		//get(i)
    		for(int i =0; i < alist.size(); i++) {
    			System.out.print(alist.get(i) + ", ");
    		}
    		System.out.println();
    		
    		//alist.iterator(), iter.hasNext(), iter.next()
    		Iterator<String> iter = alist.iterator();
    		while(iter.hasNext()) {
    			System.out.print(iter.next() + ", ");
    		}
    		System.out.println();
    		
    		
    		//Vector example
    		List vec = new Vector();
    	}
    
    }
    
    ```

    

  - LinkedList

  - Stack

  - Vector

    ```java
    package lab.java.core;
    
    import java.util.Vector;
    
    public class VectorTest {
    	public static void main(String[] args) {
    		
    		Vector<String> vec = new Vector();
    		System.out.println("capacity: " + vec.capacity());
    		System.out.println("size: " + vec.size());
    		
    		for(int i = 1; i < 12; i++) {
    			vec.add("K" + i);
    		}
    		System.out.println("capacity: " + vec.capacity());
    		System.out.println("size: " + vec.size());
    		
    		for(int i = 12; i < 23; i++) {
    			vec.add("K" + i);
    		}
    		System.out.println("capacity: " + vec.capacity());
    		System.out.println("size: " + vec.size());
    		
    		for(int i = 23; i < 42; i++) {
    			vec.add("K" + i);
    		}
    		System.out.println("capacity: " + vec.capacity());
    		System.out.println("size: " + vec.size());
    		
    	}
    }
    
    
    ```

    ```
    ///실행 결과
    capacity: 10
    size: 0
    capacity: 20
    size: 11
    capacity: 40
    size: 22
    capacity: 80
    size: 41
    
    
    ```

    

- Set (중복 제거)

  - HashSet
  - TreeSet (이진 정렬 적용됨)

  ```java
  package lab.java.core;
  
  
  import java.util.HashSet;
  import java.util.Iterator;
  import java.util.Set;
  import java.util.TreeSet;
  
  public class ListTest {
  
  	public static void main(String[] args) {
  		
  		//ArrayList example
  		String cars[] = {"k3", "k5", "sm6", "k7", "k9", "sm3", "sm5", "sm6", "k5" };
  		Set<String> hSet = new HashSet();
  		Set<String> tSet = new TreeSet();
  		for(String car : cars) {
  			hSet.add(car);
  			tSet.add(car);
  		}
  		
  		Iterator<String> iter = hSet.iterator();
  		System.out.print("HashSet :");
  		while(iter.hasNext()) {
  			System.out.print(iter.next()+",");
  		}
  		System.out.println();
  		
  		iter = tSet.iterator();
  		System.out.print("TreeSet :");
  		while(iter.hasNext()) {
  			System.out.print(iter.next()+",");
  		}
  		System.out.println();	
  	}
  
  }
  
  ```

  ```
  //실행결과
  HashSet :k3,sm3,k5,sm5,k7,sm6,k9,
  TreeSet :k3,k5,k7,k9,sm3,sm5,sm6, //<----정렬됨
  
  
  ```

  

- Map

  - HashMapEx1

    ```java
    package lab.java.core;
    
    import java.util.Collection;
    import java.util.Collections;
    import java.util.HashMap;
    import java.util.Iterator;
    import java.util.Map;
    import java.util.Set;
    
    public class HashMapEx1 {
    
    	public static void main(String[] args) {
    		
    		HashMap map = new HashMap();
    		map.put("김자바",  new Integer(90));
    		map.put("김자바",  new Integer(100));
    		map.put("이자바",  new Integer(100));
    		map.put("강자바",  new Integer(80));
    		map.put("안자바",  new Integer(90));
    		
    		Set set = map.entrySet();
    		Iterator it = set.iterator();
    		while(it.hasNext()) {
    			Map.Entry e = (Map.Entry)it.next();
    			System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
    		}
    		
    		set = map.keySet();
    		System.out.println("참가자 명단 : " + set);
    		
    		Collection values = map.values();
    		it = values.iterator();
    		
    		int total = 0;
    		while(it.hasNext()) {
    			Integer i = (Integer)it.next();
    			total += i.intValue();
    		}
    		
    		System.out.println("총점 : " + total);
    		System.out.println("평균 : " + (float)total / set.size());
    		System.out.println("최고점수 : " + Collections.max(values));
    		System.out.println("최저점수 : " + Collections.min(values));
    	}
    
    }
    
    ```

    

  - HashMapEx2

    ```java
    package lab.java.core;
    
    import java.util.HashMap;
    import java.util.Scanner;
    
    public class HashMapEx2 {
    
    	public static void main(String[] args) {
    		
    		HashMap map = new HashMap();
    		map.put("myId", "1234");
    		map.put("asdf", "1111");
    		map.put("asdf", "1234");
    		
    		Scanner s = new Scanner(System.in);
    		
    		while(true) {
    			System.out.println("Id와 password를 입력해주세요.");
    			System.out.print("Id: ");
    			String id = s.nextLine().trim();
    			
    			System.out.print("password: ");
    			String password = s.nextLine().trim();
    			System.out.println();
    			
    			if(!map.containsKey(id)) {
    				System.out.println("입력하신 Id는 존재하지 않습니다. 다시 입력해 주세요");
    				continue;
    			}
    			else {
    				if(!(map.get(id)).equals(password)) {
    					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
    				}
    				else {
    					System.out.println("Id와 비밀번호가 일치합니다.");
    					break;
    				}
    			}
    			
    		}
    	}
    
    }
    
    ```

    

  - HashMapEx3

    ```java
    package lab.java.core;
    
    import java.util.HashMap;
    import java.util.Iterator;
    import java.util.Map;
    import java.util.Set;
    
    public class HashMapEx3 {
    	static HashMap phoneBook = new HashMap();
    
    	public static void main(String[] args) {
    		addPhoneNo("친구", "이자바", "010-111-1111");
    		addPhoneNo("친구", "김자바", "010-222-2222");
    		addPhoneNo("친구", "김자바", "010-333-3333");
    		addPhoneNo("회사", "김대리", "010-444-4444");
    		addPhoneNo("회사", "김대리", "010-555-5555");
    		addPhoneNo("회사", "박대리", "010-666-6666");
    		addPhoneNo("회사", "이과장", "010-777-7777");
    		addPhoneNo("세탁", "010-888-8888");
    		
    		printList();
    	}
    	
    	static void addPhoneNo(String groupName, String name, String tel) {
    		addGroup(groupName);
    		HashMap group = (HashMap)phoneBook.get(groupName);
    		group.put(tel,name);
    	}
    	
    	static void addGroup(String groupName) {
    		if(!phoneBook.containsKey(groupName)) {
    			phoneBook.put(groupName,  new HashMap());
    		}
    	}
    
    	static void addPhoneNo(String name, String tell) {
    		addPhoneNo("기타", name, tell);
    	}
    	
    	//전화번호부 전체를 출력하는 메서드
    	static void printList() {
    		Set set = phoneBook.entrySet();
    		Iterator it = set.iterator();
    		
    		while(it.hasNext()) {
    			Map.Entry e = (Map.Entry)it.next();
    			Set subSet = ((HashMap)e.getValue()).entrySet();
    			Iterator subIt = subSet.iterator();
    			
    			System.out.println(" * " + e.getKey() + " [" + subSet.size() + "]");
    			
    			while(subIt.hasNext()) {
    				Map.Entry subE = (Map.Entry)subIt.next();
    				String telNo = (String)subE.getKey();
    				String name = (String)subE.getValue();
    				System.out.println(name + " " + telNo);
    			}
    			System.out.println();
    		}
    	}
    }
    
    ```

    ```
    //실행 결과
     * 기타 [1]
    세탁 010-888-8888
    
     * 친구 [3]
    이자바 010-111-1111
    김자바 010-222-2222
    김자바 010-333-3333
    
     * 회사 [4]
    이과장 010-777-7777
    김대리 010-444-4444
    김대리 010-555-5555
    박대리 010-666-6666
    
    ```



#### 중간 복습 예제 (도서 조회 시스템)

##### Book.java

```java
package lab.exercise.entity;

public class Book {
	private String title;
	private int price;
	
	public Book(String title, int price) {
		this.title = title;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return String.format("%-20s", "[제목] " + title);
	}
}


```



##### Magazine.java

```java
package lab.exercise.entity;

public class Magazine extends Book {
	
	private String category;
	private String description;

	public Magazine(String title, int price, String category, String description) {
		super(title, price);
		this.category = category;
		this.description = description;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\t[분류] %s\t[가격] %d\t[비고] %s", 
				getCategory(), 
				getPrice(), 
				getDescription()
		);
	}
	
}


```



##### Novel.java

```java
package lab.exercise.entity;

public class Novel extends Book {
	
	private String author;

	public Novel(String title, int price, String author) {
		super(title, price);
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("\t[저자] %s\t[가격] %d", 
				getAuthor(), 
				getPrice()
		);
	}
	
}


```



##### BookBiz.java

```java
package lab.exercise.biz;

import lab.exercise.entity.Magazine;
import lab.exercise.entity.Novel;
import lab.exercise.util.BookUtil;

public class BookBiz {
	private Magazine[] magazines;
	private Novel[] novels;
	
	public BookBiz() {
		magazines = new Magazine[]{
			new Magazine("Cooking Light", 15000, "living, cooking", "America Cooking"),
			new Magazine("Auto Build", 16000, "science, car", "Germany Car")
		};
		
		novels = new Novel[]{
			new Novel("The Confession", 10500, "Grisham, John"),
			new Novel("Les Miserables", 17500, "Hugo, Victor"),
			new Novel("Breakthrough", 47200, "Ifill, Gwen"),
			new Novel("The Racketeer", 38000, "Grisham, John")			
		};
	}
	
	public void printAllBooks() {
		BookUtil.printHeader();
		int index = 1;
		for(Magazine book : magazines) {
			System.out.println(index++ + ". " + book);
		}
		for(Novel book : novels) {
			System.out.println(index++ + ". " + book);
		}
		BookUtil.printTail();
	}
	
	public void printAllMagazines() {
		BookUtil.printHeader();
		int index = 1;
		for(Magazine book : magazines) {
			System.out.println(index++ + ". " + book);
		}
		BookUtil.printTail();
	}
	
	public void printAllNovels() {
		BookUtil.printHeader();
		int index = 1;
		for(Novel book : novels) {
			System.out.println(index++ + ". " + book);
		}
		BookUtil.printTail();
	}
	
	public void printMagazineOneYearSubscription() {
		System.out.println("-------------------------");
		int index = 1;
		for(Magazine book : magazines) {
			System.out.println(index++ + ". " + book.getTitle() + ": " + calculateOneYearSubscriptionPrice(book.getPrice()) + " 원");
		}
		System.out.println("-------------------------");
	}
	
	public void searchNovelByAuthor(String author) {
		BookUtil.printHeader();
		int index = 1;
		for(Novel book : novels) {
//			System.out.println(book.getAuthor());
//			System.out.println(author);
			if(book.getAuthor().equals(author)) 
				System.out.println(index++ + ". " + book);
		}
		BookUtil.printTail();
	}
	
	public void searchNovelByPrice(int minPrice, int maxPrice) {
		BookUtil.printHeader();
		int index = 1;
		for(Novel book : novels) {
			if(minPrice <= book.getPrice() && book.getPrice() <= maxPrice)
				System.out.println(index++ + ". " + book);
		}
		BookUtil.printTail();
	}
	
	private int calculateOneYearSubscriptionPrice(int price) {
		return price * 12;
	}
}



```



##### BookUtil.java

```java
package lab.exercise.util;

import java.util.Scanner;

import java.util.Scanner;

public class BookUtil {
	
	public static String getUserInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static void printHeader() {
		System.out.println("-------------------------------------- 도서 정보 --------------------------------------");
	}
	
	public static void printTail() {
		System.out.println("------------------------------------------------------------------------------------");
	}
}



```



##### BookTest.java

```java
package lab.exercise.test;

import lab.exercise.biz.BookBiz;
import lab.exercise.util.BookUtil;

public class BookTest {

	public static void main(String[] args) {
		
		BookBiz biz = new BookBiz();

		while(true) {
			printMenu();
			System.out.print("## 메뉴 입력 : ");
			int n = -1;
			try {
				n = Integer.parseInt(BookUtil.getUserInput());
			}
			catch(NumberFormatException e) {
				//Todo: 별로 할 일 없음
			}
			finally {
				if(n == 9) {
					System.out.println("------------------------------");
					System.out.println("  프로그램을 종료합니다. Bye~");
					System.out.println("------------------------------");
					break;
				}
				
				switch(n) {
				case 1: biz.printAllBooks();
					break;
					
				case 2: biz.printAllMagazines();
					break;
					
				case 3: biz.printAllNovels();
					break;
					
				case 4: biz.printMagazineOneYearSubscription();
					break;
					
				case 5:
					System.out.print("> 검색할 저자명을 입력하세요 : ");
					
					biz.searchNovelByAuthor(BookUtil.getUserInput());
					break;
					
				case 6:
					try {
						System.out.print("> 검색할 소설 가격의 최소값을 입력하세요: ");
						int min = Integer.parseInt(BookUtil.getUserInput());
						System.out.print("> 검색할 소설 가격의 최대값을 입력하세요: ");
						int max = Integer.parseInt(BookUtil.getUserInput());
						biz.searchNovelByPrice(min, max);
					}
					catch(NumberFormatException e) {
						System.out.println("@ 숫자 형식이 잘못되었습니다.");
					}
					break;
					
				default:
					System.out.println("@ 메뉴번호를 잘못 입력하셨습니다.");	
				}
			}//end of try~catch~finally
		}//end of while
	}//end of main
	
	
	
	public static void printMenu() {
		System.out.println("=== << 도서 정보 프로그램 >> ===");
		System.out.println("1. 전체 도서 정보 조회");
		System.out.println("2. 전체 잡지 조회");
		System.out.println("3. 전체 소설 조회");
		System.out.println("4. 잡지 연간 구독료 조회");
		System.out.println("5. 소설 저자명 검색");
		System.out.println("6. 소설 가격 검색(최소값 ~ 최대값)");
		System.out.println("9. 시스템 종료");
		System.out.println("===========================");
	}

}


```

```
//실행 결과
=== << 도서 정보 프로그램 >> ===
1. 전체 도서 정보 조회
2. 전체 잡지 조회
3. 전체 소설 조회
4. 잡지 연간 구독료 조회
5. 소설 저자명 검색
6. 소설 가격 검색(최소값 ~ 최대값)
9. 시스템 종료
===========================
## 메뉴 입력 : 1
-------------------------------------- 도서 정보 --------------------------------------
1. [제목] Cooking Light  	[분류] living, cooking	[가격] 15000	[비고] America Cooking
2. [제목] Auto Build     	[분류] science, car	[가격] 16000	[비고] Germany Car
3. [제목] The Confession 	[저자] Grisham, John	[가격] 10500
4. [제목] Les Miserables 	[저자] Hugo, Victor	[가격] 17500
5. [제목] Breakthrough   	[저자] Ifill, Gwen	[가격] 47200
6. [제목] The Racketeer  	[저자] Grisham, John	[가격] 38000
------------------------------------------------------------------------------------
=== << 도서 정보 프로그램 >> ===
1. 전체 도서 정보 조회
2. 전체 잡지 조회
3. 전체 소설 조회
4. 잡지 연간 구독료 조회
5. 소설 저자명 검색
6. 소설 가격 검색(최소값 ~ 최대값)
9. 시스템 종료
===========================
## 메뉴 입력 : 2
-------------------------------------- 도서 정보 --------------------------------------
1. [제목] Cooking Light  	[분류] living, cooking	[가격] 15000	[비고] America Cooking
2. [제목] Auto Build     	[분류] science, car	[가격] 16000	[비고] Germany Car
------------------------------------------------------------------------------------
=== << 도서 정보 프로그램 >> ===
1. 전체 도서 정보 조회
2. 전체 잡지 조회
3. 전체 소설 조회
4. 잡지 연간 구독료 조회
5. 소설 저자명 검색
6. 소설 가격 검색(최소값 ~ 최대값)
9. 시스템 종료
===========================
## 메뉴 입력 : 3
-------------------------------------- 도서 정보 --------------------------------------
1. [제목] The Confession 	[저자] Grisham, John	[가격] 10500
2. [제목] Les Miserables 	[저자] Hugo, Victor	[가격] 17500
3. [제목] Breakthrough   	[저자] Ifill, Gwen	[가격] 47200
4. [제목] The Racketeer  	[저자] Grisham, John	[가격] 38000
------------------------------------------------------------------------------------
=== << 도서 정보 프로그램 >> ===
1. 전체 도서 정보 조회
2. 전체 잡지 조회
3. 전체 소설 조회
4. 잡지 연간 구독료 조회
5. 소설 저자명 검색
6. 소설 가격 검색(최소값 ~ 최대값)
9. 시스템 종료
===========================
## 메뉴 입력 : 4
-------------------------
1. Cooking Light: 180000 원
2. Auto Build: 192000 원
-------------------------
=== << 도서 정보 프로그램 >> ===
1. 전체 도서 정보 조회
2. 전체 잡지 조회
3. 전체 소설 조회
4. 잡지 연간 구독료 조회
5. 소설 저자명 검색
6. 소설 가격 검색(최소값 ~ 최대값)
9. 시스템 종료
===========================
## 메뉴 입력 : 5
> 검색할 저자명을 입력하세요 : Grisham, John
-------------------------------------- 도서 정보 --------------------------------------
1. [제목] The Confession 	[저자] Grisham, John	[가격] 10500
2. [제목] The Racketeer  	[저자] Grisham, John	[가격] 38000
------------------------------------------------------------------------------------
=== << 도서 정보 프로그램 >> ===
1. 전체 도서 정보 조회
2. 전체 잡지 조회
3. 전체 소설 조회
4. 잡지 연간 구독료 조회
5. 소설 저자명 검색
6. 소설 가격 검색(최소값 ~ 최대값)
9. 시스템 종료
===========================
## 메뉴 입력 : 6
> 검색할 소설 가격의 최소값을 입력하세요: 15000
> 검색할 소설 가격의 최대값을 입력하세요: 40000
-------------------------------------- 도서 정보 --------------------------------------
1. [제목] Les Miserables 	[저자] Hugo, Victor	[가격] 17500
2. [제목] The Racketeer  	[저자] Grisham, John	[가격] 38000
------------------------------------------------------------------------------------
=== << 도서 정보 프로그램 >> ===
1. 전체 도서 정보 조회
2. 전체 잡지 조회
3. 전체 소설 조회
4. 잡지 연간 구독료 조회
5. 소설 저자명 검색
6. 소설 가격 검색(최소값 ~ 최대값)
9. 시스템 종료
===========================
## 메뉴 입력 : 9
------------------------------
  프로그램을 종료합니다. Bye~
------------------------------


```



#### Calendar 복습

- java.util.Calendar

  ```java
  java.util.Date d = new Date(); 
  //d = new Date(long milisecond)
  
  java.util.Calendar cal = Calendar.getInstance();
  int month = cal.get(Calendar.MONTH) + 1;//현재 월
  
  cal.set(2019, 4, 31); // 2019 5월 31일 설정
  cal.add(Calendar.DATE, 1); // 6월 1일로 만들기
  ```

  

- java.text.SimpleDateFormat

  날짜 데이터 포맷 ex) yyyy-MM-dd hh:mm:ss.SSS

  ```java
  SimpleDateFormat sdf = new SImpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
  Date d = new Date();
  String s = sdf.format(d);
  ```



- java.text.DecimalFormat

  ```java
  double won = 12345.678;
  DecimalFormat df = new DecimalFormat("\u00A4##,###.");
  String s = df.format(won);
  
  // 특정형식으로 문자열화된 데이터를 숫자로 변환하려면
  double d = df.parse(s);
  ```



- java.time (JDK8)

  ```java
  //요일과 월이 0부터가 아닌 1부터 (Calendar와의 차이)
  LocalDate today = LocalDate.now();
  LocalTime time = LocalTime.now();
  ```

  

#### Collection 복습

배열의 경우 생성시에 배열의 크기가 반드시 설정되어야 하고, 저장될 요소의 크기가 정적 인데에 반해 컬렉션의 경우 생성시에 저장될 요소의 크기를 설정하지 않아도 되고, 저장 될 요소의 크기가 동적으로 변경 가능

- List<E> - 저장한 순서 보장, 중복된 객체 저장

  - ArrayList, Vector, LinkedList, Stack 등등

    ```
    add(객체), add(index, 객체)
    clear(), removeAll()
    remove(객체), remove(index)
    size()
    contains()
    get(index)
    ```

  - Iterator<E> 제공

    ```
    while(iterator.hasNext()){
    	Book b = iterator.next();
    }
    ```

  - Enumeration  <- 구 버전, ***deprecated***

    ```
    hasMoreElement(), nextElement()
    ```

  - **Stack** - LIFO(Last In First Out)

    ```java
    Stack st = new Stack();
    //push(), pop(), peek()
    ```

  - **Queue** - FIFO(First In First Out)

    ```java
    Queue q = new LinkedList();
    //offer(), poll(), peek()
    ```

- Set - 순서 보장 안 됨, 중복 객체 저장 불가

  ### 책 봐라 631p~

- Map - Key, Value 쌍으로 존재

  ### 책 봐라 644p~

- Comparator 와 Comparable

  ### 책 봐라 628p~

- ***Arrays***  - **아주 유용한 static class**

- ***Properties*** - **658p~** 

- ***Collections*** - **유용한 static class**





------

### Chapter 12

#### Enum

```java
package lab.java.core;

enum Direction { EAST, SOUTH, WEST, NORTH }

public class EnumEx1 {

	public static void main(String[] args) {
		
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class,  "EAST");
		
		System.out.println("d1="+d1);
		System.out.println("d2="+d2);
		System.out.println("d3="+d3);

		
		System.out.println("d1==d2 ? " + (d1==d2));
		System.out.println("d1==d3 ? " + (d1==d3));
		System.out.println("d1.equals(d3) ? " + d1.equals(d3));
//		System.out.println("d2 > d3 ? " + (d1 > d3));
		System.out.println("d1.compareTo(d3) ? " + (d1.compareTo(d3)));
		System.out.println("d1.compareTo(d2) ? " + (d1.compareTo(d2)));
		
		switch(d1) {
			case EAST:
				System.out.println("The direction is EAST."); break;
			case SOUTH:
				System.out.println("The direction is SOUTH."); break;
			case WEST:
				System.out.println("The direction is WEST."); break;
			case NORTH:
				System.out.println("The direction is NORTH."); break;
			default:
				System.out.println("Invalid direction"); break;
		}
		
		Direction[] dArr = Direction.values();
		for(Direction d : dArr) {
			System.out.printf("%s=%d\n", d.name(), d.ordinal());
		}
	}

}


```



#### 애너테이션(annotation)

> 프로그램의 소스코드 안에 다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함시킨 것이 바로 애너테이션이다. 애너테이션은 주석(comment)처럼 프로그래밍 언어에 영향을 미치지 않으면서도 다른 프로그램에게 유용한 정보를 제공할 수 있다는 장점이 있다.





------

### Chapter 13 - 쓰레드thread

###### Count.java

```java
package lab.java.thread;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;

public class Count extends Panel implements Runnable {

	int num = 0;
	
	public Count() {
		setSize(200, 200);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.setFont(new Font("ArialBlack", Font.BOLD|Font.ITALIC, 75));
		g.drawString(String.valueOf(num), 100, 100);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			num++;
			repaint();
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {}
		}
	}

}


```



###### Snow.java

```java
package lab.java.thread;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;

public class Snow extends Panel implements Runnable {

	int x, y;
	
	public Snow() {
		setSize(200, 200);
		setBackground(Color.BLACK);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(x,  y,  5,  5);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			x = (int)(Math.random()*200);
			y = (int)(Math.random()*200);
			repaint();
			try {
				Thread.sleep(300);
			}
			catch(InterruptedException e) {}
		}
	}

}


```



###### ThreadTest.java

```java
package lab.java.thread;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ThreadTest extends Frame {
	
	Count cnt;
	Snow snow;
	
	public ThreadTest() {
		setSize(600, 200);
		setLayout(new GridLayout(1,3));
		cnt = new Count();
		add(cnt);
		snow = new Snow();
		add(snow);
		setVisible(true);
		
		Thread t = new Thread(cnt);
		t.start();
		Thread s = new Thread(snow);
		s.start();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		
		new ThreadTest();

	}

}


```





------

### Chapter 14 - 람다와 스트림Lambda & stream

### 책 봐라 794p~













------

### Chapter 15 - 입출력 I/O

#### 스트림(stream)

- I/O Stream

  ###### InputStream Ex

  ```java
  package lab.java.core;
  
  import java.io.IOException;
  
  public class InputStreamEx {
  
  	public static void main(String[] args) throws IOException {
  		System.out.println("입력하세요..");
  		int _byte;
  		while((_byte = System.in.read()) != -1) {
  			if(_byte == '\r' || _byte=='\n') continue;
  			if(_byte == 'q' || _byte=='Q') break;
  			char c = (char)_byte;
  			System.out.printf("%s(%d)", c, _byte);
  		}
  	}
  
  }
  
  
  ```

  

  ###### FileInputStream Ex

  ```java
  package lab.java.core;
  
  import java.io.FileInputStream;
  import java.io.FileNotFoundException;
  import java.io.IOException;
  
  public class FileInputStreamEx {
  
  	public static void main(String[] args) {
  		FileInputStream fis = null;
  		byte _read[] = new byte[100];
  		byte console[] = new byte[100];
  		try {
  			System.out.print("파일명 : ");
  			System.in.read(console);
  			String file = new String(console).trim();
  			fis = new FileInputStream(file);
  			fis.read(_read, 0, _read.length);
  			System.out.println(new String(_read).trim());
  		}
  		catch(FileNotFoundException fnfe) {
  			fnfe.printStackTrace();
  		}
  		catch(IOException ie) {
  			ie.printStackTrace();
  		}
  		finally {
  			try {
  				if(fis != null) fis.close();
  			}
  			catch(IOException ioe) {
  				ioe.printStackTrace();
  			}
  		}
  
  	}
  
  }
  
  
  ```

  

  ###### FileOutputStream Ex

  ```java
  package lab.java.core;
  
  import java.io.File;
  import java.io.FileNotFoundException;
  import java.io.FileOutputStream;
  import java.io.IOException;
  
  public class FileOutputStreamEx {
  
  	public static void main(String[] args) {
  		FileOutputStream fos = null;
  		
  		try {
  			File f = new File("c:/testa");
  			
  			if(!f.exists()) 
  				f.mkdirs();
  			
  			fos = new FileOutputStream("c:/testa/fileout.txt");
  			String message = "Hello FileOutputStream!!";;
  			fos.write(message.getBytes());
  			System.out.println("file 쓰기 완료!!!");
  		}
  		catch(FileNotFoundException fnfe) {
  			fnfe.printStackTrace();
  		}
  		catch(IOException ie) {
  			ie.printStackTrace();
  		}
  		finally {
  			try {
  				if(fos != null) fos.close();
  			}
  			catch(IOException ioe) {
  				ioe.printStackTrace();
  			}
  		}
  
  	}
  
  }
  
  ```

  

  ###### FileCopy Ex

  ```java
  package lab.java.core;
  
  import java.io.FileInputStream;
  import java.io.FileNotFoundException;
  import java.io.FileOutputStream;
  import java.io.IOException;
  
  public class FileCopyEx {
  
  	public static void main(String[] args) {
  		FileInputStream fis = null;
  		FileOutputStream fos = null;
  		
  		byte _read[] = new byte[100];
  		byte console[] = new byte[100];
  		try {
  			System.out.print("파일명 : ");
  			System.in.read(console);
  			String file = new String(console).trim();
  			fis = new FileInputStream(file);
  			
  			String prefix = file.substring(0, file.lastIndexOf('.'));
  			String suffix = file.substring(file.lastIndexOf('.'),file.length()); 
  			String dest = prefix + "-복사본" + suffix;
  			fos = new FileOutputStream(dest);
  			
  			int cnt = 0;
  			while( (cnt = fis.read(_read)) != -1) {
  				fos.write(_read, 0, cnt);
  			}
  			fos.flush();
  			
  			System.out.println("파일 복사가 완료 되었습니다!!!");
  			System.out.printf("새로운 파일명 : %s\n", dest);
  			
  		}
  		catch(FileNotFoundException fnfe) {
  			fnfe.printStackTrace();
  		}
  		catch(IOException ie) {
  			ie.printStackTrace();
  		}
  		finally {
  			try {
  				if(fis != null) fis.close();
  				if(fos != null) fos.close();
  			}
  			catch(IOException ioe) {
  				ioe.printStackTrace();
  			}
  		}
  
  	}
  
  }
  
  
  ```

  

  ###### DataStream Ex

  ```java
  package lab.java.core;
  
  import java.io.DataInputStream;
  import java.io.DataOutputStream;
  import java.io.FileInputStream;
  import java.io.FileOutputStream;
  import java.io.IOException;
  
  public class DataStreamEx {
  
  	public static void main(String[] args) {
  		FileInputStream fis = null;
  		DataInputStream dis = null;
  		FileOutputStream fos = null;
  		DataOutputStream dos = null;
  		
  		try {
  			fos = new FileOutputStream("c:/testa/dataOut.txt");
  			dos = new DataOutputStream(fos);
  			dos.writeBoolean(false);;
  			dos.writeInt(20000);
  			dos.writeChar('T');
  			dos.writeDouble(290.45);
  			System.out.println("자바 기본값을 바이트 코드로 저장!!");
  			
  			fis = new FileInputStream("c:/testa/dataOut.txt");
  			dis = new DataInputStream(fis);
  			System.out.println(dis.readBoolean());
  			System.out.println(dis.readInt());
  			System.out.println(dis.readChar());
  			System.out.println(dis.readDouble());
  		}
  		catch(IOException ioe) {
  			ioe.printStackTrace();
  		}
  		finally {
  			try {
  				if(fos != null) fos.close();
  				if(fis != null) fis.close();
  			}
  			catch(IOException ioe) {
  				ioe.printStackTrace();
  			}
  		}
  
  	}
  
  }
  
  ```

  

  

- File 

  ###### File Ex

  ```java
  package lab.java.core;
  
  import java.io.File;
  
  public class FileEx {
  
  	public static void main(String[] args) {
  		// TODO Auto-generated method stub
  		String filePath = "c:\\";
  		File f1 = new File(filePath);
  		String list[] = f1.list();
  		for(int i = 0; i < list.length; i++) {
  			File f2 = new File(filePath, list[i]);
  			if(f2.isDirectory()) {
  				System.out.printf("%s : 디렉토리 \n", list[i]);
  			}
  			else {
  				System.out.printf("%s : 파일(%,dbyte)\n", list[i], f2.length());
  			}
  		}
  	}
      
  }
  
  
  ```



- Serialization  - **직렬화**

  ###### UserInfo.java

  ```java
  package lab.java.serialize;
  
  public class UserInfo implements java.io.Serializable {
  	String name;
  	String password;
  	int age;
  	
  	public UserInfo() {
  		this("Unknown", "111", 0);
  	}
  	
  	public UserInfo(String name, String password, int age) {
  		this.name = name;
  		this.password = password;
  		this.age = age;
  	}
  	
  	public String toString() {
  		return "(" + name + "," + password + "," + age + ")";
  	}
  }
  
  
  ```

  

  ###### SerialEx1.java

  ```java
  package lab.java.serialize;
  
  import java.io.BufferedOutputStream;
  import java.io.FileOutputStream;
  import java.io.IOException;
  import java.io.ObjectOutputStream;
  import java.util.ArrayList;
  
  public class SerialEx1 {
  
  	public static void main(String[] args) {
  		try {
  			String fileName = "UserInfo.ser";
  			FileOutputStream fos = new FileOutputStream(fileName);
  			BufferedOutputStream bos = new BufferedOutputStream(fos);
  			
  			ObjectOutputStream out = new ObjectOutputStream(bos);
  			
  			UserInfo u1 = new UserInfo("JavaMan", "1234", 30);
  			UserInfo u2 = new UserInfo("JavaWoman", "4321", 26);
  			
  			ArrayList<UserInfo> list = new ArrayList<>();
  			list.add(u1);
  			list.add(u2);
  			
  			//객체를 직렬화한다.
  			out.writeObject(u1);
  			out.writeObject(u2);
  			out.writeObject(list);
  			out.close();
  			System.out.println("직렬화가 끝났습니다.");
  		}
  		catch(IOException e) {
  			e.printStackTrace();
  		}
  
  	}
  
  }
  
  
  ```

  

  ###### SerialEx2.java

  ```java
  package lab.java.serialize;
  
  import java.io.BufferedInputStream;
  import java.io.FileInputStream;
  import java.io.ObjectInputStream;
  import java.util.ArrayList;
  
  public class SerialEx2 {
  
  	public static void main(String[] args) {
  		try {
  			String fileName = "UserInfo.ser";
  			FileInputStream fis = new FileInputStream(fileName);
  			BufferedInputStream bis = new BufferedInputStream(fis);
  			
  			ObjectInputStream in = new ObjectInputStream(bis);
  			
  			//객체를 읽을 때는 출력한 순서와 일치해야한다.
  			UserInfo u1 = (UserInfo)in.readObject();
  			UserInfo u2 = (UserInfo)in.readObject();
  			ArrayList list = (ArrayList)in.readObject();
  			
  			System.out.println(u1);
  			System.out.println(u2);
  			System.out.println(list);
  			in.close();
  		}
  		catch (Exception e) {
  			e.printStackTrace();
  		}
  
  	}
  
  }
  
  
  ```

  ```
  //실행 결과
  (JavaMan,1234,30)
  (JavaWoman,4321,26)
  [(JavaMan,1234,30), (JavaWoman,4321,26)]
  
  
  ```

  

- RandomAccessFile

  ###### RandomAccessFileEx.java

  ```java
  package lab.java.core;
  
  import java.io.IOException;
  import java.io.RandomAccessFile;
  
  public class RandomAccessFileEx {
  
  	public static void main(String[] args) {
  		RandomAccessFile ra = null;
  		
  		try {
  			ra = new RandomAccessFile("c:/testa/random.txt", "rw");
  			String receive = "hello";
  			ra.seek(ra.length()); //0 offset
  			ra.write(receive.getBytes());
  //			byte[] buf = new byte[(int) ra.length()];
  			byte[] buf = new byte[100];
  			ra.seek(0);
  			ra.read(buf);
  			System.out.print(" 처음 읽은 내용 : ");
  			System.out.println(new String(buf));
  			ra.seek(0);
  			receive = "안녕하세요?";
  			ra.write(receive.getBytes());
  			ra.seek(0);
  			ra.read(buf);
  			System.out.print(" 다시 읽은 내용 : ");
  			System.out.println(new String(buf));
  		}
  		catch(IOException ioe) {
  			ioe.printStackTrace();
  		}
  		finally {
  			try {
  				if(ra != null) ra.close();
  			}
  			catch(IOException ioe) {
  				ioe.printStackTrace();
  			}
  		}
  
  	}
  
  }
  
  
  ```

  

  

- ***PipedReader / PipedWriter  + Thread 예제***

  ###### PipedReaderWriter.java

  ```java
  package lab.java.core;
  
  import java.io.IOException;
  import java.io.PipedReader;
  import java.io.PipedWriter;
  import java.io.StringWriter;
  
  public class PipedReaderWriter {
  	
  	public static void main(String[] args) {
  		InputThread inThread = new InputThread("InputThread");
  		OutputThread outThread = new OutputThread("OutputThread");
  		
  		//PipedReader와 PipedWriter를 연결한다.
  		inThread.connect(outThread.getOutput());
  		
  		inThread.start();
  		outThread.start();
  	}
  }
  
  
  class InputThread extends Thread {
  	PipedReader input = new PipedReader();
  	StringWriter sw = new StringWriter();
  	
  	InputThread(String name) {
  		super(name);	// Thread(String name)
  	}
  	
  	public void run() {
  		try {
  			int data = 0;
  			while( (data = input.read()) != -1) {
  				sw.write(data);
  			}
  			System.out.println(getName() + " received : " + sw.toString());
  		}
  		catch(IOException e) {
  			e.printStackTrace();
  		}
  	}
  	
  	public PipedReader getInput() {
  		return input;
  	}
  	
  	public void connect(PipedWriter output) {
  		try {
  			input.connect(output);
  		}
  		catch(IOException e) {
  			e.printStackTrace();
  		}
  	}
  }
  
  
  class OutputThread extends Thread {
  	PipedWriter output = new PipedWriter();
  	
  	OutputThread(String name) {
  		super(name);
  	}
  	
  	public void run() {
  		try {
  			String msg = "Hello";
  			System.out.println(getName() + " sent : " + msg);
  			output.write(msg);;
  			output.close();
  		}
  		catch(IOException e) {
  			e.printStackTrace();
  		}
  	}
  	
  	public PipedWriter getOutput() {
  		return output;
  	}
  	
  	public void connect(PipedReader input) {
  		try {
  			output.connect(input);
  		}
  		catch(IOException e) {
  			e.printStackTrace();
  		}
  	}
  }
  
  
  ```

  ```
  //실행 결과
  OutputThread sent : Hello
  InputThread received : Hello
  
  ```

  

  



# 테스트으!!!

```
	1. java 파일을 컴파일하는 명령어는 무엇인가
정답	4 / 입력 답안 : 4
1) vbc.exe

2) cpp.exe

3) java.exe

4) javac.exe

2. 다음 중 변수를 올바르게 초기화 한 것은?
정답	4 / 입력 답안 : 4
1) byte b = 256;

2) char c = " ";

3) float f = 3.14 ;

4) double d = 1.4e3f;

3. 다음 중 에러가 나는 문장은 무엇인가?
정답	1 / 입력 답안 : 1
1) System.out.println(3 && 4);

2) System.out.println(true && false);

3) System.out.println(true & false);

4) System.out.println(3 & 4);

4. 반복문을 종료할 때 사용되는 예약어는?
정답	2 / 입력 답안 : 2
1) throw

2) break

3) return

4) void

5. 다음의 연산 결과를 저장할 result 변수에 선언할 적절한 타입 고르시오 [ ] result = (3>4)? 99.9: 90;
정답	3 / 입력 답안 : 3
1) int

2) float

3) double

4) String

6. 다음은 Java의 배열에 대한 설명이다. 틀린 것을 고르시오.
정답	1 / 입력 답안 : 1
1) 배열의 인덱스는 1 부터 시작한다.

2) 배열의 인덱스로 음의 값을 사용하면 ArrayIndexOutofBoundsException이 발생한다.

3) 배열의 길이를 알고자 할 때는 length 라는 속성을 사용한다.

4) 배열이 만들어질 때 부여된 크기는 변경 불가하다.

7. 아래 문장을 실행한 결과는? public static void main(String args[]){ int cnt = 0; for(int i=0;i<3;i++){ switch(i){ case 0 : cnt++; case 1 : cnt++; break; case 2 : cnt++; } } System.out.println(cnt); }
정답	4 / 입력 답안 : 4
1) 1

2) 2

3) 3

4) 4

Java의 OOP 구문
1. 다음 중 접근 제어자(access modifier)가 아닌 것은?
정답	4 / 입력 답안 : 4
1) private

2) protected

3) public

4) static

2. 다음 중 객체지향 언어의 주요 특징이 아닌 것은 ?
정답	3 / 입력 답안 : 3
1) 상속성

2) 캡슐화

3) 절차적

4) 다형성

3. 상속 불가능한 클래스 선언 또는 변경 불가능한 속성 멤버 변수를 정의할 때 사용하는 키워드를 고르시오
정답	2 / 입력 답안 : 2
1) abstract

2) final

3) static

4) protected

4. 다음 코드처럼 부모클래스의 메소드를 자식 클래스에서 다시 작성하는 것을 무엇이라고 하는가 ? class Animal{ void eat(){} } class Human extends Animal{ void eat(){} }
정답	2 / 입력 답안 : 2
1) 오버로드(overload)

2) 오버라이드(override)

3) abstract

4) final

5. 다음 중 예외처리문으로 옳은 것은?
정답	1 / 입력 답안 : 1
1) try catch finally

2) try except finally

3) try catch end

4) try except else

6. 메소드 오버로딩에 대한 설명으로 틀린 것은 무엇인가?
정답	2 / 입력 답안 : 2
1) 동일한 이름의 메소드를 여러 개 선언하는 것을 말한다.

2) 반드시 리턴 타입이 달라야 한다.

3) 매개 변수의 타입 또는 개수 또는 순서중 최소 하나를 다르게 선언해야 한다.

4) 매개 값의 타입 및 수에 따라 호출될 메소드가 선택된다.

7. 다음 중 상속에 대해 옳지 않은 것은?
정답	3 / 입력 답안 : 3
1) 기존 클래스를 재사용해서 새로운 클래스를 작성하는 것이다.

2) 자식 클래스는 부모클래스의 생성자, 초기화 블록을 제외한 private 를 제외한 모든 멤버를 상속받는다.

3) 다중 상속을 허용함으로써, 상속의 다양성을 갖는다.

4) 부모가 없는 클래스는 자동적으로 Object 클래스를 상속받는다.

8. 클래스명으로 호출 가능한 메서드를 정의하려 한다. 이 때 사용되는 제어자를 고르시오.
정답	3 / 입력 답안 : 3
1) abstract

2) final

3) static

4) sychronized

9. 다음은 생성자 메서드에 대한 설명글이다. 틀린 것을 고르시오.
정답	3 / 입력 답안 : 4
1) 메서드명이 클래스명과 동일해야 한다.

2) 여러 개로 오버로딩 가능하다.

3) 리턴타입은 void로 선언한다

4) 접근제어자를 반드시 선언해야 한다.

10. 인터페이스에 대한 설명 중 틀린 것은?
정답	4 / 입력 답안 : 4
1) 인터페이스는 모든 메소드가 abstract 메소드이다.

2) 인터페이스에서 선언된 메소드에 대한 표준화된 개발이 가능하다.

3) 인터페이스는 선언부와 구현부를 분리하여 독립적인 프로그래밍이 가능하다.

4) 인터페이스는 객체 생성을 할 수 없고, Reference 변수의 타입으로도 사용할 수 없다.

11. 다음 코드의 method()에서 로컬변수 name이 아닌 멤버변수 name을 출력하기위해 [ ]안의 키워드를 고르시오 class Student { String name; public void method(String name){ System.out.println(name); System.out.println([ ].name); } }
정답	3 / 입력 답안 : 3
1) self

2) super

3) this

4) Student

Java의 기본 API 활용
1. Java의 모든 클래스를 파생시키는 가장 상위의 클래스 이름은 무엇인가?
정답	2 / 입력 답안 : 2
1) java.util.Objects

2) java.lang.Object

3) java.lang.String

4) java.util.Scanner

2. 외부 패키지나 클래스를 소스에 포함시키고자 할 때, 사용하는 문장은?
정답	2 / 입력 답안 : 2
1) package

2) import

3) include

4) export

3. 중복되지 않은 데이터들을 저장하려 합니다. 적당한 컬렉션 클래스를 고르시오
정답	3 / 입력 답안 : 3
1) ArrayList

2) Stack

3) TreeSet

4) HashMap

4. key 와 value 형식의 데이터를 저장할 수 있는 Collection 객체는?
정답	4 / 입력 답안 : 4
1) ArrayList

2) Deque

3) TreeSet

4) HashMap

5. 다음 code의 실행 결과는? String str1 = new String ("test"); String str2 = new String ("test"); System.out.print ( str1.equals(str2) ); System.out.print(str1 == str2);
정답	2 / 입력 답안 : 2
1) true true

2) true false

3) false true

4) false false

6. 다음 중 Stream에 대한 설명 중 틀린 것은?
정답	2 / 입력 답안 : 2
1) Stream이란 자료의 입출력을 도와주는 중간 매개체로, 데이터를 읽고 쓰기 위한 공통된 방법을 제공한다.

2) Stream은 양방향 통신으로, 입력용과 출력용 Stream을 공용으로 사용한다.

3) 문자 단위로 파일을 읽고 쓸 때 File Reader와 FileWriter를 사용한다.

4) 바이트 단위로 파일을 일고 쓸 때 FileInputStream과 FileOutputStream을 사용한다.

7. 기본형 데이터 타입과 래퍼(Wrapper)클래스타입이 틀린 것을 고르시오
정답	1 / 입력 답안 : 1
1) char-CharSequence

2) int-Integer

3) float-Float

4) char-Character








수행평가1 ]
금액을 입력받으면 4칙연산을 이용해서 만원, 천원, 백원, 십원 각각의 개수를 출력하는 테스트 코드를 main 메소드에 정의하시오

입력 예 : 
금액 입력 => 65430

출력 예 :
만원 : 6
천원 : 5
백원 : 4
십원 : 3


수행평가2 ] 쇼핑몰에서 판매할 상품의 속성과 행위를 추상화하여 Product 클래스를 작성하시오
클래스명 : exercise.class1.Product, ProductTest

Product클래스의 멤버들은 모두 클래스내부에서만 읽기, 쓰기, 변경 가능하도록 접근제어자를 선언합니다. 
Product 클래스의 멤버 : 
productCode(문자열), productName(문자열), price(정수), discountRate(정수)

Product 클래스의 생성자 두개 만들기 : 
상품코드, 상품이름, 가격을 매개변수로 선언된 생성자
상품코드, 상품이름, 가격, 할인율을 매개변수로 선언된 생성자

Product 클래스의 멤버 메서드 : 
할인률 변경하는 메서드 changeDiscountRate()는 새로운 할인률을 매개변수로 받아서 상품플래스의 멤버에 저장합니다
판매가를 계산하는 calculatePrice()는 할인율을 고려하여 계산된 판매가를 정수로 반환합니다.

샘플 데이터 : [상품코드 상품명 정가 할인율]
[PRD001 커피믹스 12000 10]
[PRD002 종이컵 3000]



수행평가3] 마트에 가서 카트에 물건을 담고, 카트에 담겨진 물건의 총 구매금액을 계산하는 프로그램 구현
exercise.collection.Product클래스 :
Product클래스의 멤버들은 모두 클래스내부에서만 읽기, 쓰기, 변경 가능하도록 접근제어자를 선언합니다. 
Product 클래스의 멤버 - productName(문자열), price(정수) 
productName과 price를 초기화하는 생성자 메서드
productName과 price를 setter/getter메서드 

멤버필드는 
exercise.collection.Mart 클래스 :
인스턴스 변수로 Map 객체를 선언하고, 생성자에서 HashMap 객체를 생성한다
Map은 Product를 Key로 하고, 구매한 개수를 value로 갖는다.
addCart() : Product 객체를 생성하여 cart에 담는다
calculate() : Cart에 담겨진 Product를 꺼내어, 품목명과 단가, 개수, 구매금액(단가*개수)를 출력한다.
전체 구매 금액을 계산하여 출력한다.

실행 결과 예시 :
1. 품목명 : 배, 단가: 200원, 갯수 :3개, 구매금액 : 600원
2. 품목명 : 사과, 단가: 100원, 갯수 :2개, 구매금액 : 200원
3. 품목명 : 딸기, 단가: 50원, 갯수 :5개, 구매금액 : 250원

## 전체 구매 금액 : 1050 원
평가기준
수행평가1 평가기준]
1. 적절한 연산자를 사용해야 합니다.
2. 반복문을 사용하여 처리 효율을 높여야 합니다.

수행평가2 평가기준]
1. 클래스의 멤버필드의 접근제어자를 요구사항대로 선언했는지 평가합니다.
2. 생성자의 인자로 받은 값을 클래스의 멤버필드에 초기화하는 코드가 적합한지 평가합니다.
3. 리턴타입이 있는 메서드와 없는 메서드를 올바르게 구현했는지 평가합니다.

수행평가3 평가기준]
1. 요구사항에 맞는 Collection 클래스를 선택했는지 평가합니다.
2. Collection 클래스에 객체를 담고, 꺼내는 코드가 적절한지 평가합니다.

```







