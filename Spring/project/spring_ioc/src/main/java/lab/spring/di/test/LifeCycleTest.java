package lab.spring.di.test;


import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import lab.spring.di.service.HelloService;

public class LifeCycleTest {

	public static void main(String[] args) {

		Resource resource = new ClassPathResource("application.xml");
		XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
		
		String beanName = "service";
		HelloService service = beanFactory.getBean(beanName, HelloService.class);
		service.sayHello();
		
		//컨테이너로부터 bean 제거
		beanFactory.removeBeanDefinition(beanName);
		
	}

}
