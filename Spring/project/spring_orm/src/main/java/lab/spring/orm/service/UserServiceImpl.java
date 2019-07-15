package lab.spring.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.orm.dao.UserDAO;
import lab.spring.orm.model.UserVO;

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

}
