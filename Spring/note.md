### Spring Framework

- 경량 컨테이너 제공(객체에 대한 실행환경 제공)

- IoC 컨테이너 (Factory 패턴 적용)

  - 의존하는 객체를 직접 생성하지 않고, 생성하여 전달하는 방식
  - ↑ DI

- AOP(관점 지향 프로그래밍)

  핵심 로직과 공통 로직을 분리해서 핵심 로직수행할 때 공통 로직을 적용. Spring의 경우 proxy를 적용한다.

- POJO(Plain Old Java Object) 로 Bean을 정의하여 사용한다.

  특정 라이브러리 등에 종속되지 않고 간단하고 자유로운 방식으로 사용가능하다.

- 영속성과 관련된 다양한 API(Hibername, MyBatis, JDO, ...) 지원
- 트랜잭션 처리를 일관된 방법으로 처리, 관리 지원
- 배치 처리, 메시지 처리 등 다양한 API 지원
- ***Framework을 위한 Framework!!!***



##### Spring Framework 모듈

- Spring Core 모듈 - IoC 기능 지원(BeanFactory 등)
- Spring Context 모듈 - Core에서 지원하는 기능 외에 추가적인 기능들 지원(JNDI, EJB 등 지원). ApplicationContext 등
- Spring AOP 모듈 - 관점 지향 프로그래밍 지원
- Spring DAO 모듈 - JDBC보다 더 쉽고 간결하게 개발 가능
- Spring ORM 모듈 - Hibernate, MyBatis, JDO, ...와으 결합, 통합을 지원
- Spring Web 모듈 - MVC 패턴이 적용된 Web App 개발 지원(struts, webwork 등)

- Spring Web MVC모듈 - 다양한 Web UI, 기술 등의 API 지원



##### 의존객체 주입 방식

- 생성자를 통해 주입
- set 메서드를 이용해서 주입



##### Bean 설정 방식

- xml 설정 방식

  ```xml
  <bean id="xxx" name="x" class="xxx.xxx.xxx.xxx" >
      <constructor-arg ref="yyy" />
      <property type="" index="" value="" ref="zzz" />
  </bean>
  ```

- 자바 클래스와 Annotation

  - @Configuration
  - bean을 리턴하는 메서드 선언부에 @Bean 선언, bean의 이름은 메서드 이름
  - 요청시 ```컨테이너객체.getBean("빈이름", 빈타입.class)```

※ ***Spring 컨테이너의 default 빈 Scope 는 singleton 입니다.***





