package lab.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.board.model.UserMgrDAO;
import lab.board.model.UserVO;

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<String, String> jobs = new HashMap<String, String>();
       
    public JoinServlet() {
    	super();
    	jobs.put("39", "학생");
    	jobs.put("40", "컴퓨터/인터넷");
    	jobs.put("41", "언론");
    	jobs.put("42", "공무원");
    	jobs.put("43", "군인");
    	jobs.put("44", "서비스업");
    	jobs.put("45", "교육");
    	jobs.put("46", "금융/증권/보험업");
    	jobs.put("47", "유통업");
    	jobs.put("48", "예술");
    	jobs.put("49", "의료");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = request.getServletContext();
    	RequestDispatcher rd = sc.getRequestDispatcher("/member.jsp");
    	rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		UserVO user = new UserVO();
		user.setUserid(request.getParameter("userid"));
	    user.setUserpwd(request.getParameter("userpwd"));
	    user.setUsername(request.getParameter("username"));
	    String emailAddr = request.getParameter("emailaddr");
	    String email = "";
	    if(emailAddr.length() > 1) {
	    	email = 
	    			request.getParameter("email")
					+ "@"
					+ emailAddr;
	    }
	    else {
	    	email = 
    			request.getParameter("email")
				+ "@"
				+ request.getParameter("email_dns");
	    }
	    
	    user.setEmail(email);
		user.setPhone(request.getParameter("phone"));
	    user.setAddress(request.getParameter("address"));
	    
	    String job = request.getParameter("job");
	    user.setJob(jobs.get(job));
	    
	    
		
	    UserMgrDAO dao = new UserMgrDAO();
	    if(dao.joinProc(user) > 0 ) {
	    	/*
	    	ServletContext sc = request.getServletContext();
	    	RequestDispatcher rd = sc.getRequestDispatcher("/memberOK3.jsp");
	    	request.setAttribute("user", user);
	    	rd.forward(request, response);
	    	*/
	    	//response.sendRedirect("./login.do");
	    	out.print("<script>");
	    	out.print("alert(\"회원가입 성공\");");
	    	out.print("location.href=\"./login.do\";");
	    	out.print("</script>");
	    }
	    else {
	    	out.print("<!DOCTYPE html>");
	    	out.print("<head></head>");
	    	out.print("<body>");
	    	out.print("<script>");
	    	out.print("alert(\"회원가입 실패\");");
	    	out.print("history.go(-1);");
	    	out.print("</script>");
	    	out.print("<body>");
	    	out.print("</html>");
	    }
		
	}

}
