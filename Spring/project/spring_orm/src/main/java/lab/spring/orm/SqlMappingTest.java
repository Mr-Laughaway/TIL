package lab.spring.orm;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import lab.spring.orm.dao.UserManageDAO;
import lab.spring.orm.model.UserVO;

public class SqlMappingTest {

	public static void main(String[] args) throws IOException {
		
		String resource = "mybatis-config.xml"; //MyBatis 설정 파일
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory 
			= new SqlSessionFactoryBuilder().build(inputStream);
		
		UserManageDAO userDao = new UserManageDAO();
		userDao.setSqlSessionFactory(sqlSessionFactory);
		
		
		System.out.println("###### 전체 목록 ######");
		List<UserVO> list = userDao.findUserList();
		Iterator<UserVO> iter = list.iterator();
		while(iter.hasNext()) {
			UserVO u = iter.next();
			System.out.println(u);
		}
		
		
		UserVO vo = new UserVO();
		vo.setUserid("s5");;
		vo.setUsername("서울5");
		vo.setUserpwd("1234");
		vo.setEmail("seoul5@korea.or.kr");
		vo.setPhone("02-129");
		vo.setAddress("서울");
		vo.setJob("IT 개발");
		System.out.println("insert rows => " + userDao.addUser(vo));
		System.out.println("###############s5 아이디 한행 검색 ###########");
		System.out.println(userDao.findUser("s5"));
		
		vo.setUserid("s5");
		vo.setEmail("s5@gmail.or.kr");
		vo.setPhone("02-129-1234");
		vo.setAddress("부산");
		vo.setJob("데이터 분석");
		System.out.println("update : s5 => " + userDao.updateUser(vo));
		System.out.println(userDao.findUser("s5"));
		System.out.println("delete : s5 => " + userDao.removeUser("s5"));
		
		System.out.println("###### 전체 목록 #######");
		list = userDao.findUserList();
		iter = list.iterator();
		while(iter.hasNext()) {
			UserVO u = iter.next();
			System.out.println(u);
		}
	}

}
