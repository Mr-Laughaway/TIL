package lab.spring.orm;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lab.spring.orm.model.UserVO;
import lab.spring.orm.service.UserService;

public class SpringMybatisTest {

	public static void main(String[] args) throws IOException {
		
		String[] configs = new String[] {"application.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(configs);
		
		UserService service = context.getBean("userService", UserService.class);
		
		System.out.println("###### 전체 목록 #######");
		List<UserVO> list = service.findUserList();
		Iterator<UserVO> iter = list.iterator();
		while(iter.hasNext()) {
			UserVO u = iter.next();
			System.out.println(u);
		}
		
		
		UserVO vo = new UserVO();
		vo.setUserid("s4");;
		vo.setUsername("서울3");
		vo.setUserpwd("1234");
		vo.setEmail("seoul@korea.or.kr");
		vo.setPhone("02-129");
		vo.setAddress("서울");
		vo.setJob("IT 개발");
		System.out.println("insert rows => " + service.addUser(vo));
		System.out.println("###############s4 아이디 한행 검색 ###########");
		System.out.println(service.findUser("s4"));
		
		vo.setUserid("s4");
		vo.setEmail("s4@gmai.or.kr");
		vo.setPhone("02-129-1234");
		vo.setAddress("부산");
		vo.setJob("데이터 분석");
		System.out.println("update : s4 => " + service.updateUser(vo));
		System.out.println(service.findUser("s4"));
		System.out.println("delete : s4 => " + service.removeUser("s4"));
		
		System.out.println("###### 전체 목록 #######");
		list = service.findUserList();
		iter = list.iterator();
		while(iter.hasNext()) {
			UserVO u = iter.next();
			System.out.println(u);
		}
	}

}
