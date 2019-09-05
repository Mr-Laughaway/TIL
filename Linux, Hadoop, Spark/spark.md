<h1>Spark</h1>


![Image result for spark](spark.assets/1200px-Apache_Spark_Logo.svg.png)

> 현재 빅데이터 분석기술 중에서 가장 주목 받는 기술은 스파크 입니다.
>
> **스파크**는 인메모리(In-Memory) 기반의 처리로 하둡의 맵리듀스에 비해서 100배 빠른 속도를 제공하고, 머신러닝, 그래프처리 등 빅데이터 분석을 위한 통합 컴포넌트를 제공합니다.
>
> 스파크는 **스칼라**로 작성되어 자바 보다 간결한 코드로 같은 작업을 표현할 수 있습니다. 또한 스칼라는 JVM에서 동작하기 때문에 기존에 사용하던 자바 라이브러리를 모두 사용할 수 있습니다.

:link: [참고 사이트](http://wikidocs.net/book/2350)

<br>

<br>

# 1. Scala

> 스칼라는 자바 가상 머신(JVM) 에서 동작하는 JVML(Java Virtual Machine Language) 언어이다. 자바 가상 머신 위에서 동작하는 언어들로 **sclala**, **kotlin**, **Groovy** 등이 있다.  자바 가상 머신 위에서 동작하기 때문에 자바의 모든 라이브러리를 사용할 수 있다. 스칼라는 스칼라 컴파일러를 통해 스칼라 코드를 바이트 코드로 변환하고, 바이트 코드는 JVM 상에서 자바와 동일하게 실행 된다.

- Hadoop 기반의 데이터 인프라는 자바 언어를 통해 MapReduce 연산 그리고 알고리즘을 구현. 그런데 이 때 자바는 코드가 너무 길어 생상성 그리고 가독성이 매우 떨어진다.
- 스칼라는 ***적은 양의 코드로 방대한 규모의 시스템을 작성할 수 있다.***
- 스칼라는 객체지향 프로그래밍과 함수형 프로그래밍을 모두 완벽하게 지원하는 언어
  - 스칼라에서는 모든 것이 객체이며 함수가 first object 이다.
  - 함수를 마치 하나의 값으로 취급하여 이를 변수 또는 파라미터로 넘길 수 있다
  - 모든 것을 함수로 해결하면 의도하지 않은 동작(side effect)이 발생할 일이 없고, 한 번 검증된 함수는 신뢰할 수 있기 때문에 버그가 줄어드는 효과가 있다.
  - ```Immutable``` 변수는 문제를 단순화시켜주기 때문에 데이터 공유, 병렬처리에 강하다.

## 1.1. 스칼라 언어의 특성

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

## 1.2. 설치

- Java 8 JDK install

- Scalar install

  - https://www.scala-lang.org/download/
  - Scalar IDE - IntelliJ, or SBT, Scala's build tool. Http://scala-ide.org

- 이클립스는 마켓플레이스에서 스칼라 IDE를 설치하면 스칼라 프로젝트를 생성할 수 있다

  Help -> Eclipse Marketplace > scala ide

## 1.3. 실습

### 1.3.1. 컴파일 해서 쓰기

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

### 1.3.2. 기본

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

scala> println(s"${1 + 1}")
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

### 1.3.3. 반복문

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

※ zipWIthIndex

### 1.3.4. 함수 정의

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
On line 3: error: method name3 has return statement; needs result type

// 
scala> def addOne(m: Int): Int = m + 1
scala> val three = addOne(2)
scala> def three() = 1 + 2
scala> three()
scala> three
```

### 1.3.5. 익명 함수

```scala
(x: Int) => x + 1
//인터프리터가 부여한 이름(1)

def adder(m:Int, n:Int) = m + n
val add2 = adder(2, _:Int)
print(add2(3))
```

※ _: ***만능???***

### 1.3.6. 커리 함수(Curried functions)

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

<br>

### 1.3.7. 변수에 함수 넣기

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

### 1.3.8. 재귀함수

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

<br>

### 1.3.9. 매개변수가 여러개인 함수

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

### 1.3.10. 함수 기본 값

```scala
def default(a:Int = 4, b:Int = 5) : Int = a + b
println("기본값은 " + default())
println("기본값은 " + default(11, 6))

�⺻���� 9
�⺻���� 17
```

### 1.3.11. apply

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

### 1.3.12. 암묵적 형변환

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

### 1.3.13. object 예약어

스칼라에서는 public class 대신 object 예약어를 통해 처음부터 메모리에 객체를 생성하고 컴파일러는 객체에 main 이라는 이름이 있으며 main을 프로그램의 시작점으로 컴파일 한다.

```scala
object Ex4 {
	def main(args:Array[String]): Unit = {
        ...
    }
}
```

### 1.3.14. case class

케이스 클래스는 자동으로 멤버 변수를 만들어주며, 외부

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

<br>

### 1.3.15. 클래스 생성자

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

<br>

### 1.3.16. 상속

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

<br>

### 1.3.17. 메서드 Overloading

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

<br>

### 1.3.18. 추상 클래스

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

<br>

### 1.3.19. 트레잇(trait)

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

- 모두의 기능을 실행하도록 상위 클래스 super를 호출해서 해당하는 메서드를 실행되게 할 수 있다.

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

<br>

### 1.3.20. 패턴 매치

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

<br>

<br>

## 1.4. 자료형

### 1.4.1. 배열(Array)

<br>

### 1.4.2. 리스트(List) 

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


<br>

### 1.4.3. 맵(Map)

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

<br>

### 1.4.4. 셋(Set)

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
Set("aaa", "bbb", "ccc", "ddd")
Set(bbb, ccc, ddd)
HashSet(hhh, ddd, ggg, ccc, bbb, aaa, fff)
```

<br>

### 1.4.5. 튜플(Tuple)

여러 데이터를 하나의 묶음으로 처리하고 싶을 때 튜플로 처리

튜플은 N개의 데이터 쌍을 저장하는자료 구조

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

<br>

### 1.4.6. 옵션

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

<br>

### 1.4.7. 시퀀스(Seq)

:link: [참고 사이트](https://www.scala-lang.org/api/2.12.3/scala/collection/Seq.html)

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

### 1.4.8. 이터레이터(iterator)

컬렉션에서 데이터를 꺼내와서 차례대로 무언가를 실행할 때

<br>

### 1.4.9. 패키지 객체(Package Object)

- 스칼라에는 패키지에 변수나 클래스 등을 선언할 수 있다.

- 패키지 객체를 이용하면 Common과 같은 클래스를 정의하지 않고도 동일 패키지에서 사용하는 변수나 메서드 등을 공유할 수 있다.

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

<br>

<br>

## 1.5. 함수 컴비네이터(combinator)

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

<br>

<br>

<br>

# 2. Spark

>  아파치 스파크는 빅데이터처리를 위한 오픈소스 병렬분산처리 플랫폼이다. 빅데이터 활용이 당연시되는 현재, 빅데이터로부터 시행착오를 겪어 원하는 결과를 얻거나, 스트림처리와 머신 러닝을 효과적으로 수행하려는 수요가 늘고 있다. 이러한 수요에 대응하고자 스파크는 성능과 이용자 편의성을 모두 고려하여 개발이 이뤄지고 있다.

## 2.1. 설치

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

<br>

<br>

## 2.2. 실행

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

<br>

<br>

## 2.3. SBT 설치

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

<br>

<br>

## 2.4. SBT  실습

### 2.4.1. 특정 요일 count 해 보기

***spark-simple-app***

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
            println(s"주어진 데이터에는 일요일이 ${numOfSunday}개 들어 있습니다.")

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

<br>

### 2.4.2. wordcount 만들어보기

***wordcount-app***

```bash
#스파크 어플리케이션 프로젝트 폴더 생성
[hadoop@master ~]$ mkdir wordcount-app

[hadoop@master ~]$ cd wordcount-app

# 소스 코드 파일 저장 디렉토리 생성
[hadoop@master ~]$ mkdir -p src/main/scala  
#sbt 설정 파일 저장  디렉토리 생성
[hadoop@master ~]$ mkdir project

# 소스 코드 저장될 패키지 디렉토리 생성
[hadoop@master ~]$ mkdir -p src/main/scala/lab/spark/example
[hadoop@master ~]$ cd  src/main/scala/lab/spark/example
[hadoop@master ~]$ vi WordCount.scala
#------------------------------------------------------
package lab.spark.example

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {  def main(args: Array[String]): Unit = {    
        require(args.length == 3, "Usage: WordCount <Master> <Input> <Output>")   
        val sc = getSparkContext("WordCount", args(0))    
        val inputRDD = getInputRDD(sc, args(1))    
        val resultRDD = process(inputRDD)    
        handleResult(resultRDD, args(2))  
    }
    def getSparkContext(appName: String, master: String) = {    
        val conf = new SparkConf().setAppName(appName).setMaster(master)    
        new SparkContext(conf) 
    }

    def getInputRDD(sc: SparkContext, input: String) = {    
        sc.textFile(input) 
    }  

    def process(inputRDD: RDD[String]) = {    
        val words = inputRDD.flatMap(str => str.split(" "))    
        val wcPair = words.map((_, 1))    wcPair.reduceByKey(_ + _)  
    }  

    def handleResult(resultRDD: RDD[(String, Int)], output: String) {    
        resultRDD.saveAsTextFile(output); 
    }
}

#------------------------------------------------------
[hadoop@master ~]$ cd ~/wordcount-app
[hadoop@master ~]$ vi build.sbt

name := "wordcount-app"
version := "0.1"
scalaVersion := "2.11.12"
libraryDependencies ++= Seq("org.apache.spark" % "spark-core_2.11" % "2.4.3" % "provided")
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)


[hadoop@master ~]$ cd project
[hadoop@master ~]$ vi plugins.sbt

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.10")


#어플리케이션 빌드
[hadoop@master ~]$ cd ~/wordcount-app
[hadoop@master ~]$ sbt assembly

#데이터 소스 생성
[hadoop@master ~]$ vi simple-words.txt
cat
dog
.org
cat
rabbit
bear
cat
&&
tiger
dog
rabbit
100
bear
tiger
cat
rabbit
?bear

#하둡 파일 시스템에 simple-words.txt파일 업로드
[hadoop@master ~]$ hadoop fs -mkdir  /data/spark/
[hadoop@master ~]$ hadoop fs -put simple-words.txt  /data/spark/

# 실행
hadoop$ spark-submit --master local \
--class lab.spark.example.WordCount \
--name WordCount \
./target/scala-2.11/wordcount-app-assembly-0.1.jar \
/data/spark/simple-word.txt


#결과
(tiger,2)
(100,1)
(bear,2)
(rabbit,3)
(org,1)
(dog,2)
(cat,4)
```

<br>

<br>

<br>

# 3. Spark API

## 3.1. collect

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

<br>

<br>

## 3.2 Transformation

각 요소의 타입을 문자열에서 숫자로 바꾸거나 불필요한 요소를 제외하거나 기존 요소의 값에 특정 값을 더하는 등의 작업이 모두 포함된다. 

```map 연산```, ```그룹화 연산```, ```집합 연산```, ```파티션 연산```, ```필터와 정렬 연산```

### 3.2.1. map

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

<br>

### 3.2.2. flatmap

※ TraversableOnce는 스칼라에서 사용하느 이터레이터 타입 중 하나. 함수 f는 반환값을...

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

<br>

### 3.2.3. Some과 None

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

<br>

### 3.2.4. mapPartitions

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

<br>

### 3.2.5. mapPartitionsWithIndex

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

<br>

### 3.2.6. mapValues

PairRdd에 속하는 데이터는 키를 기준으로 작은 그룹들을 만들고 해당 그룹들에 속한 값을 대상으로 합계나 평균을 구하는 등의 연산을 수행.

```scala
scala> var rdd = sc.parallelize(List("a", "b", "c")).map((_, 1))
scala> var result = rdd.mapValues(i => i+1)

scala> println(result.collect.mkString("\t"))
(a,2)   (b,2)   (c,2)
```

<br>

### 3.2.7. flatMapValues

RDD의 모든 요소들이 키와 값의 쌍을 이루고 있는 경우에만 사요 가능한 메서드.  "값"에 해당하는 요소에만 flatMap()연산을 적용하고 그결과로 구성된 RDD를 생성.

```scala
scala> var rdd = sc.parallelize(Seq((1, "a, b"),(2, "a, c"), (3, "d, e")))
scala> var result = rdd.flatMapValues(_.split(","))

scala> println(result.collect.mkString("\t"))
(1,a)   (1, b)  (2,a)   (2, c)  (3,d)   (3, e)

```

<br>

### 3.2.8. zip

두 개의 서로 다른 RDD의 값들을 각각 순서대로 묶어 튜플형태의 리스트로 만들어준다. 

```scala
scala> var rdd1 = sc.parallelize(List("a", "b", "c"))
scala> var rdd2 = sc.parallelize(List(1, 2, 3))
scala> var result = rdd1.zip(rdd2)

scala> println(result.collect.mkString("\t"))
(a,1)   (b,2)   (c,3)
```

<br>

### 3.2.9. groupBy

RDD의 요소를 일정한 기준에 따라 여러 개의 그룹으로 나누고 이 그룹으로 구성된 새로운 RD를 생성. 각 그룹은 키와 그 키에 속한 요소들의 시퀀스로 구성되며, 메서드의 인자로 전달하는 함수가 각 그 그룹의 키를 경정하는 역할을 담당. 요소의 키를 생성하는 작업과 그룹으로 분류하는 작업을 동시에 수행.

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

<br>

### 3.2.10. cogroup

RDD의 구성요소가 키와 값 쌍으로 이뤄진 경우에 사용 가능한 메서드. RDD에서 같은 키를 갖는 값 요소를 찾아서 키와 그 키에 속하는 요소으 ㅣ시퀀스로 구성된 튜플을 만들고, 그 튜플들로 구성된 새로운 RDD를 생성한다.

```scala
scala> var rdd = sc.parallelize( List(("k1", "v1"), ("k2", "v2"), ("k1", "v3") ))
scala> var rdd2 = sc.parallelize(List(("k1", "v4")))
scala> var result = rdd.cogroup(rdd2)
scala> result.collect.foreach {
     |    case (k, (v_1, v_2)) => {
     |         println(s"($k, [${v_1.mkString(",")}], [${v_2.mkString(", ")}])")
     |    }
     | }

(k2, [v2], [])
(k1, [v1,v3], [v4])
```

<br>

### 3.2.11. distinct

RDD의 원소에서 중복을 제외한 요소로만 구성된 새로운 RDD를 생성하는 메서드.

```scala
val rdd = sc.parallelize( List( 1, 2, 3, 1, 2, 3, 1, 2, 3))
val result = rdd.distinct()
println(result.collect.mkString(", "))

```

<br>

### 3.2.12. cartesian

두 RDD 요소의 카테시안곱을 구하고 그 결과를 요소로 하는 새로운 RDD 생성.

```scala
val rdd1 = sc.parallelize( List(1, 2, 3))
val rdd2 = sc.parallelize( List("a", "b", "c"))
val result = rdd1.cartesian(rdd2)
println(result.collect.mkString(", "))

```

<br>

### 3.2.13. substract

안 됨...

rdd1.substract(rdd2)는 rdd1에 속하고, rdd2에는 속하지 않는 요소로 구성된 새로운 RDD를 생성하는 메서드.

```scala
val rdd1 = sc.parallelize( List("a", "b", "c", "d", "e"))
val rdd2 = sc.parallelize( List("d", "e"))
val result = rdd1.substract(rdd2)
println(result.collect.mkString(", "))

```

<br>

### 3.2.14. union

두 RDD에 속하는  요소로 구성된 새로운 RDD를 생성.

```scala
val rdd1 = sc.parallelize( List("a", "b", "c"))
val rdd2 = sc.parallelize( List("d", "e", "f"))
val result = rdd1.union(rdd2)
println(result.collect.mkString(", "))

```

<br>

### 3.2.15. intersection

두개의 RDD가  있을 때 rdd1과 rdd2에 동시에 속하는 요소로 구성된 새로운 RDD를 생성하는 메서드.

결과로 생성되는 RDD에는 중복된 원소가 존재하지 않는다.

```scala
val rdd1 = sc.parallelize( List( "a", "a", "b", "c"))
val rdd2 = sc.parallelize( List( "a", "a", "c", "c"))
val result = rdd1.intersection(rdd2)
println(result.collect.mkString(", "))

```

<br>

### 3.2.16. join

RDD의 구성요소가 키와 값의 쌍으로 구성된 경우에 사용할 수 있는 메서드.

서로 같은 키를 가지고 있는 요소를 모아서 그룹을 형성하고,  RDD튜플Tuple(, Tuple(RDD,  의 요소형태로 구성된다.

```scala
val rdd1 = sc.parallelize( List("a", "b", "c", "d", "e")).map((_, 1))
val rdd2 = sc.parallelize( List("b", "c", "f")).map((_, 2))
val result = rdd1.join(rdd2)
println(result.collect.mkString(", "))

```

<br>

### 3.2.17. 기타 메서드

- leftOuterJoin(), rightOuterJoin

  ```scala
  
  ```

- substractByKey

  ```scala
  
  ```

- reduceByKey

  ```scala
  
  ```

- foldByKey

  ```scala
  
  ```

- combineByKey

  •RDD의 구성요소가 키와 값의 쌍으로 구성된 경우에 사용할 수 있는 메서드

  •같은 키를 가진 값들을 하나로 병합하는 기능을 수행하는 과정에서 값의 타입이 바뀔 수 있다

  ```scala
  
  ```

- combineByKey() - 평균 구하기 예제 

  ```scala
  //콤바이너 역할을 할 Record 클래스 정의
  case class Record(var amount: Long, var number: Long=1){
     def map(v: Long) = Record(v)
     def add(amount: Long): Record = {
        add(map(amount))
  	  }
     def add(other: Record) : Record = {
        this.number += other.number 
  	  this.amount += other.amount
  	  this
  	  }
     override def toString: String = s"avg:${amount / number}"
     }
   //combineByKey()를 이용한 평균값 계산
   var data = Seq(("Math", 100L), ("Eng", 80L), ("Math", 50L), ("Eng", 60L), ("Eng", 90L))
   var rdd = sc.parallelize(data)
   var createCombiner = (v:Long) => Record(v)
   var mergeValue = (c:Record, v:Long) => c.add(v)
   var mergeCombiners = (c1:Record, c2:Record) => c1.add(c2)
   var result = rdd.combineByKey(createCombiner, mergeValue, mergeCombiners)
  
  println(result.collect.mkString("\n"))
  
  # 결과
  [Stage 0:>                                                          (0 + 0) / 1[Stage 0:>                                                          (0 + 1) / 1[Stage 0:===========================================================(1 + 0) / 1                                                                               (Math,avg:75)
  (Eng,avg:76)
  
  
  ```






- 계속

  - Transformation 계속

    - aggregateByKey()

      •RDD의 구성요소가 키와 값의 쌍으로 구성된 경우에 사용할 수 있는 메서드

      •병합을 시작할 초기값을 생성, combineByKey()와 동일한 동작을 수행

      ```scala
      var data = Seq(("Math", 100L),("Eng", 80L), ("Math", 50L), ("Eng", 70L), ("Eng", 90L))
      val rdd = sc.parallelize(data)
      //초기값
      val zero = Record(0, 0)
      val mergeValue = (c:Record, v: Long) => c.add(v)
      val mergeCombiners = (c1:Record, c2:Record) => c1.add(c2)
      //병합을 위한 초기값을 전달함!!
      val result = rdd.aggregateByKey(zero)(mergeValue, mergeCombiners)
      println(result.collect.mkString(", \t"))
      
      ```

    - pipe() - **안 됨**

      Pipe를 이용하면 데이터를 처리하는 과정에서 외부 프로세스를 활용할 수 있다.

      ```scala
      //세 개의 숫자로 구성된 문자열을 리눅스의 cut 유틸리티를 이용해 분리한 뒤 첫 번째와 세 번째 숫자를 뽑아내는 예제
      val rdd = sc.parallelize(List("1, 2, 3", "4, 5, 6", "7, 8, 9"))
      val result = rdd.pipe("cut -f 1, 3 -d,")
      println(result.collect.mkString(", "))
      
      ```

      

    - coalesce(), repartition()

      •현재의 RDD의 파티션 개수를 조정할 수 있습니다.

      •파티션의 크기를 나타내는 정수를 인자로 받아서 파티션의 수를 조정

      •repartition()이 파티션 수를 늘리거나 줄이는 것을 모두 가능

      •coalesce()는 줄이는 것만 가능

      •repartition()은 셔플을 기반으로 동작

      •coalesce()은 강제로 셔플을 수행하라는 옵션을 지정하지 않는한 셔플을 사용하지 않음

      •데이터 필터링 등의 작업으로 데이터 수가 줄어들어 파티션의 수를 줄이고자 할 때는 상대적으로 성능이 좋은 coalesce()를 사용하고, 파티션 수를 늘여야 하는 경우에만 repartition()를 사용하는 것이 좋습니다.

      ```scala
      val rdd1 = sc.parallelize( 1 to 1000000, 10)
      val rdd2 = rdd1.coalesce(5)
      val rdd3 = rdd2.repartition(10) 
      println(s"partition size:${rdd1.getNumPartitions}")
      println(s"partition size:${rdd2.getNumPartitions}")
      println(s"partition size:${rdd3.getNumPartitions}")
      
      ```

      

    - ***repartitionAndSortWithinPartitions()***

      •RDD를 구성하는 모든 데이터를 특정 기준에 따라 여러 개의 파티션으로 분리하고 각 파티션 단위로 정렬을 수행한 뒤 이 결과로 새로운 RDD를 생성해 주는 메서드

      •데이터가 키와 값 쌍으로 구성돼 있어야 하고 메서드를 실행할 때 각 데이터가 어떤 파티션에 속할지 결정하기 위한  파티셔너(Partitioner)를 설정해야 합니다.

      •파티셔너는 각 데이터의 키 값을 이용해 데이터가 속할 파티션을 결정하게 되는데, 이때 키 값을 이용한 정렬도 함께 수행됩니다.

      •파티션 재할당을 위해 셔플을 수행하는 단계에서 정렬도 함께 다루게 되어 파티션과 정렬을 각각 따로 따로 하는 것에 비해 더 높은 성능을 발휘할 수 있습니다.

      •foreachPartition() 은 RDD의 파티션 단위로 특정 함수를 실행해 주는 메서드

      ```scala
      import org.apache.spark
      
      val r = scala.util.Random
      val data = for (i <- 1 to 10) yield(r.nextInt(100), "-")
      val rdd1 = sc.parallelize(data)
      val rdd2 = rdd1.repartitionAndSortWithinPartitions(new org.apache.spark.HashPartitioner(3))
      //결과 검증
      rdd2.foreachPartition(it => { println("========"); it.foreach(v=>println(v)) })
      
      ```

      

    - sortedByKey()

      ```scala
      val textRDD = sc.textFile("/tmp/README.txt")
      val wordCandidateRDD = textRDD.flatMap(_.split("[ , .]"))
      val wordRDD = wordCandidateRDD.filter(_.matches("""\p{Alnum}+"""))
      val wordAndOnePairRDD = wordRDD.map((_, 1))
      val wordAndCountRDD = wordAndOnePairRDD.reduceByKey(_ + _)
      
      val countAndWordRDD = wordAndCountRDD.map { wordAndCount =>
          (wordAndCount._2, wordAndCount._1)
      }
      
      val sortedCWRDD = countAndWordRDD.sortByKey(false)
      val sortedWCRDD = sortedCWRDD.map { countAndWord =>
          (countAndWord._2, countAndWord._1)
      }
      
      val sortedWCArray = sortedWCRDD.collect
      sortedWCArray.foreach(println)
      
      //결과
      (the,8)
      (software,6)
      (and,6)
      (of,5)
      (The,4)
      (this,3)
      (encryption,3)
      (for,3)
      (cryptographic,3)
      (information,3)
      (country,2)
      ...
      
      ```

      

    - take()

      ```bash
      #스파크 어플리케이션 프로젝트 폴더 생성
      [hadoop@master ~]$ mkdir wordcounttop3-app
      
      [hadoop@master ~]$ cd wordcounttop3-app
      
      # 소스 코드 파일 저장 디렉토리 생성
      [hadoop@master ~]$ mkdir -p src/main/scala  
      #sbt 설정 파일 저장  디렉토리 생성
      [hadoop@master ~]$ mkdir project
      
      # 소스 코드 저장될 패키지 디렉토리 생성
      [hadoop@master ~]$ mkdir -p src/main/scala/lab/spark/example
      [hadoop@master ~]$ cd  src/main/scala/lab/spark/example
      [hadoop@master ~]$ vi WordCountTop3.scala
      
      
      [hadoop@master ~]$ cd ~/wordcounttop3-app
      [hadoop@master ~]$ vi build.sbt
      
      name := "wordcount-app"
      version := "0.1"
      scalaVersion := "2.11.12"
      libraryDependencies ++= Seq("org.apache.spark" % "spark-core_2.11" % "2.4.3" % "provided")
      assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)
      
      
      [hadoop@master ~]$ cd project
      [hadoop@master ~]$ vi plugins.sbt
      
      addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.10")
      
      
      #어플리케이션 빌드
      [hadoop@master ~]$ cd ~/wordcounttop3-app
      [hadoop@master ~]$ sbt assembly
      
      
      #WordCountTop3.scala
      #------------------------------------------
      package lab.spark.example 
      
      import org.apache.spark.{SparkConf, SparkContext}  
      
      object WordCountTop3 {
          def main(args: Array[String]) {
              require(args.length >= 1,      
                      "드라이버 프로그램의 인자에 단어를 세고자 하는 " 
                      + "파일의 경로를 지정해 주세요")    
              val conf = new SparkConf   
              val sc = new SparkContext(conf)    
              try {       
              // 모든 단어에 대해 (단어, 등장횟수)형식의 튜플을 만든다       
              val filePath = args(0)       
              val wordAndCountRDD = sc.textFile(filePath) 
                              .flatMap(_.split("[ ,.]"))   
                              .filter(_.matches("""\p{Alnum}+""")) 
                              .map((_, 1))  
                              .reduceByKey(_ + _)  
                      // 등장횟수가 가장 많은 단어 세개를 찾는다     
              val top3Words = wordAndCountRDD.map {
                                  case (word, count) => (count, word)  
                              }
                              .sortByKey(false)
                              .map {         
                                  case (count, word) => (word, count)       
                              }
                              .take(3)     
              // 등장횟수가 가장 많은 단어 톱쓰리를 표준출력으로 표시한다  
                  top3Words.foreach(println)   
              } finally {     
                  sc.stop() 
              } 
          } 
      } 
      #------------------------------------------
      
      
      # 실행
      hadoop$ spark-submit --master local --class lab.spark.example.WordCountTop3 --name WordCountTop3 ./target/scala-2.11/wordcounttop3-app-assembly-0.1.jar /tmp/README.txt
      
      # 실행 (간단하게 이렇게 해도 되네?)
      hadoop$ spark-submit --master local ./target/scala-2.11/wordcounttop3-app-assembly-0.1.jar /tmp/README.txt
      
      #결과
      (the,8)
      (software,6)
      (and,6)
      ```

      

    - ***join*** + ***boradcast***

      ```scala
      def createSalesRDD(csvFile: String) = {
          val logRDD = sc.textFile(csvFile)
          logRDD.map { record =>
              val splitRecord = record.split(",")
              val productId = splitRecord(2)
              val numOfSold = splitRecord(3).toInt
              (productId, numOfSold)
          }
      }
      
      val salesOctRDD = createSalesRDD("/data/spark/sales-october.csv")
      val salesNovRDD = createSalesRDD("/data/spark/sales-november.csv")
      
      import org.apache.spark.rdd.RDD
      def createOver50SoldRDD(rdd: RDD[(String, Int)]) = {
          rdd.reduceByKey(_ + _).filter(_._2 >= 50)
      }
      
      val octOver50SoldRDD = createOver50SoldRDD(salesOctRDD)
      val novOver50SoldRDD = createOver50SoldRDD(salesNovRDD)
      
      val bothOver50SOldRDD = octOver50SoldRDD.join(novOver50SoldRDD)
      bothOver50SOldRDD.collect.foreach(println)
      //결과
      (8,(68,72))
      (15,(80,51))
      
      
      val over50SoldAndAmountRDD = bothOver50SOldRDD.map {
          case (productId, (octAmount, novAmount)) =>
          	(productId, octAmount + novAmount)
      }
      
      over50SoldAndAmountRDD.collect.foreach(println)
      //결과
      (8,140)
      (15,131)
      
      
      import scala.collection.mutable.HashMap
      import java.io.{BufferedReader, InputStreamReader}
      import org.apache.hadoop.conf.Configuration
      import org.apache.hadoop.fs.{FileSystem, Path}
      val productsMap = new HashMap[String, (String, Int)]
      //HDFS/로컬 파일시스템을 투명하게 다루려고 하둡의  API를 이용한다.
      val hadoopConf = new Configuration
      val fileSystem = FileSystem.get(hadoopConf)
      val inputStream = fileSystem.open(new Path("/data/spark/products.csv"))
      val productsCSVReader = new BufferedReader(new InputStreamReader(inputStream))
      var line = productsCSVReader.readLine
      while(line != null) {
          val splitLine = line.split(",")
          val productId = splitLine(0)
          val productName = splitLine(1)
          val unitPrice = splitLine(2).toInt
          productsMap(productId) = (productName, unitPrice)
          line = productsCSVReader.readLine
      }
      productsCSVReader.close()
      
      val broadcastedMap = sc.broadcast(productsMap)
      val resultRDD = over50SoldAndAmountRDD.map {
          case (productId, amount) =>
          val productsMap = broadcastedMap.value
          val (productName, unitPrice) = productsMap(productId)
          (productName, amount, amount * unitPrice)
      }
      
      resultRDD.collect.foreach(println)
      //결과
      (강정(10개),140,2100000)
      (생과자(10개),131,2227000)
      
      resultRDD.saveAsTextFile("/output/oct-nov-over-50-sold")
      //파일 확인
      [hadoop@master ~]$ hadoop fs -ls -R /output/oct*
      -rw-r--r--   2 hadoop supergroup          0 2019-08-28 12:43 /output/o
      -rw-r--r--   2 hadoop supergroup         59 2019-08-28 12:43 /output/o
      [hadoop@master ~]$ hadoop fs -cat /output/oct-nov-over-50-sold/part-00
      (강정(10개),140,2100000)
      (생과자(10개),131,2227000)
      ```

      

    - accumulator

      ```scala
      package lab.spark.example
      
      import org.apache.spark.{Accumulator, SparkConf, SparkContext}
      import org.apache.spark.rdd.RDD
      
      object QuestionSummary {
      
        /**
         * 모든 앙케이트의 평가 평균값을 계산하는 메소드
         */ 
        private def computeAllAvg(rdd: RDD[(Int, String, Int)]) = {
          val (totalPoint, count) =
            rdd.map(record => (record._3, 1)).reduce {
              case ((intermedPoint, intermedCount), (point, one)) =>
                (intermedPoint + point, intermedCount + one)
            }
          totalPoint / count.toDouble
        }
      
        /**
         * 연령대별 평강의 평균값을 계산하는 메소드
         */
        private def computeAgeRangeAvg(rdd: RDD[(Int, String, Int)]) = {
          rdd.map(record => (record._1, (record._3, 1))).reduceByKey {
            case ((intermedPoint, intermedCount), (point, one)) =>
              (intermedPoint + point, intermedCount + one)
          }.map {
            case (ageRange, (totalPoint, count)) =>
              (ageRange, totalPoint / count.toDouble)
          }.collect
        }
      
        /**
         * 남녀별 평가의 평균값을 계산하는 메소드
         */
        private def computeMorFAvg(
            rdd: RDD[(Int, String, Int)],
            numMAcc: Accumulator[Int],
            totalPointMAcc: Accumulator[Int],
            numFAcc: Accumulator[Int],
            totalPointFAcc: Accumulator[Int]) = {
          rdd.foreach {
            case (_, maleOrFemale, point) =>
              maleOrFemale match {
                case "M" =>
                  numMAcc += 1
                  totalPointMAcc += point
                case "F" =>
                  numFAcc += 1
                  totalPointFAcc += point
              }
          }
          Seq(("Male", totalPointMAcc.value / numMAcc.value.toDouble),
            ("Female", totalPointFAcc.value / numFAcc.value.toDouble))
        }
      
        def main(args: Array[String]) {
          require(
            args.length >= 2,
            """
              |애플리케이션의 인자에
              |<앙케이트 CSV 파일의 경로>
              |<출력하는 결과파일의 경로>를 지정해 주세요. """.stripMargin)
      
          val conf = new SparkConf
          val sc = new SparkContext(conf)
      
          try {
            val filePath = args(0)
      
            // 앙케이트를 로드해 (연령대, 성별, 평가) 형식의
            // 튜플을 요소로 하는 RDD를 생성한다.
            val questionnaireRDD = sc.textFile(filePath).map { record =>
              val splitRecord = record.split(",")
              val ageRange = splitRecord(0).toInt / 10 * 10
              val maleOrFemale = splitRecord(1)
              val point = splitRecord(2).toInt
              (ageRange, maleOrFemale, point)
            }
      
            // questionnaireRDD는 각각의 집계처리에 이용되기 때문에 캐시에 보존한다
            questionnaireRDD.cache
      
            // 모든 평가의 평균치를 계산한다
            val avgAll = computeAllAvg(questionnaireRDD)
            // 연령대별 평균치를 계산한다
            val avgAgeRange = computeAgeRangeAvg(questionnaireRDD)
      
            // 성별이 M인 앙케이트의 건수를 세는 어큐뮬레이터
            val numMAcc = sc.accumulator(0, "Number of M")
            // 성별이 M인 앙케이트의 평가를 합계하는 어큐뮬레이터
            val totalPointMAcc = sc.accumulator(0, "Total Point of M")
            // 성별이 F인 앙케이트의 건수를 세는 어큐뮬레이터
            val numFAcc = sc.accumulator(0, "Number of F")
            // 성별이 F인 앙케이트의 평가를 합계하는 어큐뮬레이터
            val totalPointFAcc = sc.accumulator(0, "TotalPoint of F")
      
            // 남여별 평균치를 계산한다
            val avgMorF = computeMorFAvg(
              questionnaireRDD,
              numMAcc,
              totalPointMAcc,
              numFAcc,
              totalPointFAcc)
      
            println(s"AVG ALL: $avgAll")
            avgAgeRange.foreach {
              case (ageRange, avg) =>
                println(s"AVG Age Range($ageRange): $avg")
            }
      
            avgMorF.foreach {
              case (mOrF, avg) =>
                println(s"AVG $mOrF: $avg")
            }
          } finally {
            sc.stop()
          }
        }
      }
      
      //실행
      [hadoop@master questionsummary-app]$ spark-submit --master local target/scala-2.11/questionsummary-app-assembly-0.1.jar /data/spark/questionnaire.csv /output/questionnaire
      
      //결과
      AVG ALL: 3.3684210526315788
      AVG Age Range(30): 3.5
      AVG Age Range(50): 1.5
      AVG Age Range(40): 2.5
      AVG Age Range(20): 3.7142857142857144
      AVG Age Range(10): 4.0
      AVG Male: 3.5
      AVG Female: 3.272727272727273
      ```

<br>

<br>

# 4. Spark SQL

- RDD 로부터 데이터 프레임 만들고 쿼리 날리고 내장 함수 써보기

  ```scala
  import org.apache.spark.sql.hive.HiveContext
  val sqlContext = new HiveContext(sc)
  import sqlContext.implicits._
  
  case class Dessert(menuId: String, name: String, price: Int, kcal: Int)
  
  val dessertRDD = sc.textFile("/data/spark/dessert-menu.csv")
  val dessertDF = dessertRDD.map { record =>
    val splitRecord = record.split(",")
    val menuId = splitRecord(0)
    val name = splitRecord(1)
    val price = splitRecord(2).toInt
    val kcal = splitRecord(3).toInt
    Dessert(menuId, name, price, kcal)
  }.toDF
  
  dessertDF.printSchema
  
  val rowRDD = dessertDF.rdd
  val nameAndPriceRDD = rowRDD.map { row =>
    val name = row.getString(1)
    val price = row.getInt(2)
    (name, price)
  }
  
  nameAndPriceRDD.collect.foreach(println)
  
  
  dessertDF.registerTempTable("dessert_table")
  val numOver300KcalDF = sqlContext.sql(
    "SELECT count(*) AS num_of_over_300Kcal FROM dessert_table WHERE kcal >= 300"
  )
  numOver300KcalDF.show
  +-------------------+
  |num_of_over_300Kcal|
  +-------------------+
  |                  9|
  +-------------------+
  
  
  //sqlContext.sql("SELECT atan2(1, 3) AS 'ATAN2(1, 3)'").show
  sqlContext.sql("SELECT atan2(1, 3) AS ATAN13").show
  +------------------+
  |            ATAN13|
  +------------------+
  |0.3217505543966422|
  +------------------+
  
  
  sqlContext.sql("SELECT pi() AS PI, e() AS E").show
  
  +-----------------+-----------------+
  |               PI|                E|
  +-----------------+-----------------+
  |3.141592653589793|2.718281828459045|
  
  
  //-------------------------------------------
  //서브 데이터 프레임 만들기
  val nameAndPriceDF = dessertDF.select(dessertDF("name"), dessertDF("price"))
  nameAndPriceDF.printSchema
  root
   |-- name: string (nullable = true)
   |-- price: integer (nullable = false)
  
  
  val selectAllDF = dessertDF.select("*")
  selectAllDF.printSchema
  root
   |-- menuId: string (nullable = true)
   |-- name: string (nullable = true)
   |-- price: integer (nullable = false)
   |-- kcal: integer (nullable = false)
  
  
  nameAndPriceDF.show
  +---------------+-----+
  |           name|price|
  +---------------+-----+
  |  초콜릿 파르페| 4900|
  |    푸딩 파르페| 5300|
  |    딸기 파르페| 5200|
  |       판나코타| 4200|
  |      치즈 무스| 5800|
  |       아포가토| 3000|
  |       티라미스| 6000|
  |    녹차 파르페| 4500|
  |  바닐라 젤라또| 3600|
  |  카라멜 팬케익| 3900|
  |    크림 안미츠| 5000|
  |  고구마 파르페| 6500|
  |      녹차 빙수| 3800|
  |  초코 크레이프| 3700|
  |바나나 크레이프| 3300|
  |  커스터드 푸딩| 2000|
  |    초코 토르테| 3300|
  |    치즈 수플레| 2200|
  |    호박 타르트| 3400|
  |      캬라멜 롤| 3700|
  +---------------+-----+
  only showing top 20 rows
  
  selectAllDF.show(3)
  +------+-------------+-----+----+
  |menuId|         name|price|kcal|
  +------+-------------+-----+----+
  |   D-0|초콜릿 파르페| 4900| 420|
  |   D-1|  푸딩 파르페| 5300| 380|
  |   D-2|  딸기 파르페| 5200| 320|
  +------+-------------+-----+----+
  only showing top 3 rows
  
  
  //-------------------------------------------
  //Spark SQL 내장함수
  import org.apache.spark.sql.functions._
  val nameAndDollarDF = nameAndPriceDF.select($"name", $"price" /lit(1000.0))
  nameAndDollarDF.printSchema
  val nameAndDollarDF = nameAndPriceDF.select(
    $"name", ($"price" / lit(1000.0)) as "dollar price"
  )
  /*
  val nameAndDollarDF = nameAndPriceDF.select(
    $"name", ($"price" / 1000.0) as "dollar price"
  )
  */
  nameAndDollarDF.printSchema
  nameAndDollarDF.show
  
  
  //-------------------------------------------
  //필터링
  val over5200WonDF = dessertDF.where($"price" >= 5200)
  over5200WonDF.show
  +------+-------------+-----+----+
  |menuId|         name|price|kcal|
  +------+-------------+-----+----+
  |   D-1|  푸딩 파르페| 5300| 380|
  |   D-2|  딸기 파르페| 5200| 320|
  |   D-4|    치즈 무스| 5800| 288|
  |   D-6|     티라미스| 6000| 251|
  |  D-11|고구마 파르페| 6500| 650|
  +------+-------------+-----+----+
  
  val over5200WonNameDF = dessertDF.where($"price" >= 5200).select($"name")
  over5200WonNameDF.show
  +-------------+
  |         name|
  +-------------+
  |  푸딩 파르페|
  |  딸기 파르페|
  |    치즈 무스|
  |     티라미스|
  |고구마 파르페|
  +-------------+
  
  //-------------------------------------------
  //정렬
  val sortedDessertDF = dessertDF.orderBy($"price".asc, $"kcal".desc)
  sortedDessertDF.show
  +------+---------------+-----+----+
  |menuId|           name|price|kcal|
  +------+---------------+-----+----+
  |  D-15|  커스터드 푸딩| 2000| 120|
  |  D-17|    치즈 수플레| 2200| 160|
  |   D-5|       아포가토| 3000| 248|
  |  D-14|바나나 크레이프| 3300| 220|
  |  D-16|    초코 토르테| 3300| 220|
  |  D-18|    호박 타르트| 3400| 230|
  |   D-8|  바닐라 젤라또| 3600| 131|
  |  D-13|  초코 크레이프| 3700| 300|
  |  D-19|      캬라멜 롤| 3700| 230|
  |  D-12|      녹차 빙수| 3800| 320|
  |   D-9|  카라멜 팬케익| 3900| 440|
  |  D-20|      치즈 케익| 4000| 230|
  |   D-3|       판나코타| 4200| 283|
  |  D-21|      애플 파이| 4400| 350|
  |   D-7|    녹차 파르페| 4500| 380|
  |  D-22|         몽블랑| 4700| 290|
  |   D-0|  초콜릿 파르페| 4900| 420|
  |  D-10|    크림 안미츠| 5000| 250|
  |   D-2|    딸기 파르페| 5200| 320|
  |   D-1|    푸딩 파르페| 5300| 380|
  +------+---------------+-----+----+
  only showing top 20 rows
  
  
  //-------------------------------------------
  //집약처리
  val avgKcalDF = dessertDF.agg(avg($"kcal") as "avg_of_kcal")
  avgKcalDF.show
  +-----------------+
  |      avg_of_kcal|
  +-----------------+
  |291.7826086956522|
  +-----------------+
  
  
  import org.apache.spark.sql.types.DataTypes._
  val numPerPriceRangeDF = dessertDF.groupBy(
    (($"price" / 1000) cast IntegerType) * 1000
      as "price_range").agg(count($"price")).orderBy($"price_range")
  numPerPriceRangeDF.show
  +-----------+------------+
  |price_range|count(price)|
  +-----------+------------+
  |       2000|           2|
  |       3000|           9|
  |       4000|           6|
  |       5000|           4|
  |       6000|           2|
  +-----------+------------+
  
  
  
  
  //----------------------------------------
  //DataFrame 끼리의 결합
  //Join
  case class DessertOrder(sId: String, menuId: String, num: Int)
  val dessertOrderRDD = sc.textFile("/data/spark/dessert-order.csv")
  val dessertOrderDF = dessertOrderRDD.map { record =>
    val splitRecord = record.split(",")
    val sId = splitRecord(0)
    val menuId = splitRecord(1)
    val num = splitRecord(2).toInt
    DessertOrder(sId, menuId, num)
  }.toDF
  
  val amntPerMenuPerSlipDF =
    dessertDF.join(
      dessertOrderDF,
      dessertDF("menuId") === dessertOrderDF("menuId"),
      "inner"
    ).select($"sId", $"name", ($"num" * $"price")
      as "amount_per_menu_per_slip")
  
  amntPerMenuPerSlipDF.show
  +-----+-------------+------------------------+
  |  sId|         name|amount_per_menu_per_slip|
  +-----+-------------+------------------------+
  |SID-0|     판나코타|                    4200|
  |SID-2|     아포가토|                    3000|
  |SID-1|  크림 안미츠|                   20000|
  |SID-2|    치즈 케익|                    4000|
  |SID-2|바닐라 젤라또|                    3600|
  |SID-0|초콜릿 파르페|                    9800|
  +-----+-------------+------------------------+
  
  
  val amntPerSlipDF = amntPerMenuPerSlipDF.groupBy($"sId").agg(
      	sum($"amount_per_menu_per_slip") as "amount_per_slip"
  	).select($"sId", $"amount_per_slip")
  amntPerSlipDF.show
  +-----+---------------+
  |  sId|amount_per_slip|
  +-----+---------------+
  |SID-0|          14000|
  |SID-1|          20000|
  |SID-2|          10600|
  +-----+---------------+
  
  
  
  //----------------------------------------
  //스파크 SQL의 UDF 이용하기
  val strlen = sqlContext.udf.register("strlen", (str: String) => str.length)
  sqlContext.sql("SELECT strlen('Hello 스파크 SQL') AS result_of_strlen").show
  +----------------+
  |result_of_strlen|
  +----------------+
  |              13|
  +----------------+
  
  
  
  
  //---------------------------------------
  // 구조화된 각종 데이터셋 다루기
  // 파일 형식의 구조화된 데이터셋 다루기
  val dfWriter = dessertDF.write
  //아래에서 다룰 SaveMode 미리 해보기
  //import org.apache.spark.sql.SaveMode
  //dfWriter.format("parquet").mode(SaveMode.Overwrite).save("/data/spark/dessert_parquet")
  dfWriter.format("parquet").save("/data/spark/dessert_parquet")
  
  val dfReader = sqlContext.read
  val dessertDF2 = dfReader.format("parquet").load("/data/spark/dessert_parquet")
  dessertDF2.orderBy($"name").show(3) 
  +------+-------------+-----+----+
  |menuId|         name|price|kcal|
  +------+-------------+-----+----+
  |  D-11|고구마 파르페| 6500| 650|
  |  D-12|    녹차 빙수| 3800| 320|
  |   D-7|  녹차 파르페| 4500| 380|
  +------+-------------+-----+----+
  only showing top 3 rows
  
  )
  dessertDF.write.format("parquet").saveAsTable("dessert_tbl_parquet")
  sqlContext.read.format("parquet").table("dessert_tbl_parquet").show(3)
  +------+-------------+-----+----+
  |menuId|         name|price|kcal|
  +------+-------------+-----+----+
  |   D-0|초콜릿 파르페| 4900| 420|
  |   D-1|  푸딩 파르페| 5300| 380|
  |   D-2|  딸기 파르페| 5200| 320|
  +------+-------------+-----+----+
  only showing top 3 rows
  
  
  sqlContext.sql("SELECT * FROM dessert_tbl_parquet LIMIT 3").show
  +------+-------------+-----+----+
  |menuId|         name|price|kcal|
  +------+-------------+-----+----+
  |   D-0|초콜릿 파르페| 4900| 420|
  |   D-1|  푸딩 파르페| 5300| 380|
  |   D-2|  딸기 파르페| 5200| 320|
  +------+-------------+-----+----+
  
  
  //--------------------------
  //세이브 모드
  //출력 장소에 지정한 데이터셋이 이미 존재할 경우 어떻게 처리할지를 결정
  dessertDF.write.save("/data/spark/dessert_json")
  import org.apache.spark.sql.SaveMode
  dessertDF.write.format("json").mode(SaveMode.Overwrite).save("/data/spark/dessert_json")
  
  
  //---------------------------
  //명시적으로 스키마 정보 부여하기
  import java.math.BigDecimal
  case class DecimalTypeContainer(data: BigDecimal)
  val bdContainerDF = sc.parallelize(
      List(new BigDecimal("12345.6789999999999"))
  ).map(data => DecimalTypeContainer(data)).toDF    
  
  bdContainerDF.printSchema
  root
   |-- data: decimal(38,18) (nullable = true)
  
  bdContainerDF.show(false)
  +-------------------+
  |data               |
  +-------------------+
  |12345.6789999999999|
  +-------------------+
  
  
  bdContainerDF.write.format("orc").save("/data/spark/bdContainerORC")
  val bdContainerORCDF = sqlContext.read.format("orc").load("/data/spark/bdContainerORC")
  bdContainerORCDF.printSchema
  root
   |-- data: decimal(38,18) (nullable = true)
  
  bdContainerORCDF.show(false)
  +------------------------+
  |data                    |
  +------------------------+
  |12345.678999999999900000|
  +------------------------+
  
  
  //그런데 json은 자료형이 보존되지 않는다
  //JSON 포맷용 프로바이더는 파일 내용을 근거로 스키마 정보를 자동보여 하는데 이떼 실수형 데이터는 기본으로 DoubleType으로 해석되어 형변환 시 오차가 발생하는 것이다.
  dbContainerDF.write.format("json").save("/data/spark/bdContainerJSON")
  val bdContainerJSONDF = sqlContext.read.format("json").load("/data/spark/bdContainerJSON")
  bdContainerJSONDF.printSchema
  
  root
   |-- data: double (nullable = true)
  
  bdContainerJSONDF.show(false)
  +---------+
  |data     |
  +---------+
  |12345.679|
  +---------+
  
  
  //스키마 정보를 정의하려면 StructField, StructType 등 스파크 SLQ의 각 자료형에 접근해야한다.
  //org.spache.spark.sql.types.DataTypes._ 를 임포트하면 됨
  import org.apache.spark.sql.types.DataTypes._
  val schema = createStructType(Array(
  	createStructField("data", createDecimalType(38, 18), true)
  ))
  val bdContainerJSONDF = sqlContext.read.schema(schema).format("json").load("/data/spark/bdContainerJSON")
  
  bdContainerJSONDF.printSchema
  root
   |-- data: decimal(38,18) (nullable = true)
  
  bdContainerJSONDF.show(false)
  +------------------------+
  |data                    |
  +------------------------+
  |12345.678999999999900000|
  +------------------------+
  
  
  
  //---------------------------------------
  //파티셔닝 180p
  //DataFrame이 나타내는 데이터셋을 파티셔닝해서 출력할 수 있다. 파티셔닝된 데이터셋을 읽어들일 경우에는 WHERE절이나 where메서드의 필터링 조건식에 파티션을 지정함으로써 해당 파티션 이외의 데이터를 읽어들이지 않게 할 수 있다.
  import org.apache.spark.sql.types.DataTypes._
  val priceRangeDessertDF = dessertDF.select(
  	((($"price" / 1000) cast IntegerType) * 1000) as "price_range",
      dessertDF("*")
  )
  priceRangeDessertDF.write.format("parquet").
  	save("/data/spark/price_range_dessert_parquet_non_partitioned")
  priceRangeDessertDF.write.format("parquet").partitionBy("price_range").
  	save("/data/spark/price_range_dessert_parquet_partitioned")
  
  val nonPartitionedDessertDF = sqlContext.read.format("parquet").
  	load("/data/spark/price_range_dessert_parquet_non_partitioned")
  nonPartitionedDessertDF.where($"price_range" >= 5000).explain
  == Physical Plan ==
  *(1) Project [price_range#137, menuId#138, name#139, price#140, kcal#141]
  ...
  
  val partitionedDessertDF = sqlContext.read.format("parquet").
  	load("/data/spark/price_range_dessert_parquet_partitioned")
  partitionedDessertDF.where($"price_range" >= 5000).explain
  == Physical Plan ==
  *(1) FileScan parquet [menuId#148,name#149,price#150,kcal#151,price_range#152]
  ...
  
  
  ```

<br>

- 동적 쿼리

  ```sql
  # 설정파일에 설정 해 줘야 함
  # 잘 안될땐 spark 홈에서?
  $ spark-sql
  
  CREATE TABLE dessert_tbl_json USING org.apache.spark.sql.json OPTIONS (path "/data/spark/dessert_json"));
  
  SELECT name, price FROM dessert_tbl_json LIMIT 3;
  초콜릿 파르페   4900
  푸딩 파르페     5300
  딸기 파르페     5200
  Time taken: 1.047 seconds, Fetched 3 row(s)
  
  
  
  ```

- JDBC를 통해 스파크 SQL 이용하기

  ```bash
  # 넘어감
  ```

- Spark SQL 튜닝

  - cache

    ```
    //DataFrame 캐시
    df.cache()
    
    //테이블 캐시
    sqlContext.cacheTable("tbl")
    
    ```

    

  - df

  - df

  - df

  - df

  - 

## 4.1. Spark SQL API

### 4.1.1. RDD로부터 DataFrame 생성하기

```scala
import org.apache.spark.sql.hive.HiveContext
val sqlContext = new HiveContext(sc)
import sqlContext.implicits._

case class Dessert(menuId: String, name: String, price: Int, kcal: Int)

val dessertRDD = sc.textFile("/data/spark/dessert-menu.csv")
val dessertDF = dessertRDD.map { record =>
  val splitRecord = record.split(",")
  val menuId = splitRecord(0)
  val name = splitRecord(1)
  val price = splitRecord(2).toInt
  val kcal = splitRecord(3).toInt
  Dessert(menuId, name, price, kcal)
}.toDF

dessertDF.printSchema
root
 |-- menuId: string (nullable = true)
 |-- name: string (nullable = true)
 |-- price: integer (nullable = false)
 |-- kcal: integer (nullable = false)
```

<br>

### 4.1.2. DataFrame으로부터 RDD 생성하기

### 4.1.3. where

### 4.1.4. orderBy

### 4.1.5. agg

### 4.1.6. groupBy

### 4.1.7. 

<br>

<br>

<br>

# 5. Spark Streaming

![img](spark.assets/spark-streaming-datanami.png)

- 단순히 주어진 데이터를 읽고 처리하는 것 뿐만 아니라 시간의 흐름에 따라 꾸준히 변화하는 데이터를 다루기 위한 것.

- 온라인 쇼핑몰이나 웹사이트에 대한 악의적인 접근 시도를 판단하기 위한 데이터라든가 시민들에게 환경 오염이나 교통 흐름 정보를 알려주기 위한 목적으로 취합한 데이터는 시간이 지난 후에 처리하면 그 가치가 크게 떨어지므로 최대한 빠른 시간 안에 데이터를 분석하고 그 결과를 산출할 수 있어야 한다.

- 실시간으로 변화하는 데이터를 (배치처리보다) 짧은 주기에 맞춰 빠르고 안정적으로 처리하는 데 필요한 기능을 제공하는 스파크 모듈

- 짧은 주기의 배치 처리를 통해 이전 배치와 다음 배치 사이의 데이터 크기를 최소화하는 방법으로 스트리밍 데이터를 다루며, 각각의 배치 작업 사이에 새로 생성된 데이터가 하나의 RDD로 취급되어 처리됨.

  

- 넷켓(Netcat)

  >넷켓(Netcat)dms TCP나 UDP 프로토콜을 사용하는 네트워크 연결에서 데이터를 읽고 쓴느 간단한 유틸리티 프로그램이다.
  >
  >nc는 network connection에 읽거나 쓴다.
  >
  >Network connection 에서 raw-data read, write를 할수 있는 유틸리트 프로그램으로 원하는 프토로 원하는 데이터를 주고 받을 수 있는 특징때문에 해킹에도 널리 이용되며, 컴퓨터 포렌식에 있어서 라이브시스템의 데이터를 손상없이 가져오기위해서도 사용될 수 있다.

  

  - 문자 전송

    ```bash
    master $ nc -lk 9999
    
    slave1 $ nc 192.168.21.131 9999
    야 인마
    
    #결과
    master $ nc -lk 9999
    야 인마
    ```

  

  - 파일 전송

    ```bash
    #master에서
    master $ nc -l 9999 > ./listen.txt
     
    #slave1에서
    slave1 $ nc 192.168.21.131 9999 < ./input.txt
     
    #master에서 결과 확인
    master $ nc -l 9999 > ./listen.txt
    [1]+  Killed                  nc -lk 9999
    master $ cat listen.txt
    input.txt 파일의 내용이다
    잘 보내지나?
    갔냐?
    잘 받았냐고!!
    ```

- Spark에서 해보기

  ```scala
  import org.apache.spark.{SparkContext, SparkConf}
  import org.apache.spark.streaming.{Seconds, StreamingContext}
  import org.apache.spark.storage.StorageLevel
  import org.apache.log4j.{Level, Logger}
  
  Logger.getRootLogger.setLevel(Level.WARN)
  
  val ssc = new StreamingContext(sc, Seconds(10))
  
  val lines = ssc.socketTextStream("localhost", 9999, StorageLevel.MEMORY_AND_DISK_SER)
  
  val words = lines.flatMap(_.split(" "))
  
  val pairs = words.map((_, 1))
  val wordCounts = pairs.reduceByKey(_ + _)
  
  wordCounts.print()
  
  ssc.start()
  ssc.awaitTermination()
  
  ```

  

- 같은 것 file streaming

  ```scala
  //hadoop fs -mkdir /data/simple_dir
  
  import org.apache.spark.{SparkContext, SparkConf}
  import org.apache.spark.streaming.{Seconds, StreamingContext}
  import org.apache.spark.storage.StorageLevel
  import org.apache.log4j.{Level, Logger}
  
  Logger.getRootLogger.setLevel(Level.WARN)
  
  val ssc = new StreamingContext(sc, Seconds(10))
  
  val lines = ssc.textFileStream("/data/simple_dir/")
  
  val words = lines.flatMap(_.split(" "))
  
  val pairs = words.map((_, 1))
  val wordCounts = pairs.reduceByKey(_ + _)
  
  wordCounts.print()
  
  ssc.start()
  ssc.awaitTermination()
  
  // hadoop fs -put simple-word.txt /data/simple_dir/
  
  ```

  

- 센서 데이터 스트림처리

  ```scala
  //제공되는 샘플데이터가 너무 오래되어 repo가 존재하지 않아 dependency를 만족하지 못하여 컴파일이 안 됨... 패스...
  
  ```

- DStream

- Advanced Data Source

  - Kafka
  - Flume
  - Kinesis
  - Twitter

- Queue

- updateStateByKey

- Window 연산

  ![1567581572590](spark.assets/1567581572590.png)

  - StreamingContext는 정해진 주기마다 새로 생성된 데이터를 읽어서 RDD를 생성하며, 생성된 RDD는 DStream이 제공하는 API를 이용해 처리할 수 있습니다.
  - 스트리밍 데이터의 가장 마지막에 수행된 배치의 결과 뿐 아니라 이전에 수행된 배치의 결과까지 함께 사용해야 하는 경우, 윈도우 연산을 활용할 수 있습니다.
  - 윈도우 연산은 마지막 배치가 수행됐을 때 읽어온 데이터뿐 아니라 그 이전에 수행된 배치의 입력 데이터까지 한꺼번에 처리할 수 있도록 지원하는 연산입니다.
  - 윈도우 연산은 수행하기 위해서는 얼마만큼의 간격으로 윈도우 연산을 수행할 것인지와 한번 수행할 때 얼마만큼의 과거 배치 수행 결과를 가져올 것인지에 대한 정보를 지정해야 합니다.
  - spark의 window 연산은 여러 배치 들의 결과를 합쳐서 StreamingContext의 배치 간격보다 훨씬 긴 시간 간격에 대한 결과를 계산한다

  ```scala
  import org.apache.spark.streaming.StreamingContext
  import org.apache.spark.streaming.Seconds
  import scala.collection.mutable
  
  val ssc = new StreamingContext(sc, Seconds(1))
  ssc.checkpoint(".")
  val input = for (i <- mutable.Queue(1 to 100: _*)) yield sc.parallelize(i :: Nil)
  val ds = ssc.queueStream(input)
  ds.window(Seconds(3), Seconds(2)).print
  
  ds.countByWindow(Seconds(3), Seconds(2)).print
  
  ds.reduceByWindow( (a, b) => Math.max(a, b), Seconds(3), Seconds(2)).print
  
  ds.map( v => (v%2, 1)).reduceByKeyAndWindow((a: Int, b: Int) => a+b, Seconds(4), Seconds(2)).print
  
  ds.countByValueAndWindow(Seconds(3), Seconds(2)).print
  
  //위 각각의 ds 마다 테스트 해봐야 함
  ssc.start()
  
  ```

  



# 6. Spark MLlib

## 6.1. 자료형

### 6.1.1. Vectors

- 프로그램 상에서 double 타입의 값들을 포함하는 컬렉션으로 구현되며 벡터에 포함된 각 데이터는 정의된 순서에 따라 0부터 시작하는 정수형 인덱스를 부여 받습니다.

- org.apache.spark.ml.linalg 패키지에 정의된 트레이트

- Vector 인스턴스를 만들기 위해서는 값에 대한 정보만 가지고 있는 DenseVector 클래스나 값에 대한 인덱스 정보를 모두 가지고 있는 SparseVector 클래스 중 하나를 선택해서 해당 클래스의 인스턴스를 생성해야 합니다.

- desnse(), sparse() – 팩토리 메서드

  ```scala
  //static Vector	sparse(int size, int[] indices, double[] values)
  //Creates a sparse vector providing its index array and value array.
  
  
  import org.apache.spark.ml.linalg.Vectors
  val v1 = Vectors.dense(0.1, 0.0, 0.2, 0.3)
  val v2 = Vectors.dense(Array(0.1, 0.0, 0.2, 0.3))
  val v3 = Vectors.sparse(4, Seq((0, 0.1), (2, 0.2), (3, 0.3)))
  val v4 = Vectors.sparse(4, Array(0, 2, 3), Array(0.1, 0.2, 0.3))
  
  println(v1.toArray.mkString(“,"))
  println(v3.toArray.mkString(", "))
  
  scala> val v5 = Vectors.sparse(9, Array(1, 3, 5), Array(11.0, 12.0, 13.0))
  scala> println(v5.toArray.mkString(","))
  0.0,11.0,0.0,12.0,0.0,13.0,0.0,0.0,0.0
  
  ```

- 파일을 이용한 `SparseVector`  생성

  ```scala
  //파일을 이용한 SparseVector  생성
  import org.apache.spark.ml.linalg.Vectors
  import org.apache.spark.ml.feature.LabeledPoint
  import org.apache.spark.mllib.util.MLUtils
  
  val path = "file:///usr/local/spark/data/mllib/sample_libsvm_data.txt"
  val v6 = MLUtils.loadLibSVMFile(sc, path)
  val lp1 = v6.first
  
  
  println(s"label:${lp1.label}, features:${lp1.features}")
  
  scala> lp1.features.toArray
  res12: Array[Double] = Array(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 51.0, 159.0, 253.0, 159.0, 50.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, ...
  
  ```

  



### 6.1.2. LabeledPoint

변수에 레이블을 붙인다.

```scala
import org.apache.spark.ml.feature.LabeledPoint
import org.apache.spark.ml.linalg.Vectors

val v1 = Vectors.dense(0.1, 0.0, 0.2, 0.3)
val v5 = LabeledPoint(1.0, v1)

println(s"label:${v5.label}, features:${v5.features}")
//결과
label:1.0, features:[0.1,0.0,0.2,0.3]
```



##  6.2. 기본 기능

### 6.2.1. 파이프라인

> 머신러닝은 데이터 수집부터, 가공, 특성 추출, 알고리즘 적용 및 모델 생성, 평가, 배포 및 활용에 이르는 일련의 작업을 반복하며 수행됩니다.
>
> 파이프라인은 여러 종류의 알고리즘을 순차적으로 실행할 수 있게 지원하는 고차원 API이며, 파이프 라인 API를 이용해 머신러닝을 위한 워크 플로우를 생성할 수 있습니다.
>
> 파이프라인은 데이터 프레임을 사용합니다.
>
> Transformer – org.apache.spark.ml 패키지에 선언된 추상 클래스. 데이터프레임을 변형해 새로운 데이터프레임을 생성하는 용도로 사용
>
> Estimator - org.apache.spark.ml 패키지에 선언된 추상 클래스. 데이터프레임에 알고리즘을 적용해 새로운 트랜스포머를 생성하는 역할을 합니다.
>
> Pipeline - org.apache.spark.ml 패키지에 선언된 클래스. 여러 알고리즘을 순차적으로 실행할 수 있는 워크플로우를 생성하는 평가자. 하나의 파이프라인은 여러 개의 파이프라인 스테이지(PipelineStage)로 구성되며, 등록된 파이프라인 스테이지들은 우선순위에 따라 순차적으로 실행됩니다.
>
> ParamMap : 평가자나 트랜스포머에 파라미터를 전달하기 위한 목적으로 사용되는 클래스

- 예) 로지스틱 회귀

```scala
import org.apache.spark.ml.{Pipeline, PipelineModel}
import org.apache.spark.ml.classification.{LogisticRegression, LogisticRegressionModel}
import org.apache.spark.ml.feature.VectorAssembler
//import org.apache.spark.sql.SparkSession
//object PipelineSample {  
//   def main(args: Array[String]) {    
//val spark = SparkSession.builder().appName("PipelineSample") .master("local[*]").getOrCreate()

// 훈련용 데이터 (키, 몸무게, 나이, 성별)
val training = spark.createDataFrame(
    Seq(      
        (161.0, 69.87, 29, 1.0),      
        (176.78, 74.35, 34, 1.0),      
        (159.23, 58.32, 29, 0.0)
    )
).toDF("height", "weight", "age", "gender")
//빠른  계산을 위해 캐싱
training.cache() 
training.show(false) 

// 테스트용 데이터    
val test = spark.createDataFrame(
    Seq(      
        (169.4, 75.3, 42),      
        (185.1, 85.0, 37),      
        (161.6, 61.2, 28)
    )
).toDF("height", "weight", "age")    
test.show(false) 

//VectorAssembler는 특성변환 알고리즘 클래스
val assembler = new VectorAssembler().setInputCols(
    Array("height", "weight", "age")
).setOutputCol("features")

// training 데이터에 features 컬럼 추가    
val assembled_training = assembler.transform(training)
assembled_training.show(false)

// 모델 생성 알고리즘 (로지스틱 회귀 평가자 - 이진분류 알고리즘)   
val lr = new LogisticRegression().setMaxIter(10).setRegParam(0.01).setLabelCol("gender") 

// 모델 생성    
val model = lr.fit(assembled_training)  

// 예측값 생성    
model.transform(assembled_training).show()    

// 파이프라인 (트랜스포머와 평가자를 하나의 파이프라인으로 묶어서 워크 플로우 생성)
val pipeline = new Pipeline().setStages(Array(assembler, lr))    

// 파이프라인 모델 생성    
val pipelineModel = pipeline.fit(training)    

// 파이프라인 모델을 이용한 예측값 생성    
pipelineModel.transform(training).show()    

// 모델 저장 
val path1 = "/output/sparkmllib/regression-model"    
val path2 = "/output/sparkmllib/pipeline-model"    
model.write.overwrite().save(path1)    
pipelineModel.write.overwrite().save(path2)    

// 저장된 모델 불러오기   
val loadedModel = LogisticRegressionModel.load(path1)    
val loadedPipelineModel = PipelineModel.load(path2) 

//저장된 모델이 잘 작동하는 지 확인
loadedModel.transform(assembled_training).show()
loadedPipelineModel.transform(training).show()

//파이프라인 모델로 test 데이터를 예측해보기!!
loadedPipelineModel.transform(test).show()
+------+------+---+-----------------+--------------------+--------------------+----------+
|height|weight|age|         features|       rawPrediction|         probability|prediction|
+------+------+---+-----------------+--------------------+--------------------+----------+
| 169.4|  75.3| 42|[169.4,75.3,42.0]|[-3.0855217899660...|[0.04370843319542...|       1.0|
| 185.1|  85.0| 37|[185.1,85.0,37.0]|[-4.8418050943384...|[0.00783098559169...|       1.0|
| 161.6|  61.2| 28|[161.6,61.2,28.0]|[1.56028508363867...|[0.82639425682107...|       0.0|
+------+------+---+-----------------+--------------------+--------------------+----------+


//spark.stop
```

Java 코드

```java
import org.apache.spark.ml.Pipeline;
import org.apache.spark.ml.PipelineModel;
import org.apache.spark.ml.PipelineStage;
import org.apache.spark.ml.classification.LogisticRegression;
import org.apache.spark.ml.classification.LogisticRegressionModel;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import java.util.Arrays;
import java.util.List;
public class PipelineSample {
public static void main(String[] args) throws Exception {
    SparkSession spark = SparkSession.builder()
            .appName("PipelineSample")
            .master("local[*]")
 .getOrCreate();
   StructField sf1 = DataTypes.createStructField("height", DataTypes.DoubleType, true);
   StructField sf2 = DataTypes.createStructField("weight", DataTypes.DoubleType, true);
   StructField sf3 = DataTypes.createStructField("age", DataTypes.IntegerType, true);
   StructField sf4 = DataTypes.createStructField("label", DataTypes.DoubleType, true);
  StructType schema1 = DataTypes.createStructType(Arrays.asList(sf1, sf2, sf3, sf4));
    List<Row> rows1 = Arrays.asList(RowFactory.create(161.0, 69.87, 29, 1.0),
        RowFactory.create(176.78, 74.35, 34, 1.0),
            RowFactory.create(159.23, 58.32, 29, 0.0));
    // 훈련용 데이터 (키, 몸무게, 나이, 성별)
    Dataset<Row> training = spark.createDataFrame(rows1, schema1);
training.cache();
List<Row> rows2 = Arrays.asList(RowFactory.create(169.4, 75.3, 42),
            RowFactory.create(185.1, 85.0, 37),
            RowFactory.create(161.6, 61.2, 28));
    StructType schema2 = DataTypes.createStructType(Arrays.asList(sf1, sf2, sf3));
    // 테스트용 데이터
    Dataset<Row> test = spark.createDataFrame(rows2, schema2);
   training.show(false);
   VectorAssembler assembler = new VectorAssembler();
    assembler.setInputCols(new String[]{"height", "weight", "age"});
   assembler.setOutputCol("features");
   Dataset<Row> assembled_training = assembler.transform(training);
  assembled_training.show(false);
// 모델 생성 알고리즘 (로지스틱 회귀 평가자)
 LogisticRegression lr = new LogisticRegression();
 lr.setMaxIter(10).setRegParam(0.01);
 // 모델 생성
   LogisticRegressionModel model = lr.fit(assembled_training);
 // 예측값 생성
 model.transform(assembled_training).show();
    // 파이프라인
   Pipeline pipeline = new Pipeline();
    pipeline.setStages(new PipelineStage[]{assembler, lr});
    // 파이프라인 모델 생성
   PipelineModel pipelineModel = pipeline.fit(training); 
    // 파이프라인 모델을 이용한 예측값 생성
    pipelineModel.transform(training).show();
    String path1 = "/output/sparkmllib/regression-model" ;
    String path2 = "/output/sparkmllib/pipelinemodel";
    // 모델 저장
   model.write().overwrite().save(path1);
   pipelineModel.write().overwrite().save(path2);
    // 저장된 모델 불러오기
  LogisticRegressionModel loadedModel = LogisticRegressionModel.load(path1);
  PipelineModel loadedPipelineModel = PipelineModel.load(path2);
    spark.stop();
  }
}

```

python 코드

```python
from pyspark.ml.classification import LogisticRegression
from pyspark.ml.classification import LogisticRegressionModel
from pyspark.ml.feature import VectorAssembler
from pyspark.ml.pipeline import Pipeline
from pyspark.ml.pipeline import PipelineModel
from pyspark.sql import SparkSession
spark = SparkSession
.builde
.appName("pipeline_sample")
.master("local[*]")
.getOrCreate()
# 훈련용 데이터 (키, 몸무게, 나이, 성별)
training = spark.createDataFrame([
  (161.0, 69.87, 29, 1.0),
 (176.78, 74.35, 34, 1.0),
(159.23, 58.32, 29, 0.0)]).toDF("height", "weight", "age", "gender")
training.cache()
# 테스트용 데이터
test = spark.createDataFrame([
(169.4, 75.3, 42),
 (185.1, 85.0, 37),
(161.6, 61.2, 28)]).toDF("height", "weight", "age")
training.show(truncate=False)
assembler = VectorAssembler(inputCols=["height", "weight", "age"], outputCol="features")
# training 데이터에 features 컬럼 추가
assembled_training = assembler.transform(training)
assembled_training.show(truncate=False)
# 모델 생성 알고리즘 (로지스틱 회귀 평가자)
lr = LogisticRegression(maxIter=10, regParam=0.01, labelCol="gender")
# 모델 생성
model = lr.fit(assembled_training)
# 예측값 생성
model.transform(assembled_training).show()
# 파이프라인
pipeline = Pipeline(stages=[assembler, lr])
# 파이프라인 모델 생성
pipelineModel = pipeline.fit(training)
# 파이프라인 모델을 이용한 예측값 생성
pipelineModel.transform(training).show()
 
  path1 = "/output/sparkmllib/regression-model" 
  path2 = "/output/sparkmllib/pipelinemodel" 
# 모델 저장
model.write().overwrite().save(path1)
pipelineModel.write().overwrite().save(path2)
# 저장된 모델 불러오기
loadedModel = LogisticRegressionModel.load(path1)
loadedPipelineModel = PipelineModel.load(path2)
spark.stop
```

## 6.3 알고리즘

### 6.3.1. Tokenizer

- Tokenizer – 공백 문자를 기준으로 입력 문자열을 개별 단어의 배열로 변환하고 이 배열을 값으로 하는 새로운 컬럼을 생성하는 트랜스포머. 문자열을 기반으로 하는 특성 처리에 자주 사용됨

- RegexTokenizer – 정규식을 사용하여 문자열을 기반으로 하는 특성 처리  

```scala

```





## 6.4 k-means 

```scala
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors
val sparkHome = sys.env("SPARK_HOME")
val data = sc.textFile (
    "file://" + sparkHome + "/data/mllib/kmeans_data.txt"
)
val parsedData = data.map{ s =>
    Vectors.dense(
        s.split(' ').map(_.toDouble)
    )
}.cache()
val numClusters = 2
val numIterations = 20
val clusters = KMeans.train(parsedData, numClusters, numIterations)
clusters.k
clusters.clusterCenters

val vec1 = Vectors.dense(0.3, 0.3, 0.3)
clusters.predict(vec1)
res2: Int = 1

val vec2 = Vectors.dense(8.0, 8.0, 8.0)
clusters.predict(vec2)
res2: Int = 0

parsedData.foreach(vec =>
	println(vec + " => " + clusters.predict(vec))
)
[0.0,0.0,0.0] => 1
[0.1,0.1,0.1] => 1
[0.2,0.2,0.2] => 1
[9.0,9.0,9.0] => 0
[9.1,9.1,9.1] => 0
[9.2,9.2,9.2] => 0

//저장
val predictedLabels = parsedData.map(vector => clusters.predict(vector))
predictedLabels.saveAsTextFile("output")

//계산된 모델을 저장
clusters.save(sc, "kmenas_model")

//모델 metadata 보기
 $ hadoop fs -cat /user/hadoop/kmeans_model/metadata/part-00000
{"class":"org.apache.spark.mllib.clustering.KMeansModel","version":"2.0","k":3,"distanceMeasure":"euclidean","trainingCost":0.07500000000004324}
```

※ K 값을 몇 개로 하는게 좋을까?

```scala
val WSSSE = clusters.computeCost(parsedData)
println("Within Set Sum of Squared Errors = " + WSSSE)
Within Set Sum of Squared Errors = 0.11999999999994547
```



- 문서에서 단어 추출하기(형태소 분석)

  ```scala
  // 형태소 분석은 MLlib에 포함되지 않지만, 이 예에서는 한 문장씩만 분석하면 충분하므로, 기존의 간단한 형태소 분석 라이브러리를 스파크의 분산처리 태스크에서 이용하도록 구현해본다. 이 예에서는 트위터가 만든 twitter-korean-text를 이용한다.
  
  // libraryDependencies += "com.twitter.penguin" %% "korean-text" % "4.0"
  $ ${SPARK_HOME}/bin/spark-shell --master yarn --packages com.twitter.penguin:korean-text:4.0
  
  Spark session available as 'spark'.
  Welcome to
        ____              __
       / __/__  ___ _____/ /__
      _\ \/ _ \/ _ `/ __/  '_/
     /___/ .__/\_,_/_/ /_/\_\   version 2.4.3
        /_/
  
  Using Scala version 2.11.12 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_221)
  Type in expressions to have them evaluated.
  Type :help for more information.
  
  //---------------------------------------
  $ spark-shell --master yarn --packages com.twitter.penguin:korean-text:4.0 --conf spark.serializer=org.apache.spark.serializer.KryoSerializer
  
  import java.io.StringReader
  import org.apache.spark.mllib.feature.{Word2Vec, Word2VecModel}
  import com.twitter.penguin.korean.TwitterKoreanProcessor
  import com.twitter.penguin.korean.tokenizer.KoreanTokenizer.KoreanToken
  import org.apache.spark.mllib.linalg.Vectors
  
  val sentence = "이 책은 무슨 책 입니까"
  val normalized: CharSequence = TwitterKoreanProcessor.normalize(sentence)
  
  //토크나이즈
  val tokens: Seq[KoreanToken] = TwitterKoreanProcessor.tokenize(normalized)
  tokens: Seq[com.twitter.penguin.korean.tokenizer.KoreanTokenizer.KoreanToken] = List(이(Noun: 0, 1),  (Space: 1, 1), 책(Noun: 2, 1), 은(Josa: 3, 1),  (Space: 4, 1), 무슨(Noun: 5, 2),  (Space: 7, 1), 책(Noun: 8, 1),  (Space: 9, 1), 입(Noun: 10, 1), 니까(Josa: 11, 2))
  
  //어근 추출
  val stemmed: Seq[KoreanToken] = TwitterKoreanProcessor.stem(tokens)
  stemmed: Seq[com.twitter.penguin.korean.tokenizer.KoreanTokenizer.KoreanToken] = List(이(Noun: 0, 1),  (Space: 1, 1), 책(Noun: 2, 1), 은(Josa: 3, 1),  (Space: 4, 1), 무슨(Noun: 5, 2),  (Space: 7, 1), 책(Noun: 8, 1),  (Space: 9, 1), 입(Noun: 10, 1), 니까(Josa: 11, 2))
  
  
  
  ```

- 유사 단어 추출

  ```scala
  //위 환경 이어서 해야함
  
  //스파크에서 텍스트를 읽고 처리하는 내용을 기술한다.
  //SparkContext의 textFile 메서드를 이요해 입력용 RDD를 정의한다.
  //이때 입력 텍스트 파일의 각 줄을 인수로 받고 각 줄에 대해 tokenize메서드를 적용
  val input = sc.textFile("/data/spark/hanguel-article.txt").map(line => TwitterKoreanProcessor.tokensToStrings(TwitterKoreanProcessor.tokenize(TwitterKoreanProcessor.normalize(line))))
  
  //Word2Vec에 단어의 출현횟수의 최솟값과 생성하는 벡터의 ㅊ원 수를 인수로 건네준다.
  val word2vec = new Word2Vec()
  word2vec.setMinCount(3)
  word2vec.setVectorSize(30)
  //fit메서드로 단어와 벡터가 포함된 모델을 생성한다. 이때 내부적으로 스파크의 액션이 실행되므로 스프카의 분산처리가 예약ㄷ괸다. 로그 레벨을 특별히 변경하지 않은 상태라면, 스파크 셸의 표준 출력으로 분산처리가 진행되는 상황이 출력될 것이다.
  val model = word2vec.fit(input)
  
  //특정한 단어와 유사한 단어를 추출해본다.
  //findSynonyms 라는 메서드를 이용하면 주어진 단어와 유사한 단어 상위 N개와 유사도(벡터간의 코사인 유사도)를 함께 얻을 수 있다. 또한 스파크 셸에서 실행하면 정의한 식의 결괏값을 println처럼 명시적으로 출력하지 않아도 표준 출력으로 출력할 수 있다.
  model.findSynonyms("소년", 3)
  
  //비커즈라는 소설책을 넣었더니...
  model.findSynonyms("인간", 3)
  res18: Array[(String, Double)] = Array((드래곤,0.8470436930656433), (오크,0.7707846760749817), (보통,0.7554001212120056))
  
  model.findSynonyms("사랑", 3)
  res27: Array[(String, Double)] = Array((자기,0.7772539258003235), (간섭,0.7626800537109375), (부담,0.759609580039978))
  ```

  

- 단어 관계성 벡터 연산

  ```scala
  def relationWords(w1: String, w2: String, target: String, model: Word2VecModel) :Array[(String, Double)] = {
      //scala의 행렬계산 등을 가능하게 하는 Breeze 라이브러리를 이용한다.
      val b = breeze.linalg.Vector(model.getVectors(w1))
      val a = breeze.linalg.Vector(model.getVectors(w2))
      val c = breeze.linalg.Vector(model.getVectors(target))
      
      //target에 w2-w1의 관계성을 적용한다.
      val x = c + (a - b)
      
      //관계성이 적용된 x와 유사한 단어를 찾는다.
      model.findSynonyms(Vectors.dense(x.toArray.map(_.toDouble)), 10)
  }
  
  relationWords("남자", "여자", "사랑", model)
  res34: Array[(String, Double)] = Array((성장한,0.6855924129486084), (똑같,0.6855884194374084), (가르침,0.6750491261482239), (불능,0.6736375093460083), (훌륭한,0.6527679562568665), (보신,0.6462168097496033), (......!!",0.643253743648529), (농락,0.6370927691459656), (나서서,0.6370558738708496), (사랑,0.6349859833717346))
  
  
  ```





# 복습 - 1

## Spark?

### 구성 요소

- 클러스터 매니저
- SparkCore
- Spark SQL
- Spark Streaming - 실시간 처리
- MLlib
- Graph X

<br>

### RDD

Spark에서 데이터를 처리하기 위해 추상화된 모델. 복구 가능한 분산 데이터.

<br>

### SparkApplication 구현 단계

1. *SparkContext*생성 (애플리케이션과 스파크 클러스터와의 연결을 담당

   - Spark 애플리케이션과 Spark 클러스터와의 연결을 담당하는 객체
   - 모든 스파크 애플리케이션은 SparkContext를 이용해 RDD나 accumulator, broadcast 변수 등을 다룬다.
   - Spark 애플리케이션을 수행하는데 필요한 각종 설정 정보를 담는 역할

2. *RDD*(내결함성 불변 데이터 모델) 생성

   collection, HDFS, hive, CSV 등 여러 소스로부터 생성 가틍

3. transformation

   변환연산(RDD 요소의 구조 변경. filter/grouping 등)

4. action

   집계/요약 처리

5. 영속화

<br>

### Spark 클러스터 환경에서 node들

```SparkClient```, ```Master 노드```, ```Worker 노드```

- SparkClient - SparkApplication 을 배포하고 실행을 요청

- Spark Master 노드 - Spark 클러스터 환경에서 사용가능한 리소스들의 관리

- Spark Worker 노드 - 할당 받은 리소스(CPU core, memory) 를 사용해서 작업을 수행

- executor - SparkWorker 노드에서 실행되는 프로세스

  RDD의 partition을...

<br>

### Spark 장점

- 반복처리와 연속으로 이루어지는 변환처리를 고속화(메모리 기반)
- 딥러닝, 머신러닝등의 실행환경에 적합한 환경 제공
- 서로 다른 실행환경과 구조, 데이터들의 처리에 대해서 통합 환경 제공

<br>

### 대표적인  메서드

- sc.textFile() : file 로 부터 RDD 생성
- collect
- map, flatMap
- mkString(["구분자"])

<br>

<br>

<br>

# 복습 - 2

## dd

