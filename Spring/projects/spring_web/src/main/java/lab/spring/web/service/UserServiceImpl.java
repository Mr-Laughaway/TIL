package lab.spring.web.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.web.dao.UserDAO;
import lab.spring.web.model.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO dao;

	@Override
	public int addUser(UserVO user) {
		return dao.addUser(user);
	}

	@Override
	public int updateUser(UserVO user) {
		return dao.updateUser(user);
	}

	@Override
	public int removeUser(String uid) {
		return dao.removeUser(uid);
	}

	@Override
	public UserVO findUser(String uid) {
		return dao.findUser(uid);
	}

	@Override
	public UserVO login(String uid, String upwd) {
		return dao.login(uid, upwd);
	}

	@Override
	public List<UserVO> findUserList() {
		return dao.findUserList();
	}

	@Override
	public List<UserVO> findUser(String condition, String keyword) {
		return dao.findUser(condition, keyword);
	}
	
	

}
