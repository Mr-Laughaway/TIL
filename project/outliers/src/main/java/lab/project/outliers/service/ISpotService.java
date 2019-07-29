package lab.project.outliers.service;

import java.util.HashMap;
import java.util.List;

public interface ISpotService {
	public List getStationsAll();
	public List getStationsInRect(HashMap<String, Object> hm);
	public List getCCTVsInRect(HashMap<String, Object> hm);
}
