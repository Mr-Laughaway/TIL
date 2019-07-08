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
import javax.servlet.http.HttpSession;

import lab.board.model.BbsDAO;
import lab.board.model.BbsVO;
import lab.board.model.FileInfoVO;
import lab.board.model.UserVO;

@WebServlet("/view.do")
public class BbsViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BbsViewAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
//		doPost(request, response);		
		PrintWriter out = response.getWriter();
		
		String page = request.getParameter("page");
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			out.print("<script>");
			out.print("alert(\"로그인이 필요한 서비스입니다.\");");
			out.print("location.href=\"./login.do\";");
			out.print("</script>");
		}
		else {
			doPost(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		String page = request.getParameter("page");
		
		UserVO user = (UserVO)request.getSession().getAttribute("user");
		if(user == null) {
			
		}
	
		
		BbsDAO dao = new BbsDAO();
		BbsVO article = dao.getArticle(bid);
		
		if(article != null) {
			request.setAttribute("article", article);
			request.setAttribute("bid",  new Integer(bid));
			request.setAttribute("page", new Integer(page));
			
			rd = sc.getRequestDispatcher("/bbs_view.jsp");
			rd.forward(request, response);
		}
		else {
			out.print("<script>");
			out.print("alert(\"글 내용 조회 실패\");");
			out.print("history.go(-1);");
			out.print("</script>");
		}
	}

}
