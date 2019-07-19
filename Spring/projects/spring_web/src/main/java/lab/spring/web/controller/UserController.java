package lab.spring.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.web.model.SearchVO;
import lab.spring.web.model.UserVO;
import lab.spring.web.model.UserValidator;
import lab.spring.web.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;

	@RequestMapping(value="/add.do", method=RequestMethod.GET)
	public String joinForm() {
		return "userForm";
	}
	
	/*
	@RequestMapping(value="/add.do", method=RequestMethod.POST)
	public ModelAndView joinUser(UserVO user) {
		ModelAndView mav = new ModelAndView();
		int row = service.addUser(user);
		mav.setViewName("redirect:/list.do");
		
		return mav;
	}
	*/
	
	@RequestMapping(value="/add.do", method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") UserVO vo, BindingResult rs) {
		
		
		
		ModelAndView mav = new ModelAndView();
		
		new UserValidator().validate(vo, rs);
		if(rs.hasErrors()) {
			mav.setViewName("userForm");
		}
		else if(service.addUser(vo) > 0) {
			mav.setViewName("redirect:/list.do");
		}
		else {
			mav.setViewName("redirect:/login.do");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/listJson.do")
	public List<UserVO> userList() {
		List<UserVO> list = null;
		list = service.findUserList();
		return list;
	}
	
	
	@ModelAttribute("searchConditionList")
	public ArrayList<SearchVO> makeSearchConditionList() {
		ArrayList<SearchVO> searchConditionList = new ArrayList<SearchVO>();
		searchConditionList.add(new SearchVO("userid", "아이디"));
		searchConditionList.add(new SearchVO("username", "이름"));
		searchConditionList.add(new SearchVO("email", "이메일"));
		return searchConditionList;
	}
	
	@RequestMapping(value="/list.do")
	public ModelAndView userList(HttpSession session) {
		ModelAndView mav = new ModelAndView();
//		if(session.getAttribute("authInfo")!=null) {
		List<UserVO> list = service.findUserList();
		mav.addObject("users", list);
		mav.setViewName("userList");
//		} else {
//			mav.setViewName("redirect:/login.do");
//		}
	
		return mav;
	}
	
	@RequestMapping(value="/modify.do", method=RequestMethod.GET)
	public ModelAndView showUser(String userid) {
		ModelAndView mav = new ModelAndView();
		
		UserVO user = null;
		if(userid != null)
			user = service.findUser(userid);
		mav.addObject("user", user);
		mav.setViewName("userModify");
	
		return mav;
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public ModelAndView modifyUser(@ModelAttribute("user") UserVO vo ) {
		
		ModelAndView mav = new ModelAndView();
		
		if( service.updateUser(vo) > 0 ) {
			mav.setViewName("redirect:/list.do");
		}
		else {
			mav.setViewName("redirect:/modify.do?userid="+vo.getUserid());
		}
	
		return mav;
	}
	
	@RequestMapping(value="/remove.do")
	public ModelAndView removeUser(String userid) {
		ModelAndView mav = new ModelAndView();
		
		if(service.removeUser(userid) > 0 ) {
			mav.setViewName("redirect:/list.do");
		}
		else {
			//ToDo: 실패시 작업.. 
			mav.setViewName("redirect:/list.do");
		}
	
		return mav;
	}
	
	@RequestMapping(value="/search.do")
	public ModelAndView search(String searchCondition, String searchKeyword) {
		ModelAndView mav = new ModelAndView();
		
		List<UserVO> users = service.findUser(searchCondition, searchKeyword);
		mav.addObject("users", users);
		mav.setViewName("userList");
		
		return mav;
	}
	
}
