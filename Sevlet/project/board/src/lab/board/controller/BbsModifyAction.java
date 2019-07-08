package lab.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/modify.do")
public class BbsModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BbsModifyAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
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
		String password = request.getParameter("password");
		BbsDAO dao = new BbsDAO();
		BbsVO article = dao.getArticle(bid);
		if(article != null && article.getPassword().equals(password)) {
			request.setAttribute("article", article);
			request.setAttribute("bid",  new Integer(bid));
			request.setAttribute("page", new Integer(page));
			rd = sc.getRequestDispatcher("/bbs_edit.jsp");
			rd.forward(request, response);
		}
		else {
			out.print("<script>");
			out.print("alert(\"패스워드 오류\");");
//			out.print("history.go(-1);");
			out.print("location.href=\"./view.do?bid="+bid+"&page="+page+"\";");
			out.print("</script>");
		}
		
	}

}
