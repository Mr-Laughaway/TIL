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





---

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







---

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

  

