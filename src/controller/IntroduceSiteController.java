package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntroduceSiteController {
	
	@RequestMapping("/introduce/introduceSite")
	public String form1() {
		return "introduce/introduceSite";
	}
	
	@RequestMapping("/introduce/howtouse")
	public String form2() {
		return "introduce/howtouse";
	}	
}
	