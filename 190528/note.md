### Chapter 9 정리

####  java.lang.Object

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

    - 

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





