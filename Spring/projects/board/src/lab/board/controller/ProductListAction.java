package lab.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.board.model.ProductDAO;
import lab.board.model.ProductVO;

@WebServlet("/products.do")
public class ProductListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductListAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text;html;charset=utf-8");
		
		ProductDAO dao = new ProductDAO();
		
		ArrayList<ProductVO> products = dao.getProductList();
		request.setAttribute("products", products);
		
		request.getRequestDispatcher("/products.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
