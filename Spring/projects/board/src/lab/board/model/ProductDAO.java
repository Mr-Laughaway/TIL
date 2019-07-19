package lab.board.model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class ProductDAO {
	public Connection dbCon() {
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
	
	
	
	public ArrayList<ProductVO> getProductList() { //(int page, int numPerPage) {
		ArrayList<ProductVO> lists = new ArrayList<ProductVO>();
		Connection con = null;
		PreparedStatement stat = null;
		
		/*
		int start = (page-1) * numPerPage + 1;
		int end = start + numPerPage;
		*/
		
		String sql = "select "
						+ "productid, pname, unitprice, description, "
						+ "category, manufacturer, unitstock, condition, filename "
					+ "from bbs_product";

					
		ResultSet rs = null;
		try {
			con = dbCon();
			stat = con.prepareStatement(sql);
			/*
			stat.setInt(1,  end);
			stat.setInt(2,  start);
			*/
			rs = stat.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setProductid(rs.getString("productid"));
				vo.setPname(rs.getString("pname"));
				vo.setUnitprice(rs.getLong("unitprice"));
				vo.setDescription(rs.getString("description"));
				vo.setCategory(rs.getString("category"));
				vo.setManufacturer(rs.getString("manufacturer"));
				vo.setUnitstock(rs.getLong("unitstock"));
				vo.setCondition(rs.getString("condition"));
				vo.setFilename(rs.getString("filename"));
				
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
	
	
	public ProductVO getProduct(String pid) { //(int page, int numPerPage) {
		ProductVO vo = null;
		Connection con = null;
		PreparedStatement stat = null;
		
		/*
		int start = (page-1) * numPerPage + 1;
		int end = start + numPerPage;
		*/
		
		String sql = "select "
						+ "productid, pname, unitprice, description, "
						+ "category, manufacturer, unitstock, condition, filename "
					+ "from bbs_product "
					+ "where productid = ? ";

					
		ResultSet rs = null;
		try {
			con = dbCon();
			stat = con.prepareStatement(sql);
			stat.setString(1, pid);

			rs = stat.executeQuery();
			if(rs.next()) {
				vo = new ProductVO();
				vo.setProductid(rs.getString("productid"));
				vo.setPname(rs.getString("pname"));
				vo.setUnitprice(rs.getLong("unitprice"));
				vo.setDescription(rs.getString("description"));
				vo.setCategory(rs.getString("category"));
				vo.setManufacturer(rs.getString("manufacturer"));
				vo.setUnitstock(rs.getLong("unitstock"));
				vo.setCondition(rs.getString("condition"));
				vo.setFilename(rs.getString("filename"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose(con, stat, rs);
		}
		
		return vo;
	}//getBbsList() end
	
}
