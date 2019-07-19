package lab.spring.exam.service;

import java.util.List;

import lab.spring.exam.model.Product;

public interface ProductService {
	Product getProduct(String pcode);
	List<Product> getProductList();
	int addProduct(Product vo);
	int modifyProduct(Product vo);
	int removeProduct(String pcode);
	
}
