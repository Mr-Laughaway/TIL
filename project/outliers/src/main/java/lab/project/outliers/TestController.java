package lab.project.outliers;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import lab.project.outliers.model.PstationVO;
import lab.project.outliers.service.ISpotService;

/**
 * Handles requests for the application home page.
 */
@Controller
//@SessionAttributes({"id"})
public class TestController {
	
	@Resource(name = "spotService")
	private ISpotService spotService;
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		
		List<PstationVO> stations = spotService.getStationsAll();
		model.addAttribute("stations", stations);
		
		return "test";
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2(Locale locale, Model model, HttpSession session, HttpServletRequest request) {
		
		session.setAttribute("id", session.getId());
		request.setAttribute("pwd", "password11");
		
		model.addAttribute("id", "password22");
		model.addAttribute("ip_address", request.getCharacterEncoding());
		
		System.out.println(model.asMap().toString());
		
		return "test2";
	}
	
}
