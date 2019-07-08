package lab.board.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.board.model.BbsDAO;
import lab.board.model.FileInfoVO;

@WebServlet("/fileview.do")
public class FileViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileViewAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fid = Integer.parseInt(request.getParameter("fid"));
		BbsDAO dao = new BbsDAO();
		FileInfoVO file = dao.getFile(fid);
		BufferedReader reader = null;
		if(
			file.getFiletype().equalsIgnoreCase("jpg")
			|| file.getFiletype().equalsIgnoreCase("gif")
			|| file.getFiletype().equalsIgnoreCase("png")
			|| file.getFiletype().equalsIgnoreCase("jpeg")
			|| file.getFiletype().equalsIgnoreCase("jpg")
		) {
			response.setContentType("application/octet-stream;charset=utf-8");
			OutputStream os = response.getOutputStream();
			File f = new File("c:/uploadtest/", file.getSavedfile());
		
			
			//헤더에[ 파일이름 용량을 설정
			response.setHeader("Content-Disposition",  "attachment;filename="+f.getName());
			response.setHeader("Content-Length",  ""+f.length());
			FileInputStream fis = new FileInputStream(f);
			int readCount = 0;
			byte[] buf = new byte[1024];
			while((readCount=fis.read(buf)) != -1) {
				os.write(buf, 0, readCount);
			}
			
			fis.close();
			os.close();
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			//reader = new BufferedReader(new FileReader("c://uploadtest/"+file.getSavedfile()));
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("c://uploadtest/"+file.getSavedfile()),"EUC-KR"));
			while(true) {
				String str = reader.readLine();
				
				if(str == null)
					break;
				
				out.print(str+"</br>");
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
