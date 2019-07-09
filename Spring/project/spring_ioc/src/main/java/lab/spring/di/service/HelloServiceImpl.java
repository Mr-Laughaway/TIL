package lab.spring.di.service;

import lab.spring.di.persist.Message;

public class HelloServiceImpl implements HelloService {
	
	private Message message;
	
	/*
	public void setMessage(Message message) {
		this.message = message;
	}
	*/
	
	public HelloServiceImpl() {
		super();
	}
	
	
	public HelloServiceImpl(Message message) {
		super();
		this.message = message;
		System.out.println("생성자를 이용한 Bean 주입");
	}
	

	public void sayHello() {
		System.out.println(message.getMessage());
	}


}
