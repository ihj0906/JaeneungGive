package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.Admin;
import dto.AdminBoard;
import dto.AdminFaqCommand;
import dto.AdminQnaWriteCommand;
import dto.Faq;
import dto.Member;
import dto.Qna;
import service.GiveService;
import service.MemberService;
import service.QnaService;

@Controller
public class AdminController {

	@Autowired
	private GiveService giveSvc;

	@Autowired
	private MemberService memberSvc;

	@Autowired
	private QnaService qnaSvc;

//	admin 게시물 리스트
	@RequestMapping("/admin/board")
	public String boardList(Model model, HttpSession session) {
		if (session.getAttribute("adminInfo") == null) {
			return "redirect:/admin";
		}
		ArrayList<AdminBoard> adminBoardList = giveSvc.adminBoardList();
		model.addAttribute("adminBoardList", adminBoardList);
		return "admin/board/admin_board";
	}

//	admin 게시물 상세
	@RequestMapping("/admin/boardDetail&{category}&{no}")
	public String boardDetail(HttpSession session, @PathVariable("no") int no, Model model, @PathVariable("category") int cano) {
		if (session.getAttribute("adminInfo") == null) {
			return "redirect:/admin";
		}
		String category = "기부";
		if (cano == 2) {
			category = "교환";
		}
		AdminBoard adminBoardDetail = giveSvc.adminBoardDetail(no, category);
		model.addAttribute("adminBoardDetail", adminBoardDetail);
		return "admin/board/admin_boardDetail";
	}

//	admin 게시물 삭제
	@RequestMapping("/admin/boardDelete")
	public String boardDelete(@RequestParam("no") int no, @RequestParam("category") String category) {
		if (category.equals("교환") || category.equals("2")) {
			giveSvc.delExchangeClass(no);
		} else if (category.equals("기부") || category.equals("1")) {
			giveSvc.delDonationClass(no);
		}
		return "redirect:/admin/board";
	}

//	admin member 리스트
	@RequestMapping("/admin/member")
	public String memberList(HttpSession session, Model model) {
		if (session.getAttribute("adminInfo") == null) {
			return "redirect:/admin";
		}
		ArrayList<Member> adminMemberList = memberSvc.adminMemberList();
		model.addAttribute("adminMemberList", adminMemberList);
		return "admin/member/admin_member";
	}

//	admin member 삭제
	@RequestMapping("/admin/memberDelete")
	public String deleteUser( @RequestParam("id") String id) {
		memberSvc.deleteUser(id);
		return "redirect:/admin/member";
	}
	
	// admin member 활성화 
	@RequestMapping("/admin/memberUpdate")
	public String updateMember(@RequestParam("id") String id) {
		memberSvc.updateUser(id);
		return "redirect:/admin/member";
	}

//	admin qna 리스트 
	@RequestMapping("/admin/qna")
	public String adminQnaList(HttpSession session, Model model) {
		if (session.getAttribute("adminInfo") == null) {
			return "redirect:/admin";
		}
		ArrayList<Qna> adminQnaList = qnaSvc.adminQnaList();
		model.addAttribute("adminQnaList", adminQnaList);
		return "admin/qna/admin_qna";
	}

//	admin qna 상세페이지 출력
	@RequestMapping("/admin/qnaDetail&{no}")
	public String adminQnaDetail(HttpSession session, @PathVariable("no") int no, Model model) {
		if (session.getAttribute("adminInfo") == null) {
			return "redirect:/admin";
		}
		Qna adminQnaDetail = qnaSvc.adminQnaDetail(no);
		model.addAttribute("adminQnaDetail", adminQnaDetail);
		return "admin/qna/admin_qnaDetail";
	}

//	admin qna 답변 등록
	@RequestMapping("admin/adminQnaWrite")
	public String adminQnaWrite(AdminQnaWriteCommand adminQnaWriteComm) {
		qnaSvc.adminQnaWrite(adminQnaWriteComm);
		return "redirect:/admin/qna";
	}

//	admin faq 리스트 출력	
	@RequestMapping("/admin/faq")
	public String faqList(HttpSession session, Model model) {
		if (session.getAttribute("adminInfo") == null) {
			return "redirect:/admin";
		}
		ArrayList<Faq> faqList = qnaSvc.faqList();
		model.addAttribute("adminFaqList", faqList);
		return "admin/qna/admin_faq";
	}

//	admin faq 등록
	@RequestMapping("/admin/faqWrite")
	public String adminFaqWrite( AdminFaqCommand adminFaqComm) {
		qnaSvc.adminFaqWrite(adminFaqComm);
		return "redirect:/admin/faq";
	}

//	admin faq 삭제
	@RequestMapping("/admin/faqDelete")
	public String adminFaqDelete( @RequestParam("no") int no) {
		qnaSvc.adminFaqDelete(no);
		return "redirect:/admin/faq";
	}

}
