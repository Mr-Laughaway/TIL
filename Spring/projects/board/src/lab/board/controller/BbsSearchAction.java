package lab.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/search.do")
public class BbsSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BbsSearchAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;
		
		BbsDAO dao = new BbsDAO();
		ArrayList<BbsVO> headers = null;
		String page = request.getParameter("page");
		String searchKey = request.getParameter("searchKey");
		String searchWord = request.getParameter("searchWord").trim();
		
		if(searchKey == null || searchKey.equals("")) {
			out.print("<script>");
			out.print("alert(\"검색 컬럼을 지정해주세요\");");
			out.print("location.href=\"./list.do?page="+page+"\";");
			out.print("</script>");
			return;
		}
		
		int numPerPage = BbsListAction.numPerPage;
		int pageNo = 1;
		int pageCount = 0;
		pageCount = dao.getSearchPageCount(numPerPage,searchKey, searchWord);
		if(page == null) {
//			pageNo = pageCount;
			pageNo = 1;
			headers = dao.getBbsSearchList(pageNo, numPerPage, searchKey, searchWord);
		}
		else {
			pageNo = Integer.parseInt(page);
			headers = dao.getBbsSearchList(pageNo, numPerPage, searchKey, searchWord);
		}
		
		
		request.setAttribute("headers", headers);
		request.setAttribute("pageNo", new Integer(pageNo));
		request.setAttribute("totalPage", new Integer(pageCount));
		request.setAttribute("type", "search");
		request.setAttribute("searchKey", searchKey);
		request.setAttribute("searchWord", searchWord);
		
		rd = sc.getRequestDispatcher("/bbs_list.jsp");
		rd.forward(request, response);
	}

}
