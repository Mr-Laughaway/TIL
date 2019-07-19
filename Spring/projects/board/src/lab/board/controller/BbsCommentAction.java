package lab.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.board.model.BbsDAO;
import lab.board.model.CommentVO;

@WebServlet("/comment.do")
public class BbsCommentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BbsCommentAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		String page = request.getParameter("page");
		
		String action = request.getParameter("action");
		BbsDAO dao = new BbsDAO();
		
		if(action.equals("save_comment")) {
			String writer = request.getParameter("writer");
			String password = request.getParameter("password");
			String contents = request.getParameter("contents");
			
			CommentVO comment = new CommentVO();
			comment.setRbid(bid);
			comment.setWriter(writer);
			comment.setPassword(password);
			comment.setContents(contents);
			comment.setIp(request.getRemoteAddr());
			
			if(dao.addBbsComment(comment) > 0) {
				response.sendRedirect("./view.do?bid="+bid+"&page="+page);
			}
			else {
				//ToDo: 실패 시 처리
			}
		}
		else if(action.equals("del_comment")) {
			int cmid = Integer.parseInt(request.getParameter("cmid"));
			String password = request.getParameter("password");
			if(password.equals(dao.getCommentPassword(cmid))) {
				if(dao.delBbsComment(cmid) > 0) {
					response.sendRedirect("./view.do?bid="+bid+"&page="+page);
				}
				else {
					//ToDo: 실패 시 처리
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
