package lab.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.board.model.BbsDAO;
import lab.board.model.BbsVO;

@WebServlet("/list.do")
public class BbsListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int numPerPage = 10;
	public static final int numPerBlock = 10;
       
    public BbsListAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;
		BbsDAO dao = new BbsDAO();
		ArrayList<BbsVO> headers = null;
		String page = null;
		
		page = request.getParameter("page");
		
		int pageNo = 1;
		int pageCount = 0;
		pageCount = dao.getPageCount(numPerPage);
		if(page == null) {
//			pageNo = pageCount;
			pageNo = 1;
			headers = dao.getBbsList(pageNo, numPerPage);
		}
		else {
			pageNo = Integer.parseInt(page);
			headers = dao.getBbsList(pageNo,  numPerPage);
		}
		
		request.setAttribute("headers", headers);
		request.setAttribute("pageNo", new Integer(pageNo));
		request.setAttribute("totalPage", new Integer(pageCount));
		
		rd = sc.getRequestDispatcher("/bbs_list.jsp");
		rd.forward(request, response);
	}

}
