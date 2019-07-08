package lab.board.model;

public class ProductVO {
	private String productid; 
	private String pname; 
	private long unitprice; 
	private String description;  
	private String category; 
	private String manufacturer; 
	private long unitstock; 
	private String condition; 
	private String filename;
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public long getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(long unitprice) {
		this.unitprice = unitprice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public long getUnitstock() {
		return unitstock;
	}
	public void setUnitstock(long unitstock) {
		this.unitstock = unitstock;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
