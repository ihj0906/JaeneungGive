/*package controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dto.Faq;
import service.FaqService;

@Controller
public class FaqController {
	
	@Autowired
	private FaqService faqSvc;
	
	@RequestMapping("/qna/faq")
	public String form() {
		return "qna/faq";
	}
	
	@RequestMapping("/qna/faq")
	public String list(Model model) {
		ArrayList<Faq> faqList = faqSvc.faqList();
		model.addAttribute("faqList", faqList);
		return "qna/faq";
	}
}
*/