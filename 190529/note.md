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

  

  