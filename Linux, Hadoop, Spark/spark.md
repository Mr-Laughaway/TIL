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

      추상 클래스 여러개를 한 클래스에서 상속 받을 경우 다아몬드 상속의 문제가 발생할 경우, 최종적으로 상속받는 클래스의 메서드가 수행되도록 override 예약어와 함께 적당한 상속 관계를 만들어줄 수 있습니다.

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

      

      

    - df

    - df

    - df

    - 

  - df

  - d

  - f

  - df

  - df

  - d

  - f

- 

- ㅇㄹ
- ㅇㄹ
- ㅇㄹ
- ㅇㄹ
- ㅇㄹ
- ㅇㄹ
- 

