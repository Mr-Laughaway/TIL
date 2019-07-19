package lab.board.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;

public class BbsVO {
	private int bid;
	private String subject;
	private String writer; 
	private String password; 
	private Date idate;
	private String contents; 
	private String email;  
	private String ip;	
	private String  fileYN;	
	private int rcount;
	private int vcount;
	
	private Vector<CommentVO> comments = new Vector<CommentVO>();
	private ArrayList<FileInfoVO> files = new ArrayList<FileInfoVO>();
	
	public Vector<CommentVO> getComments() {
		return comments;
	}
	public void setComments(Vector<CommentVO> comments) {
		this.comments = comments;
	}
	
	public void addComments(CommentVO comment) {
		this.comments.add(comment);
	}
	
	public ArrayList<FileInfoVO> getFiles() {
		return files;
	}
	
	public void setFiles(ArrayList<FileInfoVO> files) {
		this.files = files;
	}
	
	public void addFiles(FileInfoVO f) {
		files.add(f);
	}
	
	public int getBid() {
		return bid;
	}
	
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getIdate() {
		return idate;
	}
	public void setIdate(Date idate) {
		this.idate = idate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getFileYN() {
		return fileYN;
	}
	public void setFileYN(String fileYN) {
		this.fileYN = fileYN;
	}
	public int getRcount() {
		return rcount;
	}
	public void setRcount(int rcount) {
		this.rcount = rcount;
	}
	public int getVcount() {
		return vcount;
	}
	public void setVcount(int vcount) {
		this.vcount = vcount;
	}	
}
