package lab.spring.exam.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lab.spring.exam.model.Product;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public Product getProduct(String pcode) {
		return sqlSession.selectOne("lab.mybatis.product.ProductMapper.getProduct", pcode);
	}
	
	public List<Product> getProductList() {
		return sqlSession.selectList("lab.mybatis.product.ProductMapper.getProductList");
	}
	
	public int addProduct(Product vo) {
		return sqlSession.insert("lab.mybatis.product.ProductMapper.addProduct", vo);
	}
	
	public int modifyProduct(Product vo) {
		return sqlSession.update("lab.mybatis.product.ProductMapper.modifyProduct", vo);
	}
	
	public int removeProduct(String pcode) {
		return sqlSession.delete("lab.mybatis.product.ProductMapper.removeProduct", pcode);
	}
	
}
