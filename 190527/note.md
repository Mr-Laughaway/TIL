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

