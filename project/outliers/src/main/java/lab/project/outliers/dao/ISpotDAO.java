package lab.project.outliers.dao;

import java.util.HashMap;
import java.util.List;

import lab.project.outliers.model.CCTVVO;
import lab.project.outliers.model.PstationVO;

public interface ISpotDAO {
	
	public List<PstationVO> getStationsAll();
	public List<PstationVO> getStationsInRect(HashMap<String, Object> hm);
	public List<CCTVVO> getCCTVsInRect(HashMap<String, Object> hm);
	
}
