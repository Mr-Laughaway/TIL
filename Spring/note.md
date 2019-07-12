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





```xml
<bean id="target" class=""/>
<bean id="advice" class="" />
<aop:aspect>
    <aop:pointcut ref="target">
        
    </aop:pointcut>
</aop:aspect>

```





```
drop table products purge;

create table products (
prodnum    number(8)  primary key ,   제품번호
pname      varchar2(30),   --상품 이름
category   varchar2(30), --상품 분류
description  varchar2(1000),--상품 특성, 설명
filename    varchar2(100),        ----이미지 파일 경로
manufacturer  varchar2(50), --제조사
unitPrice    number(7),     --개당 가격
unitsInStock   number(5)    --제고
);

 


--샘플 데이터 
insert into products ( prodnum ,pname, unitPrice, Description, Category, Manufacturer, UnitsInStock,  Condition,  Filename )
values ( 'P1234', 'iPhone 6s',800000, '4.7-inch, 1334X750 Renina HD display 8-megapixel iSight Camera,);
'Smart Phone','Apple', 1000, 'New', 'P1234.png');

insert into products ( prodnum ,pname, unitPrice, Description, Category, Manufacturer, UnitsInStock,  Condition,  Filename )
values ( 'P1235','LG PC 그램',
1500000,
'13.3-inch, IPS LED display, 5rd Generation Intel Core processors',
'Notebook',
'LG',
1000,
'Refurbished',
'P1235.png');

insert into products ( prodnum ,pname, unitPrice, Description, Category, Manufacturer, UnitsInStock,  Condition,  Filename )
values ( 'P1236',
'Galaxy Tab S',
900000,
'212.8*125.6*6.6mm,  Super AMOLED display, Octa-Core processor',
'Tablet',
'Samsung',
1000,
'Old',
'P1236.png');
commit;


select * from products;

select * from products where prodnum =? ;

select * from products where unitPrice between ? and ?;


update products set unitPrice = ?, UnitsInStock=?  where prodnum = ? ;

delete from products  where prodnum = ? ;
 
 
===========================================================
1. maven 프로젝트 생성 (pom.xml)
2. mapper 파일 설정  (ProductMapper.xml)
3. spring 설정 파일 설정  (application.xml)
4. 엔티티 클래스 생성
5. DAO 클래스 생성
6. 서비스 클래스 생성
7. test 클래스 생성 실행 결과 보기
 
 
 
 
public class SpringMybatisTest {

	public static void main(String[] args) {
		String[] configs = new String[]{"application.xml"};
		ApplicationContext context = 
				   new ClassPathXmlApplicationContext(configs);
		UserService service = 
				context.getBean("productService", ProductService.class);
		System.out.println("#######전체 상품 목록 ###########");
		List<Product> lists = service.findProductList();
		Iterator<Product> iter = lists.iterator();
		while (iter.hasNext()) {
			Product u = iter.next();
			System.out.println(u);
		}
		
		Product p = new Product();
        p.setProductId("B1000");
    	p.setPname("Spring과 MyBatis");
    	p.setCategory("Book");
    	p.setDescription("프로젝트로 배우는 프레임워크");
    	p.setFilename("spring.jpeg");
    	p.setManufacturer("멀티캠퍼스");
    	p.setUnitPrice(10000);
    	p.setUnitsInStock(300); 
		 
		System.out.println("insert rows = >" + service.addProduct(p));		
		System.out.println("#######s3 아이디 한행 검색 ###########"); 
		System.out.println(service.findProduct("s3"));		
		
		p.setUnitPrice(15000);
    			p.setUnitsInStock(200);  
    			p.setFilename('spring-mybatis.jpeg');
		System.out.println("update :s3 =>"+service.updateProduct(p));
		System.out.println(service.findProduct"s3"));
		System.out.println("delete :s3 =>"+service.removeProduct("s3"));
		System.out.println("#######전체 상품목록 ###########");
		 lists = service.findProductList();
		 iter = lists.iterator();
		while (iter.hasNext()) {
			Product u = iter.next();
			System.out.println(u);
		}
	}
 
```



