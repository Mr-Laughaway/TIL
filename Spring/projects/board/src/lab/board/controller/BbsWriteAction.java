package lab.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import lab.board.model.BbsDAO;
import lab.board.model.BbsVO;
import lab.board.model.FileInfoVO;

@WebServlet("/write.do")
@MultipartConfig(
		location="c:/uploadtest",
		maxFileSize=1024 * 1024 * 5, 
		maxRequestSize=1024 * 1024 * 5 * 5
)
public class BbsWriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String UPLOAD_DIRECTORY = "c:/uploadtest";
       
    public BbsWriteAction() {
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
			ServletContext sc = request.getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/bbs_write.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		BbsDAO dao = new BbsDAO();
		BbsVO form = null;
		
		
		String page = null;
		String fileName = null;
		String savedFile = null;
		String fileType = null;
		FileInfoVO fileVo = null;
		int bid = -1;
		
		page = request.getParameter("page");
		form = new BbsVO();
		
		File uploadDir = new File(UPLOAD_DIRECTORY);
		if(!uploadDir.isDirectory()) {
			uploadDir.mkdirs();
		}
		
		bid = dao.getBid();
		
		//File upload 처리
		Collection<Part> parts = request.getParts();
		for(Part part : parts) {
			if(part.getContentType() != null) {
				fileName = part.getSubmittedFileName();
				fileType = fileName.substring(fileName.lastIndexOf(".")+1);
				if(fileName != null && fileName.length() > 0) {
					form.setFileYN("Y");
					savedFile = fileName.substring(0, fileName.lastIndexOf("."))
							+ "_" + System.currentTimeMillis()
							+ fileName.substring(fileName.lastIndexOf("."));
					part.write(savedFile);
					fileVo = new FileInfoVO();
					fileVo.setFilename(fileName);
					fileVo.setFiletype(fileType);
					fileVo.setSavedfile(savedFile);
					fileVo.setRbid(bid);
					dao.saveFile(fileVo);
				}
				else {
					form.setFileYN("N");
				}
			}
		}
		
		
		/*
		String fileFlag = "N";
		if(request.getParameter("upload") != null) {
			fileFlag = "Y";
			//ToDo: 업로드 된 파일 저장 처리
		}
		*/
		
		
		//form.setFileYN(fileFlag);
		form.setBid(bid);
		form.setWriter(request.getParameter("writer"));
		form.setPassword(request.getParameter("password"));
		form.setSubject(request.getParameter("subject"));
		form.setEmail(request.getParameter("email"));
		form.setContents(request.getParameter("contents"));
		form.setIp(request.getRemoteAddr());
		if(dao.insertBbs(form) > 0 ) {
			response.sendRedirect("./list.do");
		}
	}
	
	public void uploadProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BbsDAO dao = new BbsDAO();
		String path = "c:/uploadtest";
		String saveFile = null;
		File isDir = new File(path);
		if(!isDir.isDirectory()) {
			isDir.mkdirs();
		}
		
		Collection<Part> parts = request.getParts();
		for(Part part : parts) {
			if(part.getContentType() != null) {
				String fileName = part.getSubmittedFileName();
				if(fileName != null) {
					saveFile = fileName.substring(0, fileName.lastIndexOf("."))
							+ "_" + System.currentTimeMillis()
							+ fileName.substring(fileName.lastIndexOf("."));
					part.write(saveFile);
					System.out.println("file저장");
					
					FileInfoVO file = new FileInfoVO();
					file.setFilename(saveFile);
					String fileType = fileName.substring(fileName.lastIndexOf("."));
					file.setFiletype(fileType);
					//dao.insertUploadFile(file);
				}
			}
		}
		
	}

}
