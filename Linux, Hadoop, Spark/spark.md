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

    

  - ㅇㄹ

  - ㅇㄹ

  - 



