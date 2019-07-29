package lab.project.outliers.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lab.project.outliers.model.CCTVVO;
import lab.project.outliers.model.PstationVO;
import lab.project.outliers.service.ISpotService;
import lab.project.outliers.util.MyUtil;


@Controller
public class MainController {
	
	@Resource(name = "spotService")
	private ISpotService spotService;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String map(Locale locale, Model model) {
		
		return "map";
	}
	
	
	
	
	@RequestMapping(value = "/apis/getStations")
	@ResponseBody
	public List<PstationVO> getStations(@RequestBody Map<String, Object> params) {
		
		HashMap<String, Object> bounds = MyUtil.mapToHashMap(params);
		List<PstationVO> listStation = spotService.getStationsInRect(bounds);
		
		return listStation;
	}
	
	@RequestMapping(value = "/apis/getCCTVs")
	@ResponseBody
	public List<CCTVVO> getCCTVs(@RequestBody Map<String, Object> params) {
		
		HashMap<String, Object> bounds = MyUtil.mapToHashMap(params);
		List<CCTVVO> listCCTV = spotService.getCCTVsInRect(bounds);
		
		return listCCTV;
	}
	
	
	
	
	
	
	
	
}
