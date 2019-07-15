package lab.spring.di.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lab.spring.di.service.HelloService;

public class ContainerDITest {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("application.xml");
		
		String beanName = "hello";
		HelloService service = context.getBean(beanName, HelloService.class);
		service.sayHello();
		
		
		HelloService service2 = 
				context.getBean(beanName, HelloService.class);
		
		
		System.out.println(service == service2);
		
		
		HelloService service3 = context.getBean("service", HelloService.class);
		
		service3.sayHello();
	}

}
