package lab.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.board.model.ProductDAO;
import lab.board.model.ProductVO;

@WebServlet("/productView.do")
public class ProductViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductViewAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text;html;charset=utf-8");
		
		String pid = request.getParameter("prodid");
		ProductDAO dao = new ProductDAO();
		ProductVO product = dao.getProduct(pid);
		request.setAttribute("product", product);
		
		request.getRequestDispatcher("/product.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
