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





### 10장

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

