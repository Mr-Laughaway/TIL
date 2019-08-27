## Spark

https://wikidocs.net/book/2350



### Scala

스칼라는 자바 가상 머신(JVM) 에서 동작하는 JVML(Java Virtual Machine Language) 언어이다. 자바 가상 머신 위에서 동작하는 언어들로 **sclala**, **kotlin**, **Groovy** 등이 있다.  자바 가상 머신 위에서 동작하기 때문에 자바의 모든 라이브러리를 사용할 수 있다. 스칼라는 스칼라 컴파일러를 통해 스칼라 코드를 바이트 코드로 변환하고, 바이트 코드는 JVM 상에서 자바와 동일하게 실행 된다.

- Hadoop 기반의 데이터 인프라는 자바 언어를 통해 MapReduce 연산 그리고 알고리즘을 구현. 그런데 이 때 자바는 코드가 너무 길어 생상성 그리고 가독성이 매우 떨어진다.
- 스칼라는 ***적은 양의 코드로 방대한 규모의 시스템을 작성할 수 있다.***
- 스칼라는 객체지향 프로그래밍과 함수형 프로그래밍을 모두 완벽하게 지원하는 언어
  - 스칼라에서는 모든 것이 객체이며 함수가 first object 이다.
  - 함수를 마치 하나의 값으로 취급하여 이를 변수 또는 파라미터로 넘길 수 있다
  - 모든 것을 함수로 해결하면 의도하지 않은 동작(side effect)이 발생할 일이 없고, 한 번 검증된 함수는 신뢰할 수 있기 때문에 버그가 줄어드는 효과가 있다.
  - ```Immutable``` 변수는 문제를 단순화시켜주기 때문에 데이터 공유, 병렬처리에 강하다.

- 스칼라 언어의 특성
  - 코드의 직관성과 신축성
  - 풍부한 표현식과 연산자
  - 간결함
    - **타입 추론**
    - 함수 리터럴(literal)
  - 자바와의 혼용 가능 객체지향 + 함수형 언어
    - 자바 라이브러리 재사용 가능
    - 자바 도구를 재사용 가능
    - 성능의 손실 없이 사용 가능
    - 스칼라에서는 모든 것이 객체
  - 동시성에 강한 언어
    - 스칼라에서는 많은 부분이 변경불가능 속성을 가지게끔 되어 있다.
    - 아카(Akka) 라이브러리 - 동시성 프로그래밍에서 뛰어난 액터 모델을 이용
    - **액터 모델**은 각각의 액터가 서로 간의 메시지를  통해서만 의사소통을 하고, 액터를 이루는 각종 변수나 속성은 서로 공유하지 않는다.
  - expression(결과를 반환하는 문장) 중심 언어
  - 필요할 때 ```implicit``` 예약어를 사용하면 명시적인 표현을 감춰버릴 수 있다.
  - ...
  - ...
  - 익명 함수
  - 고차 함수



- 설치

  - Java 8 JDK install

  - Scalar install

    - https://www.scala-lang.org/download/
    - Scalar IDE - IntelliJ, or SBT, Scala's build tool. Http://scala-ide.org

  - 이클립스는 마켓플레이스에서 스칼라 IDE를 설치하면 스칼라 프로젝트를 생성할 수 있다

    Help -> Eclipse Marketplace > scala ide



