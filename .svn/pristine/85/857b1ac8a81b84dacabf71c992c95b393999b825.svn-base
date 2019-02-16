package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dto.Faq;
import dto.LoginInfo;
import dto.Qna;
import dto.QnaCommand;
import service.QnaService;

@Controller
public class QnaController {
	
	@Autowired
	private QnaService qnaSvc;
	
	@RequestMapping("/qna/report")
	public String form() {
		return "qna/report";
	}
	
	@RequestMapping("/qna/write_qna")
	public String write(QnaCommand qnaComn) {
		qnaSvc.qnaWrite(qnaComn);
		return "redirect:/qna/qna";
//		return "redirect:/qna/report";
//		return "qna/qna";
	}
	
	@RequestMapping("/qna/qna")
	public String qnaList(HttpSession session, Model model) {
		LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
		if(loginInfo != null) {
		ArrayList<Qna> qnaList = qnaSvc.qnaList(loginInfo.getId());
		model.addAttribute("qnaList", qnaList);
		}
		return "qna/qna";
	}
	
	@RequestMapping("/qna/qnaView&{no}")
	public String view(@PathVariable("no") int no, Model model) {
		Qna qnaView = qnaSvc.qnaView(no);
		model.addAttribute("qnaView", qnaView);
		return "qna/qnaView";
	}
	
	@RequestMapping("/qna/faq")
	public String faqList(Model model) {
		ArrayList<Faq> faqList = qnaSvc.faqList();
		model.addAttribute("faqList", faqList);
		return "qna/faq";
	}
	
}
