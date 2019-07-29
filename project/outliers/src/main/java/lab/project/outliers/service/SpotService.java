package lab.project.outliers.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.project.outliers.dao.ISpotDAO;
import lab.project.outliers.model.CCTVVO;
import lab.project.outliers.model.PstationVO;

@Service("spotService")
public class SpotService implements ISpotService {
	
	@Autowired
	private ISpotDAO dao;

	@Override
//	@Transactional
	public List<PstationVO> getStationsAll() {
		return dao.getStationsAll();
	}
	
	@Override
	public List<PstationVO> getStationsInRect(HashMap<String, Object> hm) {
		return dao.getStationsInRect(hm);
	}
	
	@Override
	public List<CCTVVO> getCCTVsInRect(HashMap<String, Object> hm) {
		return dao.getCCTVsInRect(hm);
	}

}
