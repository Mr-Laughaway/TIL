package lab.spring.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.exam.dao.ProductDAO;
import lab.spring.exam.model.Product;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO dao;

	public Product getProduct(String pcode) {
		return dao.getProduct(pcode);
	}

	public List<Product> getProductList() {
		return dao.getProductList();
	}
	

	public int addProduct(Product vo) {
		return dao.addProduct(vo);
	}

	public int modifyProduct(Product vo) {
		return dao.modifyProduct(vo);
	}

	public int removeProduct(String pcode) {
		return dao.removeProduct(pcode);
	}

}
