package lab.spring.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.exam.model.Product;
import lab.spring.exam.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService service;

	@RequestMapping("/list.do")
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("products", service.getProductList());
		mav.setViewName("product_list");
		
		return mav;
	}
	
	
	@RequestMapping(value="/add.do", method=RequestMethod.GET )
	public ModelAndView addProduct() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("product_form");
		
		return mav;
	}
	
	
	@RequestMapping(value="/add.do", method=RequestMethod.POST )
	public ModelAndView addProduct(Product product) {
		ModelAndView mav = new ModelAndView();
		
		if(service.addProduct(product) > 0) {
			//ToDo: 추후 성공 페이지 구현 시....
		}
		else {
			//ToDo: 추후 에러 페이지 구현 시...
		}
		
		mav.setViewName("redirect:/list.do");
		
		return mav;
	}
	
	
	@RequestMapping(value="/view.do")
	public ModelAndView viewProduct(String pcode) {
		ModelAndView mav = new ModelAndView();
		
		Product product = service.getProduct(pcode);
		mav.addObject("product", product);
		mav.setViewName("product_view");
		
		return mav;
	}
	
	
	@RequestMapping(value="/modify.do")
	public ModelAndView modifyProduct(String pcode) {
		ModelAndView mav = new ModelAndView();
		
		Product product = service.getProduct(pcode);
		mav.addObject("product", product);
		mav.setViewName("product_modify");
		
		return mav;
	}
	
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST )
	public ModelAndView modifyProduct(Product product) {
		ModelAndView mav = new ModelAndView();
		
		if(service.modifyProduct(product) > 0) {
			//ToDo: 추후 성공 페이지 구현 시....
		}
		else {
			//ToDo: 추후 에러 페이지 구현 시...
		}
		
		mav.setViewName("redirect:/list.do");
		
		return mav;
	}
	
	
	@RequestMapping(value="/delete.do", method=RequestMethod.POST )
	public ModelAndView removeProduct(String pcode) {
		ModelAndView mav = new ModelAndView();
		
		if(service.removeProduct(pcode) > 0) {
			//ToDo: 추후 성공 페이지 구현 시....
		}
		else {
			//ToDo: 추후 에러 페이지 구현 시...
		}
		
		mav.setViewName("redirect:/list.do");
		
		return mav;
	}
	
	
	
}
