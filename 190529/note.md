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

  - Enumeration  <- 구 버전, **deprecated**

    ```
    hasMoreElement(), nextElement()
    ```

    

- Set - 순서 보장 안 됨, 중복 객체 저장 불가

  

- Map - Key, Value 쌍으로 존재

  

