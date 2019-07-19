package lab.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab.board.model.BbsDAO;

@WebServlet("/delete.do")
public class BbsRemoveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BbsRemoveAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int bid = Integer.parseInt(request.getParameter("bid"));
		String page = request.getParameter("page");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			out.print("<script>");
			out.print("alert(\"로그인이 필요한 서비스입니다.\");");
			out.print("location.href=\"./login.do\";");
			out.print("</script>");
		}
		else {
			BbsDAO dao = new BbsDAO();
			if(password.equals(dao.getBbsPassword(bid))) {
				if(dao.deleteBbs(bid) > 0 ) {
					response.sendRedirect("./list.do?page="+page);
				}
			}
			else {
				out.print("<script>");
				out.print("alert(\"패스워드 오류\");");
				out.print("location.href=\"./view.do?bid="+bid+"&page="+page+"\";");
				out.print("</script>");
			}
		}
	}

}
