package lab.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BbsDAO {
	public Connection dbCon() {
		/*
		Connection con = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(
				"C:/workspace2/board/WebContent/WEB-INF/db.properties"
			));
			Class.forName(prop.getProperty("driver"));
			con = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("pwd")
			);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		*/
		Connection con = null;
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/oracle");
			con = ds.getConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
	
	public void dbClose(Connection con, Statement stat, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
			if(con!=null) con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public int getPageCount(int numPerPage) {
		int total = 0;
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		String sql = "select count(bid) from bbs ";
		try {
			con = dbCon();
			stat = con.createStatement();
			rs = stat.executeQuery(sql);

			if(rs.next()) {
				total = rs.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose(con, stat, rs);
		}
		
		int pageCount=(int)Math.ceil(total/(double)numPerPage);
		pageCount = Math.max(pageCount, 1);
		
		return pageCount;
	}//getPageCount() end
	
	
	public int getSearchPageCount(int numPerPage, String searchKey, String searchWord) {
		int total = 0;
		Connection con = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sw = "%" + searchWord + "%";
		String sql = null;
		if("writer".equals(searchKey)) {
			sql = "select count(bid) from bbs where writer like ? ";
		}
		else if("subject".equals(searchKey)) {
			sql = "select count(bid) from bbs where subject like ? ";
		}
		
		try {
			con = dbCon();
			stat = con.prepareStatement(sql);
			stat.setString(1, sw);
			rs = stat.executeQuery();

			if(rs.next()) {
				total = rs.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose(con, stat, rs);
		}
		
		int pageCount=(int)Math.ceil(total/(double)numPerPage);
		pageCount = Math.max(pageCount, 1);
		
		return pageCount;
	}//getSearchPageCount() end
	
	
	
	public int insertBbs(BbsVO form) {
		int rows = 0;
		Connection con = null;
		PreparedStatement stat = null;
		/*
		String sql = "insert into bbs "
				+ "(bid , subject, writer, password, "
				+ "idate, contents, email, ip, fileYN) "
				+ "values (bbs_seq.nextval, ?, ?, ?, sysdate, ?, ?, ?, ?)";
		*/
		String sql = "insert into bbs "
				+ "(bid , subject, writer, password, "
				+ "idate, contents, email, ip, fileYN) "
				+ "values (?, ?, ?, ?, sysdate, ?, ?, ?, ?)";
		try {
			con = dbCon();
			stat = con.prepareStatement(sql);
			stat.setInt(1, form.getBid());
			stat.setString(2, form.getSubject());
			stat.setString(3, form.getWriter());
			stat.setString(4, form.getPassword());
			stat.setString(5, form.getContents());
			stat.setString(6, form.getEmail());
			stat.setString(7, form.getIp());
			stat.setString(8, form.getFileYN());
			rows = stat.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose(con, stat, null);
		}
		
		return rows;
	}//insertBbs() end
	
	
	
	
	public ArrayList<BbsVO> getBbsList(int page, int numPerPage) {
		ArrayList<BbsVO> lists = new ArrayList<BbsVO>();
		Connection con = null;
		PreparedStatement stat = null;
//		int start = (page-1) * numPerPage;
//		int end = page * numPerPage;
		
		int start = (page-1) * numPerPage + 1;
		int end = start + numPerPage;

		/*
		String sql = "select num, bid, subject, writer, idate, rcount "
					+ "from ( "
						+ "select bid, subject, writer, idate, rcount, rownum as num "
						+ "from bbs "
						+ "order by idate desc "
					+ ") "
					+ "where num > ? and num <= ? "
					+ "order by idate desc ";
		*/
		String sql = "select bid, subject, writer, idate, rcount "
					+ "from ( "
						+ "select rownum as num, bid, subject, writer, idate, rcount "
						+ "from ( "
					    	+ "select bid, subject, writer, idate, rcount "
					    	+ "from bbs "
					    	+ "order by idate desc "
				    	+ ") A "
				    	+ "where rownum < ? "
					+ ") B "
				    + "where ? <= num";

					
		ResultSet rs = null;
		try {
			con = dbCon();
			stat = con.prepareStatement(sql);
			stat.setInt(1,  end);
			stat.setInt(2,  start);
			rs = stat.executeQuery();
			while(rs.next()) {
				BbsVO vo = new BbsVO();
				vo.setBid(rs.getInt("bid"));
				vo.setSubject(rs.getString("subject"));
				vo.setWriter(rs.getString("writer"));
//				vo.setPassword(rs.getString("password"));
				vo.setIdate(rs.getDate("idate"));
//				vo.setContents(rs.getString("contetns"));
//				vo.setEmail(rs.getString("email"));
//				vo.setIp(rs.getString("ip"));
//				vo.setFileYN(rs.getString("fileYN"));
				vo.setRcount(rs.getInt("rcount"));
//				vo.setVcount(rs.getInt("vcount"));
				lists.add(vo);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose(con, stat, rs);
		}
		
		return lists;
	}//getBbsList() end
	
	
	public BbsVO getArticle(int bid) {
		BbsVO bbs = null;
		Connection con = null;
		PreparedStatement stat = null;

		String sql = "select bid, subject, writer, password, idate, "
				+ " contents, email, fileyn, ip, rcount, vcount "
				+ " from bbs where bid = ?";
					
		ResultSet rs = null;
		try {
			con = dbCon();
			stat = con.prepareStatement(
				sql, 
				ResultSet.TYPE_FORWARD_ONLY,
				ResultSet.CONCUR_UPDATABLE
			);
			stat.setInt(1,  bid);
			rs = stat.executeQuery();
			while(rs.next()) {
				bbs = new BbsVO();
				bbs.setBid(rs.getInt("bid"));
				bbs.setSubject(rs.getString("subject"));
				bbs.setWriter(rs.getString("writer"));
				bbs.setPassword(rs.getString("password"));
				bbs.setIdate(rs.getDate("idate"));
				bbs.setContents(rs.getString("contents"));
				bbs.setEmail(rs.getString("email"));
				bbs.setIp(rs.getString("ip"));
				bbs.setFileYN(rs.getString("fileYN"));
				
				int rcount = rs.getInt("rcount");
				rs.updateLong("rcount",  rcount + 1);
				rs.updateRow();
				bbs.setRcount(rcount + 1);
				bbs.setVcount(rs.getInt("vcount"));
			}
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
			
			String sql2 = "select cmid, writer, idate, contents, password, ip "
						+ "from bbs_comment "
						+ "where rbid = ? "
						+ "order by idate desc";
			
			stat = con.prepareStatement(sql2.toString());
			stat.setInt(1,  bid);
			rs = stat.executeQuery();
			while(rs.next()) {
				CommentVO ba = new CommentVO();
				ba.setCmid(rs.getInt("cmid"));
				ba.setRbid(bid);
				ba.setWriter(rs.getString("writer"));
				ba.setIdate(rs.getDate("idate"));
				ba.setContents(rs.getString("contents"));;
				ba.setPassword(rs.getString("password"));
				ba.setIp(rs.getString("ip"));
				bbs.addComments(ba);
			}
			
			ArrayList<FileInfoVO> files = getFileList(bid);
			bbs.setFiles(files);
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose(con, stat, rs);
		}
		
		return bbs;
	} //getArticle() end
	
	
	public ArrayList<FileInfoVO> getFileList(int bid) {
		ArrayList<FileInfoVO> files = new ArrayList<FileInfoVO>();
		Connection con = null;
		PreparedStatement stat = null;

		String sql = "select * from bbs_file where rbid = ?";
					
		ResultSet rs = null;
		try {
			con = dbCon();
			stat = con.prepareStatement(sql);
			stat.setInt(1,  bid);
			
			rs = stat.executeQuery();
			while(rs.next()) {
				FileInfoVO file = new FileInfoVO();
				file.setFid(rs.getInt("fid"));
				file.setRbid(rs.getInt("rbid"));
				file.setFilename(rs.getString("filename"));
				file.setFiletype(rs.getString("filetype"));
				file.setSavedfile(rs.getString("savedfile"));
				
				files.add(file);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose(con, stat, rs);
		}
		
		return files;
	}//getFiles() end
	
	
	public FileInfoVO getFile(int fid) {
		FileInfoVO file = new FileInfoVO();
		Connection con = null;
		PreparedStatement stat = null;

		String sql = "select * from bbs_file where fid = ?";
					
		ResultSet rs = null;
		try {
			con = dbCon();
			stat = con.prepareStatement(sql);
			stat.setInt(1,  fid);
			
			rs = stat.executeQuery();
			while(rs.next()) {
				file = new FileInfoVO();
				file.setFid(rs.getInt("fid"));
				file.setRbid(rs.getInt("rbid"));
				file.setFilename(rs.getString("filename"));
				file.setFiletype(rs.getString("filetype"));
				file.setSavedfile(rs.getString("savedfile"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose(con, stat, rs);
		}
		
		return file;
	}//getFiles() end
	
	
	public String getBbsPassword(int bid) {
		String pwd = null;
		Connection con = null;
		PreparedStatement stat = null;

		String sql = "select password from bbs where bid = ?";
					
		ResultSet rs = null;
		try {
			con = dbCon();
			stat = con.prepareStatement(sql);
			stat.setInt(1,  bid);
			rs = stat.executeQuery();
			while(rs.next()) {
				pwd = rs.getString("password");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose(con, stat, rs);
		}
		
		return pwd;
	} //getBbsPassword() end
	
	
	public int updateBbs(BbsVO bbs) {
		Connection con = null;
		PreparedStatement stat = null;

		String sql = "update bbs "
					+ "set subject = ? , contents = ? "
					+ "where bid = ? ";
				
		int rows = 0;
		try {
			con = dbCon();
			stat = con.prepareStatement(sql); 
			stat.setString(1,  bbs.getSubject());
			stat.setString(2, bbs.getContents());
			stat.setInt(3, bbs.getBid());
			rows = stat.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose(con, stat, null);
		}
		
		return rows;
	} //updateBbs() end
	
	
	
	
	public int deleteBbs(int bid) {
		Connection con = null;
		PreparedStatement stat = null;

		String sql = "delete from bbs_comment where rbid = ? ";
		String sql2 = "delete from bbs where bid = ? ";	
		int rows = 0;
		
		try {
			con = dbCon();
			stat = con.prepareStatement(sql); 
			stat.setInt(1,  bid);
			rows = stat.executeUpdate();
			stat.close();
			
			stat = con.prepareStatement(sql2);
			stat.setInt(1,  bid);
			rows += stat.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose(con, stat, null);
		}
		
		return rows;
	}// deleteBbs() end
	
	
	public int addBbsComment(CommentVO comment) {
		Connection con = null;
		PreparedStatement stat = null;

		String sql = "insert into bbs_comment "
					+ "(cmid, rbid, writer, idate, contents, password, ip) "
					+ "values (comment_seq.nextval, ?, ?, sysdate, ?, ?, ?) ";
				
		int rows = 0;
		try {
			con = dbCon();
			stat = con.prepareStatement(sql); 
			stat.setInt(1,  comment.getRbid());
			stat.setString(2,  comment.getWriter());
			stat.setString(3,  comment.getContents());
			stat.setString(4,  comment.getPassword());
			stat.setString(5,  comment.getIp());
			rows = stat.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose(con, stat, null);
		}
		
		return rows;
		
	}
	
	
	public int delBbsComment(int cmid) {
		Connection con = null;
		PreparedStatement stat = null;

		String sql = "delete from bbs_comment where cmid = ? ";
				
		int rows = 0;
		try {
			con = dbCon();
			stat = con.prepareStatement(sql); 
			stat.setInt(1,  cmid);
			rows = stat.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose(con, stat, null);
		}
		
		return rows;
	}
	
	
	public String getCommentPassword(int cmid) {
		String pwd = null;
		Connection con = null;
		PreparedStatement stat = null;

		String sql = "select password from bbs_comment where cmid = ?";
					
		ResultSet rs = null;
		try {
			con = dbCon();
			stat = con.prepareStatement(sql);
			stat.setInt(1,  cmid);
			rs = stat.executeQuery();
			while(rs.next()) {
				pwd = rs.getString("password");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose(con, stat, rs);
		}
		
		return pwd;
	}
	
	
	public ArrayList<BbsVO> getBbsSearchList(
			int page, int numPerPage, String searchKey, String searchWord
	) {
		ArrayList<BbsVO> lists = new ArrayList<BbsVO>();
		Connection con = null;
		PreparedStatement stat = null;
		
		int start = (page-1) * numPerPage + 1;
		int end = start + numPerPage;
		
		String sw =  "%" + searchWord + "%";
		String sql = null;
		sql = "select bid, subject, writer, idate, rcount "
				+ "from ( "
					+ "select rownum as num, bid, subject, writer, idate, rcount "
					+ "from ( "
				    	+ "select bid, subject, writer, idate, rcount "
				    	+ "from bbs "
				    	+ "where " + searchKey + " like ? "
				    	+ "order by idate desc "
			    	+ ") A "
			    	+ "where rownum < ? "
				+ ") B "
			    + "where ? <= num";
					
		ResultSet rs = null;
		try {
			con = dbCon();
			stat = con.prepareStatement(sql);
			stat.setString(1, sw);
			stat.setInt(2,  end);
			stat.setInt(3,  start);
			rs = stat.executeQuery();
			while(rs.next()) {
				BbsVO vo = new BbsVO();
				vo.setBid(rs.getInt("bid"));
				vo.setSubject(rs.getString("subject"));
				vo.setWriter(rs.getString("writer"));
				vo.setIdate(rs.getDate("idate"));
				vo.setRcount(rs.getInt("rcount"));
				lists.add(vo);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose(con, stat, rs);
		}
		
		return lists;
	}//getBbsSearchList() end
	
	
	public int getBid() {
		int bid = -1;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select bbs_seq.nextval from dual ";
		try {
			con = dbCon();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				bid = rs.getInt(1);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose(con, stmt, rs);
		}
		
		return bid;
	}//getBid() end
	
	
	public int saveFile(FileInfoVO fileinfo) {
		//upload file 정보 저장
		StringBuffer sql = null;
		int cnt = -1;
		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		sql = new StringBuffer();
		sql.append("insert into bbs_file (fid, rbid, filename, filetype, savedfile)")
			.append(" values (bbsfile_seq.nextval, ?, ?, ?, ?) ");
		try {
			con = dbCon();
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1,  fileinfo.getRbid());
			stmt.setString(2,  fileinfo.getFilename());
			stmt.setString(3,  fileinfo.getFiletype());
			stmt.setString(4,  fileinfo.getSavedfile());
			cnt = stmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose(con, stmt, rs);
		}
		
		return cnt;
	}
		
}
