package lab.project.outliers.model;

import java.sql.Date;

public class CCTVVO {
	private String cctv_id;
	private String agency_name;
	private String add_new;
	private String add_old;
	private String purpose;
	private int count;
	private int pixel;
	private String direction;
	private Date date_inst;
	private double latitude;
	private double longitude;
	private Date date_update;
	private String loc_gu;
	private String useyn;
	
	public String getCctv_id() {
		return cctv_id;
	}
	public void setCctv_id(String cctv_id) {
		this.cctv_id = cctv_id;
	}
	public String getAgency_name() {
		return agency_name;
	}
	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}
	public String getAdd_new() {
		return add_new;
	}
	public void setAdd_new(String add_new) {
		this.add_new = add_new;
	}
	public String getAdd_old() {
		return add_old;
	}
	public void setAdd_old(String add_old) {
		this.add_old = add_old;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPixel() {
		return pixel;
	}
	public void setPixel(int pixel) {
		this.pixel = pixel;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Date getDate_inst() {
		return date_inst;
	}
	public void setDate_inst(Date date_inst) {
		this.date_inst = date_inst;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Date getDate_update() {
		return date_update;
	}
	public void setDate_update(Date date_update) {
		this.date_update = date_update;
	}
	public String getLoc_gu() {
		return loc_gu;
	}
	public void setLoc_gu(String loc_gu) {
		this.loc_gu = loc_gu;
	}
	public String getUseyn() {
		return useyn;
	}
	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}

	
}