- 실습

  - 컴파일 해서 쓰기

    ```bash
    #Ex1.scala
    object Ex1 {
        def main(args: Array[String]): Unit = {
            println("Hello, Scala!")
        }
    }
    
    c:> scalac Ex1.scala
    c:> scala Ex1
    Hello, Scala!
    ```

    

  - 기본

    ```scala
    //------------------------------------------
    scala> var a = 1
    scala> val a = 1   // 불변
    scala> val b:Double = 1.3  //타입 명시
    
    scala> val name = "David"
    scala> println(s"Hello! ${name}")
    Hello! David
    
    
    //------------------------------------------
    scala> println("${1 + 1}")
    ${1 + 1}
    
    scala> println("s${1 + 1}")
    2
    
    
    //------------------------------------------
    scala> val height:Double = 182.3
    scala> val name = "James"
    scala> println(f"${name}%s is $height%2.2f centimeters tall"})
    James is 182.30 centimeters tall
    
    
    //------------------------------------------
    scala> s"가\n나"
    가
    나
    
    scala> raw("가\n나")
    가\n나
    
    
    //------------------------------------------
    scala> var str3 = s"println $str1"
    scala> println(str3)
    println aaa
    
    scala> println(s"2 * 3 \ ${2 * 3}")
    2 * 3 = 6
    
    scala> def minus(x:Int, y:Int) = x - y
    scala> println(s"$Math.pow(2,3)}")
    8.0
    
    scala> println(s"${minus(2,3)}")
    -1
    
    ```

    

  - 반복문

    ```zipWIthIndex``` <- ***특이한거***

    ```scala
    // to 는 10 까지
    for(x <- 1 to 10) {
        println(x)
    }
    
    // until 은 10 전까지
    for(x <- 1 until 10) {
        println(x)
    }
    
    // 조건이 있는 반복문
    // error
    for(i <- 10) if(i % 2 == 0) {
        println(i)
    }
    
    // ok
    for(i <- 1 to 10) if(i % 2 == 0) {
        println(i)
    }
    
    
    // zipWithIndex
    val lst = (10 to 100 by 10).toList
    for( (num, index) <- lst.zipWithIndex ) {
        println(s"$index : $num")
    }
    0 : 10
    1 : 20
    2 : 30
    3 : 40
    4 : 50
    5 : 60
    6 : 70
    7 : 80
    8 : 90
    9 : 100
    
    
    // 이중 for 문
    for( x <-1 until 5; y <- 1 until 5) {
        print(x + " * " + y + " = " + x*y + "|")
    }
    1 * 1 = 1|1 * 2 = 2|1 * 3 = 3|1 * 4 = 4|2 * 1 = 2|2 * 2 = 4|2 * 3 = 6|2 * 4 = 8|3 * 1 = 3|3 * 2 = 6|3 * 3 = 9|3 * 4 = 12|4 * 1 = 4|4 * 2 = 8|4 * 3 = 12|4 * 4 = 16|
    ```

    

  - 함수 정의

    ```scala
    //
    object Ex {
        def main(args: Array[String]): Unit = {
            println("반환받은 값: " + name())
        }
        def name () = {
            val a = 10
            a
        }
    }
    
    //
    def name () : Int = {
        val a = 10
        return a
    }
    println(name())
    
    
    // 리턴을 명시할 경우 타입을 꼭 써 줘야한다
    def name3() = {
        val a = 10
        return a
    }
    
    
    // 
    scala> scala> def addOne(m: Int): Int = m + 1
    scala> val three = addOne(2)
    scala> def three() = 1 + 2
    scala> three()
    scala> three
    ```

    

  - 익명 함수

    _: ***만능???***

    ```scala
    (x: Int) => x + 1
    //인터프리터가 부여한 이름(1)
    
    
    def adder(m:Int, n:Int) = m + n
    val add2 = adder(2, _:Int)
    print(add2(3))
    ```

    

  - 커리 함수 (Curried functions)

    함수의 인자 중 일부를 적용하고, 나머지는 나중에 적용하게 남겨두는 경우

    ```scala
    object Ex {
        def main(args: Array[String]): Unit = {
            val thisYear = 2019
            val fixedValueFunction = go(thisYear, _:String)
            fixedValueFunction("test1")
            fixedValueFunction("test2")
            fixedValueFunction("test3")
        }
        def go(thisYear:Int, string:String) = {
            println(string + ":" + thisYear)
        }
    }
    
    test1:2019
    test2:2019
    test3:2019
    ```

    

  - 변수에 함수 넣기

    ```scala
    //변수에 함수 넣기
    //명시적으로 함수가 기대되지 않는 곳에서 = 연산자를 이용해 
    //매개변수가 필요한 함수를 대입하였을 때 에러가 발생
    // - 객체화 되어 있지 않는 함수를 바로 val 에 대입하면 에러발생
    
    
    object Ex {
        def main(args: Array[String]): Unit = {
            val g = f _ // _를 넣었더니 에러가 안 나
            println(f(1))
        }
        def f(i: Int) = i
    }
    
    def f(i: Int) = i
    val g = f // 에러 발생
    val g:(Int => Int) = f; // 에러 발생하지 않음
    val g = f _ // 에러 발생하지 않음
    ```

    

  - 재귀함수

    ```scala
    object Ex {
        def main(args: Array[String]) : Unit = {
            val result = calc(x => x * x, 2, 5)
            println(result)
        }
        def calc(f: Int => Int, start:Int, end:Int) = {
            def loop(index:Int, sum:Int): Int = {
                if(index > end ) sum
                else loop(index + 1, f(index) + sum)
            }
            loop(start, 0) // 루프를 최초 호출
        }
    }
    
    54
    ```

    

  - 매개변수가 여러개인 함수

    ```scala
    object Ex {
        def main(args: Array[String]): Unit = {
            printlnStrings("str1", "str2", "str3")
            printlnStrings()
        }
        def printlnStrings(args: String*) =  {
            for(arg <- args) {
                println(arg)
            }
        }
    }
    
    str1
    str2
    str3
    
    ```

    

  - 함수 기본 값

    ```scala
    def default(a:Int = 4, b:Int = 5) : Int = a + b
    println("기본값은 " + default())
    println("기본값은 " + default(11, 6))
    
    �⺻���� 9
    �⺻���� 17
    ```

    

  - ***apply***

    ```apply```는 매번 메서드 이름을 적는 것을 피하기 위해 사용. 변수를 받아 함수에 적용시켜 결과를 만들어내는 설정자와 같은 역할을 한다. ```apply()```를 이용하면 생성자처럼 초기화하거나 클래스 안에 특정한 메서드를 기본 메서드로 지정하는 것을 편하게 할 수 있다.

    ```scala
    class SomeClass {
        def apply(m:Int) = method(m)
        def method(i:Int) =  i + i
        def method2(s:String) = 5
    }
    
    val something = new SomeClass
    println(something(2))
    println(something.method2("하"))
    
    4
    5
    ```

    

  - **암묵적 형변환**

    ```Implicit```는 에러는 바로 내지 않고 해당하는 함수가 있으면 그것을 사용해서 암묵적으로 형 변환을 도와주어 함수의 활용도를 높입니다.

    예1)

    ```scala
    case class Person(name:String) 
    implicit def stringToPerson(name:String) : Person = Person(name)
    def sayHello(p:Person): Unit = {
        print("Hello, " + p.name)
    }
    sayHello("Korea")
    
    warning: there was one feature warning; re-run with -feature for details
    Hello, Korea
    ```

    예2)

    ```scala
    // 일반적인 상황
    def doubleToInt(d:Double) = d.toInt
    val x:Int = doubleToInt(18.0)
    print(x)
    
    
    // 잘못 사용된 상황 (에러)
    def doubleToInt(d:Double) = d.toInt
    val x:Int = 18.0
    
    c:\workspace_scala\tempCodeRunnerFile.scala:2: error: type mismatch;
     found   : Double(18.0)
     required: Int
    val x:Int = 18.0
    
    
    //Implicit를 사용한 상황 (warning 이지만 괜찮아)
    implicit def doubleToInt(d:Double) = d.toInt
    val x:Int = 18.0
    
    warning: there was one feature warning; re-run with -feature for details
    ```

  

  - 스칼라에서는 public class 대신 object 예약어를 통해 처음부터 메모리에 객체를 생성하고 컴ㄹ파일러는 객체에 main 이라는 이름이 있으며 main을 프로그램의 시작점으로 컴파일 한다.

    ```scala
    object Ex4 {
    	def main(args:Array[String]): Unit = {
            ...
        }
    }
    ```

    

  - ```case class``` 케이스 클래스는 자동으로 멤버 변수를 만들어주며, 외부

    ```scala
    case class Fruit2(name:String)
     
    val apple = new Fruit2("apple")
    println(apple.name)
    
    val apple2 = new Fruit2("apple")
    println(apple2.name)
    
    println(apple2.equals(apple))
    println(apple.hashCode)
    println(apple2.hashCode)
    println(apple.toString)
    
    apple
    apple
    true
    1789182185
    1789182185
    Fruit2(apple)
    ```

    

  - **클래스** 생성자

    ***스칼라에서는 생성자가 특별한 메소드로 따로 존재하지 않는다.*** 클래스 몸체에서 메소드 정의 부분 밖에 있는 모든 코드가 생성자 코드가 된다.

    ```scala
    class Calculator(brand:String) {
        /**
        * 생성자
        */
        val color:String = if(brand == "TI") {
            "blue"
        } else if (brand == "HP") {
            "black"
        } else {
            "white"
        }
    
        //인스턴스 메소드
        def add(m:Int, n:Int): Int = m + n
    }
    
    val calc = new Calculator("HP")
    print(calc.color)
    
    black
    ```

    

  - 상속

    자식 클래스는 부모 클래스가 가진 모든 기능을 가진다

    ``` scala
    object Ex {
        def main(args: Array[String]): Unit = {
            val richUser = new PaidUser("LeeMongRyong", 20, 'M', 10000)
            richUser.sayName
            richUser.showMoney
        } 
    }
    
    class User(name:String, age:Int, sex:Char) {
        var sayName = pringln("My name is "  + name)
    }
    
    //.........다 못침
    ```

    

  - 상속과 메소드 Overloading

    ```scala
    class Calculator(brand:String) {
        /**
        * 생성자
        */
        val color:String = if(brand == "TI") {
            "blue"
        } else if (brand == "HP") {
            "black"
        } else {
            "white"
        }
    
        //인스턴스 메소드
        def add(m:Int, n:Int): Int = m + n
    }
    
    //상속
    class ScientificCalculator(brand:String) extends Calculator(brand) {
        def lg(m:Double, base:Double) = math.log(m) / math.log(base)
    }
    
    //메소드 중복정의
    class EvenMoreScientificCalculator(brand:String) extends ScientificCalculator(brand) {
    
        def log(m:Int): Double = log(m, math.exp(1))
    }
    
    
    ```

  

  - 추상 클래스

    추상클래스는 메소드 정의는 잇지만 구현은 없는 클래스이다.  대신 이를 상속한 하위클래스에서 메소드를 구현하게 된다. 추상 클래스의 인스턴스를 만들 수는 없다.

    ```scala
    abstract class Shape {
        def getArea():Int //하위 클래스에서 이 메소드를 정의해야만 한다
    }
    
    class Circle(r:Int) extends Shape {
        def getArea():Int = {
            r * r * 3
        }
    }
    
    //val s = new Shape //에러 발생
    val c = new Circle(2);
    print(c.getArea)
    
    12
    ```

  

  - ***트레잇(trait)***

    - 특성: 하나의 완성된 기능이라기보다는 어떠한 객체에 추가될 수 있는 부가적인 하나의 특성
    - 클래스의 부가적인 특성으로 동작, 자체로 인스턴스화는 가능하지 않다.
    - 다른 클래스가 확장(즉, 상속)하거나 섞어 넣을 수 있는***(이를 믹스인Mix in 이라 한다)*** 필드와 동작의 모음이다.
    - 클래스는 여러 트레잇을 with 키워드를 사용해 확장할 수 있다.
    - 자유롭게 변수를 선언하고 로직을 구현하는 것이 가능

    - 다중상속 여부

      , 로 구분 - ***Error***

      ```scala
      trait Car {
          val brand:String
      }
      
      trait Shiny {
          val shineRefraction:Int
      }
      
      /*
      class BMW extends Car {
          val brand = "BMW"
      }
      */
      
      class BMW extends Car, Shine { // error? -> error
          val brand = "BMW"
      }
      ```

      with 로 구분 - ***OK***

      ```scala
      trait Car {
          val brand:String
      }
      
      trait Shiny {
          val shineRefraction:Int
      }
      
      /*
      class BMW extends Car {
          val brand = "BMW"
      }
      */
      
      class BMW extends Car with Shiny {
          val brand = "BMW"
          val shineRefraction = 12
      }
      
      val bmw = new BMW()
      println(bmw.brand)
      println(bmw.shineRefraction)
      
      BMW
      12
      ```

    - 트레잇 쌓기

      추상 클래스 여러개를 한 클래스에서 상속 받을 경우 다아몬드 상속의 문제가 발생할 경우, 최종적으로 상속받는 클래스의 메서드가 수행되도록 ***override*** 예약어와 함께 적당한 상속 관계를 만들어줄 수 있다.

      ```scala
      abstract class Robot {
          def shoot = "Pyong Pyong"
      }
      
      trait M16 extends Robot {
          override def shoot = "BBangya"
      }
      
      trait Bazooka extends Robot {
          override def shoot = "BBuang BBuang"
      }
      
      trait Daepodong extends Robot {
          override def shoot = "Kwarrrrrrrrr"
      }
      
      class Mazinga extends Robot with M16 with Bazooka with Daepodong
      
      val robot = new Mazinga
      println(robot.shoot)
      
      Kwarrrrrrrrr
      ```

    - 모두의 기능을 실행하도록 사위 클래스 super를 호출해서 해당하는 메서드를 실행되게 할 수 있다.

      ```scala
      abstract class AnotherRobot {
          def shoot = "Pyong Pyong"
      }
      
      trait AnotherM16 extends AnotherRobot {
          override def shoot = super.shoot + " BBangya"
      }
      
      trait AnotherBazooka extends AnotherRobot {
          override def shoot = super.shoot + " BBuang BBuang"
      }
      
      trait AnotherDaepodong extends AnotherRobot {
          override def shoot = super.shoot + " Kwarrrrrrrrr"
      }
      
      class AnotherMazinga extends AnotherRobot 
          with AnotherM16 
          with AnotherBazooka 
          with AnotherDaepodong
      
      val anotherRobot = new AnotherMazinga
      println(anotherRobot.shoot)
      
      //결과
      Pyong Pyong BBangya BBuang BBuang Kwarrrrrrrrr
      ```

    

  - Companion Object

    

  - 케이스 클래스

    케이스 클래스는 패턴 매치를 위해 최적화된 특별한 클래스로서 case class 키워드를 사용해서 생성하며 컴패니언 객체와 객체 생성을 위한 apply(), 패턴 매치를 위한 unapply()가 자동으로 생성됨

    ```scala
    case class Person(name:String, age:Int) 
    var papa = Person("papa", 100)
    ```

    

  - 패턴 매치

    - 기본형이 아닌 튜플을 사용하는 경우 튜플 형식으로 변수를 정의해야 매칭된다.
    - 리스트의 경우도 각 위치에 해당하는 값이 변수에 할당된다.
    - 케이스 클래스의 경우는 클래스 형태를 그대로 사용해서 속성 정보를 매칭할 수 있다.

    예1)

    ```scala
    def matchFunction(input:Any): Any = input match {
        case 100 => "hundred"
        case "hundred" => 100
        case etcNumber:Int => "Input value must be an Integer which equals or less than 100"
        case _ => "etc"
    }
    
    println(matchFunction(100))
    println(matchFunction("hundred"))
    println(matchFunction(1000))
    println(matchFunction(1000.5))
    println(matchFunction("thousand"))
    
    //결과
    hundred
    100
    Input value must be an Integer which equals or less than 100
    etc
    etc
    ```

    예2)

    ```scala
    case class Person(name:String, age:Int)
    val alice = new Person("Alice", 25)
    val bob = new Person("Bob", 32)
    val charlie = new Person("Charlie", 32)
    
    for(person <- List(alice, bob, charlie)) {
        person match {
            case Person("Alice", 25) => println("Hi Alice!")
            case Person("Bob", 32) => println("Hi Bob!")
            case Person(name, age) => println(
                "Age: " + age + " years, name: " + name + "?"
            )
        }
    }
    
    //결과
    Hi Alice!
    Hi Bob!
    Age: 32 years, name: Charlie?
    
    ```

    

    예3) ***Extractor*** 로 매칭

    ``` scala
    object Emergency {
        def unapply(number:String):Boolean = {
            if(number.length == 3 && number.forall(_.isDigit)) true
            else false
        }
    }
    
    object Normal {
        def unapply(number: String):Option[Int] = {
            try {
                var o = number.replaceAll("-", "")
                Some(number.replaceAll("-", "").toInt)
            } catch {
                case _: Throwable => None
            }
        }
    }
    
    val number1 = "010-222-2222"
    val number2 = "119"
    val number3 = "Pig which ate grapes"
    val numberList = List(number1, number2, number3)
    for(number <- numberList) {
        number match {
            case Emergency() => println("Emergency Call!!!")
            case Normal(number) => println("Normal call - " + number)
            case _ => println("Couldn't judge")
        }
    }
    
    //결과
    Normal call - 102222222
    Emergency Call!!!
    Couldn't judge
    
    ```

    

  - 컬렉션

    - 배열(Array)

    - 리스트(List) 

      - 앞뒤가 연결된 리스트로서 내부적으로 리스트를 붙이거나 나누는데 효율적인 구조를 가지고 있다. 
      - 동적으로 크기를 늘리거나 줄이는 것이 가능. List는 추상 클래스 형태 혹은 이미 완성된 객체 형태로 존재하기 때문에 new를 사용하지 않는다.
      - 이미 만들어져 있는 List 정적 객체의 내부적인 패토리 역할인 apply()가 동작하면서 새로운 List 개체를 생성
      - ***::는 리스트의 각 요소를 결함***
      - ***:::는 여러 리스트를 병합***

      ```scala
      val list1 = "a" :: "b" :: "c" :: Nil
      for(x <- 0 until list1.size) {
          println(list1(x))
      }
      
      val list2 = "d" :: "e" :: Nil
      val list0 = list1 ::: list2
      for(x <- 0 until list0.size) {
          println(list0(x))
      }
      
      //결과
      a
      b
      c
      a
      b
      c
      d
      e
      ```

      - 리스트의 주요 기능

        ```++```, ```apply(Int)```, ```-(키)``` , ... 다 못 침

        ```scala
        object Ex {
            def main(args:Array[String]) : Unit = {
                val list3 = "a" :: "b" :: "c" :: Nil
                val list4 = 1 :: 2 :: 3 :: Nil
                val list5 = 2 :: 2 :: 4 :: Nil
        
                println(list3 ++ list4)
                println(list3.apply(0))
                println(list3.reverse)
                println(list4.max)
                println(list4.min)
                println(list4.sum)
                println(list4.mkString(","))
                println(list4.exists(a => 0 > 3))
                println(list4.exists(_ > 3))
                println(list4.contains(1))
                println(list4.distinct)
            }
        }
        
        //결과
        List(a, b, c, 1, 2, 3)
        a
        List(c, b, a)
        3
        1
        6
        1,2,3
        false
        false
        true
        List(1, 2, 3)
        
        ```

        

    - 맵(Map)

      키를 통해 요소에 접근

      ```scala
      val map = Map(
          "number1" -> "aa",
          "number2" -> "bb",
          "number3" -> 3,
          5 -> "cc"
      )
      
      println(map.isEmpty)
      println("whole map : " + map)
      println("keys : " + map.keys)
      println("values : " + map.values)
      println(map("number1"))
      
      //결과
      false
      whole map : Map(number1 -> aa, number2 -> bb, number3 -> 3, 5 -> cc)
      keys : Set(number1, number2, number3, 5)
      values : View(<not computed>) //  뭐지??
      aa
      
      ```

      맵(Map) 의 주요기능

      ```scala
      val map = Map(
          "number1" -> "aa",
          "number2" -> "bb",
          "number3" -> 3,
          5 -> "cc"
      )
      
      println(map.isEmpty)
      println("whole map : " + map)
      println("keys : " + map.keys)
      println("values : " + map.values)
      println(map("number1"))
      
      
      println("------")
      //추가
      val mapTest01 = map + ("num4" ->  44)
      println(mapTest01("num4"))
      
      val map2 = Map("n1" -> 100, "n2" -> 200)
      val mapTest02 = mapTest01 ++ map2
      println(mapTest02)
      val mapTest03 = mapTest02 - ("num4")
      println(mapTest03)
      ```

      

    - 셋(Set)

      집합(Set) - 중복되지 않는 값을 다뤄야 할 때 사용

      ```scala
      var basket: Set[String] = Set()
      basket += "aaa"
      basket += "aaa"
      basket += "aaa"
      basket += "bbb"
      basket += "ccc"
      basket += "ddd"
      println(basket)
      ```

      집합의 주요 기능

      ```scala
      var basket: Set[String] = Set()
      basket += "aaa"
      basket += "aaa"
      basket += "aaa"
      basket += "bbb"
      basket += "ccc"
      basket += "ddd"
      println(basket)
      
      var basket2:Set[String] = Set()
      basket2 += "aaa"
      basket2 += "fff"
      basket2 += "ggg"
      basket2 += "hhh"
      
      // .diff
      println(basket.diff(basket2))
      // | 합치기
      println(basket | basket2)
      
      // 결과 (해쉬 셋???)
      Set(aaa, bbb, ccc, ddd)
      Set(bbb, ccc, ddd)
      HashSet(hhh, ddd, ggg, ccc, bbb, aaa, fff)
      ```

      

      ㅇㄹㅇㄹ

      ㅇㄹㅇㄹ

      

    - 튜플(tuple)

      - 여러 데이터를 하나의 묶음으로 처리하고 싶을 때 튜플로 처리
      - 튜플은 N개의 데이터 쌍을 저장하는자료 구조

      ```scala
      val t1 = (1, 2)     //튜플 생성
      val t2 = ("a", 1, "c")
      val n1 = t1._2 //튜플 내용 참조
      val n2 = t2._3
      
      println(t1)
      println(t2)
      println(n1)
      println(n2)
      
      //결과
      (1,2)
      (a,1,c)
      2
      c
      ```

      

    - 옵션

      - 여러 개의 값을 저장하는 자료 구조로서 값이 있을 수도 있고 없을 수도 잇는 경우에 사용
      - None이거나 Some()을 하나 가지고 있다.
      - 맵에서 키를 이용해서 값을 가져올 때, 해당하는 ㅇ값이 있을 때는 SOme(을 반환하고 없으면 None을 반환하는 로직에 사용된다.

      ```scala
      object Ex {
          def main(args: Array[String]): Unit = {
              val students = Map(
                  1 -> "Moon",
                  2 -> "Um",
                  3 -> "Noh"
              )
      
              val one = students.get(1)
              val four = students.get(4)
      
              println(one)
              println(four)
              println(one.get)
              println(four.getOrElse("Value not exists"))
          }
      }
      
      //결과
      Some(Moon)
      None
      Moon
      Value not exists
      
      ```

      

    - 시퀀스(Seq)

      https://www.scala-lang.org/api/2.12.3/scala/collection/Seq.html

      내부적으로 인덱스에 대한 정보를 가지고 있으므로 인덱스와 관련해서 써야 할 기능이 많을 경우 쉽게 데이터를 다룰 수 있다.

      ```scala
      object Ex {
          def main(args: Array[String]): Unit = {
      
              val donuts:Seq[String] = Seq(
                  "Plain Donut",
                  "Strawberry Donut",
                  "Glazed Donut"
              )
      
              println(s"Elements of donuts = $donuts")
              println(s"Take elements from index 0 to 1 =  ${donuts.slice(0, 1)}"
              )
              println(s"Take elements from index 0 to 2 =  ${donuts.slice(0, 2)}"
              )
          }
      }
      
      //결과
      Elements of donuts = List(Plain Donut, Strawberry Donut, Glazed Donut)
      Take elements from index 0 to 1 =  List(Plain Donut)
      Take elements from index 0 to 2 =  List(Plain Donut, Strawberry Donut)
      ```

      

    - 이터레이터(iterator)

      컬렉션에서 데이터를 꺼내와서 차례대로 무언가를 실행할 때

    

    

    - 패키지 객체(Package Object)

      스칼라에는 패키지에 변수나 클래스 등을 성너할 수 있다.

      패키지 객체를 이용하면 Common과 같은 클래스를 정의하지 않고도 동일 패키지에서 사용하는 변수나 메서드 등을 공유할 수 있다.

      ```package``` 키워드를 사용해 정의

      ```scala
      
      //org.apache.spark.sql 패키지의 패키지 객체
      package org.apache.spark
      ...
      
      package object sql {
      	...
      	type Strategy = SparkStragegy
      	type DataFrame = DataSet[Row]
      }
      ```

    

    -  함수 컴비네이터(bombinator)

      구현된 로직에 따라 컬렉션을 변형한 후 동일한 자료형의 컬렉션을 반환하는 역할을 맡는 메소드

      map().foreach() 컬렉션을 탐색하면서 그 안의 값을 바꾸는 역할

      amp() 리스트 자체를 변형하지 않고 List 자료형을 반환하면서 해로운 변수에 담게 한다

      foreach() 아무값도 반환하지 않으며 리스트 자체의 값을 변형

      ```scala
      object Ex {
          def main(args: Array[String]): Unit = {
              val o = List(1, 2, 3, 4)
              println(o)
              
              val n = o.map(i => i * 10)
              rintln(n)
          }
      }
      
      //결과
      List(1, 2, 3, 4)
      List(10, 20, 30, 40)
      ```

      

      - filter(), filterNot() - 조건이 참 , 거짓을 가릴 수 있는.... ㅜㅜ

      ```scala
      object Ex {
          def main(args: Array[String]): Unit = {
              val o = List(1, 2, 3, 4)
              val n = o.filter(i => i >= 3).map(i =>)
          }
      }
      //치다가 다 못 침
      ```

      

      - foldleft(), foldRight() - 컬렉션에 잇는 여러 요소를 한 쪽..... ㅜㅜ

      ```scala
      object Ex {
          def main(args: Array[String]): Unit = {
             val o = List(1, 2, 3, 4)
             val sum = o.foldLeft(0.0 )(_ + _)
             println(s"Sum = $sum")
          }
      }
      
      //결과
      Sum = 10.0
      ```

      

      - partition() - 컬렉션을 나눈는데 필요한 기능. 조건에 맞는 것들을 하나의 리스트로 저장하고 나머지 것을 다른 리스트에 저장한다.

      ```scala
      object Ex {
          def main(args: Array[String]): Unit = {
              val o = List(1, 2, 3, 4)
              val n = o.partition(i => i < 3)
              println(n)
          }
      }
      
      //결과
      (List(1, 2),List(3, 4))
      ```

      

      - zip, unzip

        ```zip```: 두 개의 List를 각각의 쌍으로 묶음

        ```:::``` : 걍 합침

      ```scala
      object Ex {
          def main(args: Array[String]): Unit = {
              val o = List(1, 2, 3, 4)
              val oo = List(5, 6, 7, 8, 9)
              val n = o zip oo
              val nn = o ::: oo
              println(n)
              println(nn)
          }
      }
      
      //결과
      List((1,5), (2,6), (3,7), (4,8))
      List(1, 2, 3, 4, 5, 6, 7, 8, 9)
      
      ```

      

      - find()

      ```scala
      object Ex {
          def main(args: Array[String]): Unit = {
              val o = List(1, 2, 3, 4)
              
              val n = o.find(i => i >= 2)
              val nn = o.find(i => i == 9)
              println(n)
              println(nn)
          }
      }
      
      //결과
      Some(2)
      None
      ```

      

      - drop()

      ```scala
      object Ex {
          def main(args: Array[String]): Unit = {
              val o = List(1, 2, 3, 4, 5, 6, 0)
              
              val n = o.drop(4)
              val nn = o.dropWhile( i => i < 3)
      
              println(n)
              println(nn)
          }
      }
      
      //결과
      List(5, 6, 0) //4개 버림
      List(3, 4, 5, 6, 0) // 3 보다 작으면 버림
      ```

      

      - flatten() - 리스트 안에 리스트가 중첩되어 있는 경우 하나로 합쳐준다.

      ```scala
      //--------------------------------------------
      //Ex1)
      object Ex {
          def main(args: Array[String]): Unit = {
              val o = List(List(1, 2, 3, 4), List(5, 6))
      
              val n = o.flatten
              println(n)
          }
      }
      
      //결과
      List(1, 2, 3, 4, 5, 6)
      
      //--------------------------------------------
      //Ex2)
      val donuts1: Seq[String] = Seq("Plain", "Strawberry", "Glazed")
      val donuts2: Seq[String] = Seq("Vanilla", "Glazed")
      val listDonuts: List[Seq[String]] = List(donuts1, donuts2)
      val listDonutsFromFlatten: List[String] = listDonuts.flatten
      
      println(donuts1)
      println(donuts2)
      println(listDonuts)
      println(listDonutsFromFlatten)
      
      //결과
      List(Plain, Strawberry, Glazed)
      List(Vanilla, Glazed)
      List(List(Plain, Strawberry, Glazed), List(Vanilla, Glazed))
      List(Plain, Strawberry, Glazed, Vanilla, Glazed)
      ```

  

  

  - 예외처리

    - Either - 둘 중 하나를 선택

      ```scala
      object EitherTest {   
         def main(args: Array[String]): Unit = {
             val input = scala.io.StdIn.readLine("값을 입력하세요:")
             val result: Either[String, Int] = try {
                Right(input.toInt)
             } catch {
               case e : Exception => Left(input)
             }
             print(result.getClass)             
         }
      }
      ```

      

    - 파일 없을 경우

      ```scala
      import java.io.FileReader
      import java.io.FileNotFoundException
      import java.io.IOException
      
      object Demo {
          def main(args:Array[String]) {
      
              try {
                  val f = new FileReader("input.txt")
              } catch {
                  case ex: FileNotFoundException => {
                      println("Missing file exception")
                  }
                  case ex: IOException => {
                      println("IO Exception")
                  }
              } finally {
                  println("Exiting finally...")
              }
          }
      }
      
      c:> scalac Demo.scala
      c:> scala Demo
      //결과
      Missing file exception
      Exiting finally...
      ```

    

    - 파일 읽기

      ```scala
      import java.io.FileReader
      import java.io.FileNotFoundException
      import java.io.IOException
      import scala.io.Source
      
      object FilereadTest {
          def main(args:Array[String]) {
             println("Following is the content read: ")
      
             Source.fromFile("input2.txt").foreach {
                 print
             }
          }
      }
      
      //결과
      잘 됨...
      ```

      

    - 파일에 쓰기

      ```scala
      import scala.io.StdIn.readLine
      import java.io.File
      import java.io.PrintWriter
      
      object FilewriteTest {
          def main(args:Array[String]) {
              val filename = "test.txt"
              var input = readLine("파일에 쓸 내용을 입력하세요! : ")
      
              val writer = new PrintWriter(new File(filename))
              writer.write(input)
              writer.close
      
              //출력 파일은 패키지 디렉토리에 생성됩니다.
              print("입력하신 텍스트를 " + filename + " 에 저장했습니다.")
          }
      }
      
      
      //결과
      잘 됨..
      
      ```






---

### Spark

>  아파치 스파크는 빅데이터처리를 위한 오픈소스 병렬분산처리 플랫폼이다. 빅데이터 활용이 당연시되는 현재, 빅데이터로부터 시행착오를 겪어 원하는 결과를 얻거나, 스트림처리와 머신 러닝을 효과적으로 수행하려는 수요가 늘고 있다. 이러한 수요에 대응하고자 스파크는 성능과 이용자 편의성을 모두 고려하여 개발이 이뤄지고 있다.



- 설치

  ```bash
  #Download
  #https://www.apache.org/dyn/closer.lua/spark/spark-#2.4.3/spark-2.4.3-bin-hadoop2.7.tgz
  
  root$ cd /usr/local
  root$ tar xvzf /home/hadoop/Download/spark-2.4.3-bin-hadoop2.7.tgz
  root$ chown -R hadoop:hadoop spark-2.4.3-bin-hadoop2.7/
  root$ ln -s spark-2.4.3-bin-hadoop2.7 spark
  root$ chown -R hadoop:hadoop spark
  
  
  # .bash_profile 에 다음 추가
  hadoop$ vi .bash_profile
  
  #----------------------------------
  export SPARK_HOME=/usr/local/spark
  export HADOOP_CONF_DIR=/usr/local/hadoop-2.7.7/etc/hadoop
  export YARN_CONF_DIR=/usr/local/hadoop-2.7.7/etc/hadoop
  export PATH=$PATH:$JAVA_HOME/bin:$HADOOP_HOME/bin:$HIVE_HOME/bin:$SPARK_HOME/bin
  #----------------------------------
  
  hadoop$ source .bash_profile
  
  ```

  

- 실행()

  ```scala
  hadoop$ spark-shell --master local verbose
  
  Welcome to
        ____              __
       / __/__  ___ _____/ /__
      _\ \/ _ \/ _ `/ __/  '_/
     /___/ .__/\_,_/_/ /_/\_\   version 2.4.3
        /_/
  
  Using Scala version 2.11.12 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_221)
  Type in expressions to have them evaluated.
  Type :help for more information.
  
  // 로컬 파일을 읽어들여서 RDD로 생성
  scala>  val file = sc.textFile("file:///usr/local/spark/README.md")
  
  // RDD로부터 한 행
  scala> val words = file.flatMap(_.split(" "))
  
  // 같은 단어끼리 모아서 요약(갯수) 계산 - map 형태로 단어와 출현횟수
  scala> val result = words.countByValue
  
  // 결과 보기
  scala> result.get("For").get
  
  // 결과
  res1: Long = 3
  ```



- SBT 설치

  ```bash
  # Download
  # https://www.scala-sbt.org/download.html
  root$ tar xvzf sbt-1.2.7.tgz -C /opt/
  
  # .bash_profile 설정 추가
  export SBT_HOME=/opt/sbt
  export PATH=$PATH:$JAVA_HOME/bin:$HADOOP_HOME/bin:$HIVE_HOME/bin:$SPARK_HOME/bin:$SBT_HOME/bin
  
  # 실행
  hadoop$ source .bash_profile
  hadoop$ sbt about
  # ... 엄청 오래 걸림. maven 기반으로 엄청 다운로드.
  
  # 결과
  [info] Updated file /home/hadoop/project/build.properties: set sbt.version to 1.2.7
  [info] Loading project definition from /home/hadoop/project
  [info] Updating ProjectRef(uri("file:/home/hadoop/project/"), "hadoop-build")...
  [info] downloading https://repo1.maven.org/maven2/org/apache/logging/log4j/log4j-core/2.11.1/log4j-core-2.11.1-tests.jar ...
  [info]  [SUCCESSFUL ] org.apache.logging.log4j#log4j-core;2.11.1!log4j-core.jar(test-jar) (5186ms)
  [info] Done updating.
  [info] Set current project to hadoop (in build file:/home/hadoop/)
  [info] This is sbt 1.2.7
  [info] The current project is ProjectRef(uri("file:/home/hadoop/"), "hadoop") 0.1.0-SNAPSHOT
  [info] The current project is built against Scala 2.12.7
  [info] Available Plugins
  [info]  - sbt.ScriptedPlugin
  [info]  - sbt.plugins.CorePlugin
  [info]  - sbt.plugins.Giter8TemplatePlugin
  [info]  - sbt.plugins.IvyPlugin
  [info]  - sbt.plugins.JUnitXmlReportPlugin
  [info]  - sbt.plugins.JvmPlugin
  [info]  - sbt.plugins.SbtPlugin
  [info] sbt, sbt plugins, and build definitions are using Scala 2.12.7
  
  ```

  

- SBS  실습(spark-simple-app)

  ```bash
  hadoop$ cd ~
  
  #스파크 어플리케이션 프로젝트 폴더 생성
  hadoop$ mkdir spark-simple-app
  hadoop$ cd spark-simple-app
  
  #소스 코드 파일 저장 디렉토리 생성
  hadoop$ mkdir -p src/main/scala
  
  #sbt 설정 파일 저장 디렉토리 생성
  hadoop$ mkdir project
  
  #소스 코드 저장될 패키지 디렉토리 생성
  hadoop$ mkdir -p src/main/scala/lab/spark/example
  hadoop$ cd src/main/scala/lab/spark/example
  hadoop$ vi SundayCount.scala
  # SundayCount.scala
  #-----------------------------------------
  package lab.spark.example
  
  import org.joda.time.{DateTime, DateTimeConstants}
  import org.joda.time.format.DateTimeFormat
  import org.apache.spark.{SparkConf, SparkContext}
  
  object SundayCount {
      def main(args: Array[String]) {
          if(args.length < 1) {
                  throw new IllegalArgumentException(
                  "명령 인수에 날짜가 기록된 파일의 경로를 지정해 주세요.")
          }
          val filePath = args(0)
          val conf = new SparkConf
          val sc = new SparkContext(conf)
  
          try {
              //텍스트 파일을 로드한다
              val textRDD = sc.textFile(filePath)
  
              //문자열로 표현된 날짜로부터 DateTime형 인스턴스를 생성한다.
              val dateTimeRDD = textRDD.map { dateStr => 
                  val pattern =
                      DateTimeFormat.forPattern("yyyyMMdd")
                  DateTime.parse(dateStr, pattern)
              }
  
              //일요일만 추출한다.
              val sundayRDD = dateTimeRDD.filter { dateTime =>
                  dateTime.getDayOfWeek == DateTimeConstants.SUNDAY
              }
  
              //sundayRDD에 들어있는 일요일 갯수를 센다
              val numOfSunday = sundayRDD.count
              println("주어진 데이터에는 일요일이 ${numOfSunday}개 들어 있습니다.")
  
          } finally {
              sc.stop()
          }
      }
  }
  #-----------------------------------------
  
  hadoop$
  hadoop$
  hadoop$
  hadoop$ cd ~/exercise/sbt/spark-simple-app
  hadoop$ vi build.sbt
  # build.sbt
  #-----------------------------------------
  name := "spark-simple-app"
  version := "0.1"
  scalaVersion := "2.11.12"
  libraryDependencies ++= Seq("org.apache.spark" % "spark-core_2.11" % "2.4.3" % "provided", "joda-time" % "joda-time" % "2.8.2")
  assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)
  #-----------------------------------------
  
  hadoop$ cd project
  hadoop$ vi plugins.sbt
  
  # plugins.sbt
  #-----------------------------------------
  addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.10")
  #-----------------------------------------
  
  hadoop$ cd ..
  hadoop$ pwd
  /home/hadoop/exercise/sbt/spark-simple-app
  hadoop$ sbt assembly
  #결과
  [info] Done packaging.
  [success] Total time: 289 s, completed Aug 27, 2019 1:24:04 PM
  #아래 파일 확인
  /home/hadoop/exercise/sbt/spark-simple-app/target/scala-2.11/spark-simple-app-assembly-0.1.jar
  
  hadoop$ cd ~
  hadoop$ vi date.txt
  # data.txt
  #-----------------------------------------
  20150322
  20150331
  20150417
  20150426
  20150506
  20150523
  20150524
  20150712
  20150728
  20150801
  20150830
  20150927
  #-----------------------------------------
  
  hadoop$ hadoop fs -mkdir /data/spark/
  hadoop$ hadoop fs -put date.txt /data/spark/
  
  # 대망의 실행!!!!
  hadoop$ spark-submit --master local \
  --class lab.spark.example.SundayCount \
  --name SundayCount \
  ./target/scala-2.11/spark-simple-app-assembly-0.1.jar \
  /data/spark/date.txt
  
  #결과
  주어진 데이터에는 일요일이 6개 들어 있습니다.
  19/08/27 14:28:18 INFO server.AbstractConnector: Stopped Spark@1a6f5124{HTTP/1.1,[http/1.1]}{0.0.0.0:4040}
  19/08/27 14:28:18 INFO ui.SparkUI: Stopped Spark web UI at http://master:4040
  19/08/27 14:28:18 INFO spark.MapOutputTrackerMasterEndpoint: MapOutputTrackerMasterEndpoint stopped!
  19/08/27 14:28:18 INFO memory.MemoryStore: MemoryStore cleared
  19/08/27 14:28:18 INFO storage.BlockManager: BlockManager stopped
  19/08/27 14:28:18 INFO storage.BlockManagerMaster: BlockManagerMaster stopped
  19/08/27 14:28:18 INFO scheduler.OutputCommitCoordinator$OutputCommitCoordinatorEndpoint: OutputCommitCoordinator stopped!
  19/08/27 14:28:18 INFO spark.SparkContext: Successfully stopped SparkContext
  19/08/27 14:28:18 INFO util.ShutdownHookManager: Shutdown hook called
  19/08/27 14:28:18 INFO util.ShutdownHookManager: Deleting directory /tmp/spark-b68d1028-67b1-4f6e-9f16-0e293bef5590
  19/08/27 14:28:18 INFO util.ShutdownHookManager: Deleting directory /tmp/spark-bfdee742-7715-4459-90d8-e3fc05a05d02
  
  ```

  

- 스파크 셸

- 

- 스파크 API

  - collect

    -  RDD의 모든 원소를 모아서 배열로 돌려준다
    - 파일이나 데이터베이스 같은 외부 데이터를 이용하여 RDD 생성
    - RDD에 있는 모든 요소들이 collect 연산을 호출한 서버의 메모리에 주집합니다.
    - 전체 데이터를 모두 담을 수 있을 정도의 충분한 메모리 공간이 확보돼 있는 상태에서만 사용해야 한다

  - count

    RDD를 구성하는 전체 요소의 갯수를 반환

  ```scala
  scala> var rdd = sc.parallelize(1 to 10)
  rdd: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24
  
  scala> var result = rdd.collect
  result: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  
  scala> println(result.mkString(", "))
  1, 2, 3, 4, 5, 6, 7, 8, 9, 10
  
  scala> val result2 = rdd.count
  result2: Long = 10
  
  scala> println(result2)
  10
  
  ```

  

  - Transformation

    각 요소의 타입을 문자열에서 숫자로 바꾸거나 불필요한 요소를 제외하거나 기존 요소의 값에 특정 값을 더하는 드으이 작업이 모두 포함된다. 

    ```map 연산```, ```그룹화 연산```, ```집합 연산```, ```파티션 연산```, ```필터와 정렬 연산```

    - ```map```

      하나의 입력을 받아 하나의 값을 돌려주는 함수를 인자로 받는다. RDD에 속하는 모든 요소에 적용한 뒤 그 결과로 구성된 새로운 RDD를 생성해서 반환. 인자로 사용하는 함수의 반환 타입에 제약이 없다.

      ```scala
      //map 메서드 : map[U](f : (T) => U) : RDD[U]
      
      scala> var rdd = sc.parallelize( 1 to 5)
      rdd: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize <console>:24
      
      scala> var result = rdd.map(_ + 1)
      result: org.apache.spark.rdd.RDD[Int] = MapPartitionsRDD[1] at map at <console>:25
      
      scala> println(result.collect.mkString(", "))
      2, 3, 4, 5, 6
      
      ```

    - flatmap

      TraversableOnce는 스칼라에서 사용하느 이터레이터 타입 중 하나. 함수 f는 반환값을

      ```scala
      
      
      scala> var fruits = List("apple, orange", "grape, apple, mango", "blueberry, tomato, orange")
      fruits: List[String] = List(apple, orange, grape, apple, mango, blueberry, tomato, orange)
      
      scala> var rdd1 = sc.parallelize(fruits)
      rdd1: org.apache.spark.rdd.RDD[String] = ParallelCollectionRDD[2] at parallelize at <console>:26
      
      scala> var rdd2 = rdd1.flatMap(_.split(","))
      rdd2: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[3] at flatMap at <console>:25
      
      scala> print(rdd2)
      MapPartitionsRDD[3] at flatMap at <console>:25
      scala> print(rdd2.collect.mkString(", "))
      apple,  orange, grape,  apple,  mango, blueberry,  tomato,  orange
      scala>
      
      ```

      

    - Some과 None

      값이 있거나 없을 수 있는 옵션 상황을 표시하는 스칼라 타입이다. 값이 있다면 Some을, 없으면 None을 반환한다.

      ```scala
      scala> var rdd2 = rdd1.flatMap( log => {
           | if(log.contains("apple")) {
           | 	Some(
               log.indexOf("apple")
           	)
           | } else {
           | 	None
           | }
           |})
      
      scala> print(rdd2.collect.mkString(", "))
      0, 7
      scala>
      
      ```

    - mapPartitions

      ```scala
      scala> var rdd1 = sc.parallelize( 1 to 10, 3)
      scala> var rdd2 = rdd1.mapPartitions(numbers => {
           | print("DB 연결 !!!")
           | numbers.map {
           | number => number + 1
           | }
           | })
      
      scala> println(rdd2.collect.mkString(", "))
      DB 연결 !!!DB 연결 !!!DB 연결 !!!2, 3, 4, 5, 6, 7, 8, 9, 10, 11
      ```

    - mapPartitionsWithIndex

      ```scala
      scala> var rdd2 = rdd1.mapPartitionsWithIndex((idx, numbers) => {
           | numbers.flatMap {
           | case number if idx == 1 => Option(number + 1)
           | case _ => None
           | }
           | })
      
      scala> println(rdd2.collect.mkString(", "))
      5, 6, 7
      ```

    - mapValues

      PairRdd에 속하는 데이터는 키를 기준으로 작은 그룹들을 만들고 해당 그룹들에 속한 값을 대상으로 합계나 평균을 구하는 등의 연산을 수행.

      ```scala
      scala> var rdd = sc.parallelize(List("a", "b", "c")).map((_, 1))
      scala> var result = rdd.mapValues(i => i+1)
      
      scala> println(result.collect.mkString("\t"))
      (a,2)   (b,2)   (c,2)
      ```

      

    - flatMapValues

      RDD의 모든 요소들이 키와 값의 쌍을 이루고 있는 경우에만 사요 가능한 메서드.  "값"에 해당하는 요소에만 flatMap()연산을 적용하고 그결과로 구성된 RDD를 생성

      ```scala
      scala> var rdd = sc.parallelize(Seq((1, "a, b"),(2, "a, c"), (3, "d, e")))
      scala> var result = rdd.flatMapValues(_.split(","))
      
      scala> println(result.collect.mkString("\t"))
      (1,a)   (1, b)  (2,a)   (2, c)  (3,d)   (3, e)
      
      ```

      

      

    - zip

      두 개의 서로 다른 RDD를

      ```scala
      scala> var rdd1 = sc.parallelize(List("a", "b", "c"))
      scala> var rdd2 = sc.parallelize(List(1, 2, 3))
      scala> var result = rdd1.zip(rdd2)
      
      scala> println(result.collect.mkString("\t"))
      (a,1)   (b,2)   (c,3)
      ```

      

    - groupBy

      RDD의 요소를 일정한 기준에 따라 여러 개의 그룹으로 나누고 이 그룹으로 구성된 새로운 RD를 생성. 각 그룹은 키와 그 키에 속한 요소들의 시퀀스로 구성되며, 메서드의 인자로 전달하는 함수가 각 그 그룹의 키를 경정하는 역할을 담당. 요소의 키를 생성하는 작업과 그룹으로 분류하는 작업을 동시에 수행

      ```scala
      scala> var rdd = sc.parallelize( 1 to 10)
      scala> var result = rdd.groupBy {
           | case i : Int if (i % 2 == 0) => "even"
           | case _ => "odd"
           | }
      
      scala> result.collect.foreach {
           | v => println(s"${v._1}, [${v._2.mkString(", ")}]")
           | }
      even, [2, 4, 6, 8, 10]
      odd, [1, 3, 5, 7, 9]
      
      
      ```

      

    - df

    - df

    - df

  - ㅇ

  - ㅇ

  - 를

  

- ㅇㄹ

- ㅇㄹ

- ㅇㄹ

- ㅇ

- ㅇ

- ㅇ

- ㅇ

- 

- ㄹ