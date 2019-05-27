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

     

