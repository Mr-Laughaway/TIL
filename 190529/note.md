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





---

### Chapter 14 - 람다와 스트림Lambda & stream

### 책 봐라 794p~













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

  

-  RandomAccessFile

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

