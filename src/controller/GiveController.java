package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dto.Applicant;
import dto.Bookmark;
import dto.Donation;
import dto.Exchange;
import dto.Location;
import dto.LoginInfo;
import dto.PageMaker;
import service.ApplicantService;
import service.BookmarkService;
import service.GiveService;

@Controller
public class GiveController {

	@Autowired
	private GiveService giveSvc;
	@Autowired
	private ApplicantService applicantSvc;
	@Autowired
	private BookmarkService bookmarkSvc;

	/*
	 * // 기부 목록 - 전체
	 * 
	 * @RequestMapping("/give/donation") public String donationList(Model model) {
	 * ArrayList<Donation> donationList = giveSvc.donationList();
	 * model.addAttribute("donationList", donationList); return "give/donation"; }
	 * 
	 * // 기부 목록 - 카테고리 별
	 * 
	 * @RequestMapping("/give/donation&{category}") public String
	 * donationCategoryList(@PathVariable("category") String category, Model model)
	 * { ArrayList<Donation> donationCategoryList =
	 * giveSvc.donationCategoryList(category); model.addAttribute("category",
	 * category); model.addAttribute("donationCategoryList", donationCategoryList);
	 * return "give/donation"; }
	 */

	
	/*// index 검색기능 - 기부
	@RequestMapping(value = "/give/search_give_donation", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchGive_donation(@RequestParam(value = "category", required = false) String searchOption,
			@RequestParam(value = "key", required = false) String keyword, Model model, HttpSession session)
			throws Exception {
		// 로그인 한 사용자일 경우 북마크 정보를 가져와서 보여준다.
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		String id = "";
		if (loginInfo != null) {
			id = loginInfo.getId();
		}
		if (searchOption == null) {
			keyword = "";
			ArrayList<Donation> donationList = giveSvc.donationList(keyword, id);
			model.addAttribute("donationList", donationList);
			model.addAttribute("keyword", keyword);
		} else if (searchOption.equals("기부")) {
			ArrayList<Donation> donationList = giveSvc.donationList(keyword, id);
			model.addAttribute("donationList", donationList);
			model.addAttribute("keyword", keyword);
		}
		return "give/donation";
	}*/
	
	
	// index 검색기능 - 기부
	@RequestMapping(value = "/give/search_give_donation", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchGive_donation(@RequestParam(value = "category", required = false) String searchOption,
			@RequestParam(value = "key", required = false) String keyword, @RequestParam(value = "pagenum", required=false) String spagenum, Model model, HttpSession session)
					throws Exception {
		// 로그인 한 사용자일 경우 북마크 정보를 가져와서 보여준다.
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		String id = "";
		int pagenum=1;
		if(spagenum != null) {
			pagenum=Integer.parseInt(spagenum);
		}
		if(keyword == null) {
			keyword = "";
		}
		PageMaker pagemaker = new PageMaker();
		int contentnum = 10;//  한 페이지에 몇개 보일지 값 형변환

		/*---------페이지 객체에 새로운 정보 다시 지정해주는 부분------------------*/
		pagemaker.setTotalcount(giveSvc.donationCount(keyword));// 전체 게시글 개수 지정한다
		pagemaker.setPagenum(pagenum - 1);// 현재 페이지를 페이지 객체에 다시 지정해준다//몇번 페이지인지 PageMaker에 세팅한다
		pagemaker.setContentnum(contentnum);// 한 페이지에 몇개씩 보여줄지 세팅한다
		pagemaker.setCurrentblock(pagenum);// 현재 페이지블록이 몇번인지 현재 페이지 번호를 통해서 지정한다
		pagemaker.setLastblock(pagemaker.getTotalcount());// 마지막 블록 번호를 전체 게시글 수를 통해서 정한다

		/*---------페이지 객체에 새로운 정보 다시 지정해주는 부분------------------*/
		pagemaker.prevnext(pagenum);// 현재 페이지 번호로 화살표 나타낼지 결정한다
		pagemaker.setStartPage(pagemaker.getCurrentblock());// 시작페이지 번호를 현재 페이지 블록으로 정한다
		pagemaker.setEndPage(pagemaker.getLastblock(), pagemaker.getCurrentblock());
		// 현재 블록 번호와 마지막 블록 번호를 보내서 대조하고 페이지 블록의 마지막 번호를 지정한다

		// 매퍼로 한 페이지에 몇개 보일지 ,몇번 페이지 인지 전달//매퍼.xml 에서 사용하기 위해서 곱하기 10을 한다

		model.addAttribute("page", pagemaker);// 페이지 번호 객체 .jsp페이지로 전달
		
		if (loginInfo != null) {
			id = loginInfo.getId();
		}
		if (searchOption == null) {
			ArrayList<Donation> donationList = giveSvc.donationList(pagemaker.getPagenum() * 10, pagemaker.getContentnum(), keyword, id);
			ArrayList<Bookmark> bookmarkList = bookmarkSvc.listOfBookmark(pagemaker.getPagenum() * 10, pagemaker.getContentnum(), 1, id);
			model.addAttribute("bookmarkList", bookmarkList);
			model.addAttribute("donationList", donationList);
			model.addAttribute("keyword", keyword);
		} else if (searchOption.equals("기부")) {
			ArrayList<Donation> donationList = giveSvc.donationList(pagemaker.getPagenum() * 10, pagemaker.getContentnum(), keyword, id);
			ArrayList<Bookmark> bookmarkList = bookmarkSvc.listOfBookmark(pagemaker.getPagenum() * 10, pagemaker.getContentnum(), 1, id);
			model.addAttribute("bookmarkList", bookmarkList);
			model.addAttribute("donationList", donationList);
			model.addAttribute("keyword", keyword);
		}
		return "give/donation";
	}
	
	
/*
	// index 검색기능 - 교환
	@RequestMapping(value = "/give/search_give_exchange", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchGive_exchange(@RequestParam(value = "category", required = false) String searchOption,
			@RequestParam(value = "key", required = false) String keyword, Model model, HttpSession session)
			throws Exception {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		String id = "";
		if (loginInfo != null) {
			id = loginInfo.getId();
		}
		if (searchOption == null) {
			keyword = "";
			ArrayList<Exchange> exchangeList = giveSvc.exchangeList(keyword, id);
			model.addAttribute("exchangeList", exchangeList);
			model.addAttribute("keyword", keyword);
		} else if (searchOption.equals("교환")) {
			ArrayList<Exchange> exchangeList = giveSvc.exchangeList(keyword, id);
			model.addAttribute("exchangeList", exchangeList);
			model.addAttribute("keyword", keyword);
		}
		return "give/exchange";
	}
	*/
	
	
	// index 검색기능 - 교환
	@RequestMapping(value = "/give/search_give_exchange", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchGive_exchange(@RequestParam(value = "category", required = false) String searchOption,
			@RequestParam(value = "key", required = false) String keyword,  @RequestParam(value = "pagenum", required=false) String spagenum, Model model, HttpSession session)
					throws Exception {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		String id = "";
		
		int pagenum=1;
		if(spagenum != null) {
			pagenum=Integer.parseInt(spagenum);
		}
		PageMaker pagemaker = new PageMaker();
		int contentnum = 10;//  한 페이지에 몇개 보일지 값 형변환

		/*---------페이지 객체에 새로운 정보 다시 지정해주는 부분------------------*/
		pagemaker.setTotalcount(giveSvc.exchangeCount(keyword));// 전체 게시글 개수 지정한다
		pagemaker.setPagenum(pagenum - 1);// 현재 페이지를 페이지 객체에 다시 지정해준다//몇번 페이지인지 PageMaker에 세팅한다
		pagemaker.setContentnum(contentnum);// 한 페이지에 몇개씩 보여줄지 세팅한다
		pagemaker.setCurrentblock(pagenum);// 현재 페이지블록이 몇번인지 현재 페이지 번호를 통해서 지정한다
		pagemaker.setLastblock(pagemaker.getTotalcount());// 마지막 블록 번호를 전체 게시글 수를 통해서 정한다

		/*---------페이지 객체에 새로운 정보 다시 지정해주는 부분------------------*/
		pagemaker.prevnext(pagenum);// 현재 페이지 번호로 화살표 나타낼지 결정한다
		pagemaker.setStartPage(pagemaker.getCurrentblock());// 시작페이지 번호를 현재 페이지 블록으로 정한다
		pagemaker.setEndPage(pagemaker.getLastblock(), pagemaker.getCurrentblock());
		// 현재 블록 번호와 마지막 블록 번호를 보내서 대조하고 페이지 블록의 마지막 번호를 지정한다

		// 매퍼로 한 페이지에 몇개 보일지 ,몇번 페이지 인지 전달//매퍼.xml 에서 사용하기 위해서 곱하기 10을 한다

		model.addAttribute("page", pagemaker);// 페이지 번호 객체 .jsp페이지로 전달
		
		if (loginInfo != null) {
			id = loginInfo.getId();
		}
		if (searchOption == null) {
			keyword = "";
			ArrayList<Exchange> exchangeList = giveSvc.exchangeList(pagemaker.getPagenum() * 10, pagemaker.getContentnum(), keyword, id);
			ArrayList<Bookmark> bookmarkList = bookmarkSvc.listOfBookmark(pagemaker.getPagenum() * 10, pagemaker.getContentnum(), 2, id);
			model.addAttribute("bookmarkList", bookmarkList);
			model.addAttribute("exchangeList", exchangeList);
			model.addAttribute("keyword", keyword);
		} else if (searchOption.equals("교환")) {
			ArrayList<Exchange> exchangeList = giveSvc.exchangeList(pagemaker.getPagenum() * 10, pagemaker.getContentnum(), keyword, id);
			ArrayList<Bookmark> bookmarkList = bookmarkSvc.listOfBookmark(pagemaker.getPagenum() * 10, pagemaker.getContentnum(), 2, id);
			model.addAttribute("bookmarkList", bookmarkList);
			model.addAttribute("exchangeList", exchangeList);
			model.addAttribute("keyword", keyword);
		}
		return "give/exchange";
	}

	
	// 새 게시글 등록&수정 (폼으로)
	@RequestMapping(value = "/give/writeForm&{board}&{no}", method = { RequestMethod.GET, RequestMethod.POST })
	public String donationWriteForm(@PathVariable("board") String board, @PathVariable("no") int no, Model model) {
		if (board.equals("donation")) {
			// 수정 폼으로
			if (no != 0) {
				Donation modDonation = giveSvc.donationDetail(no);
				model.addAttribute("modDonation", modDonation);
				return "give/donationWriteForm";
			}
			// 등록 폼으로
			return "give/donationWriteForm";
		} else {
			// 수정 폼으로
			if (no != 0) {
				Exchange modExchange = giveSvc.exchangeDetail(no);
				model.addAttribute("modExchange", modExchange);
				return "give/exchangeWriteForm";
			}
			// 등록 폼으로
			return "give/exchangeWriteForm";
		}
	}

	
	// 새 게시글 등록 완료
	@RequestMapping(value = "/regClass&{board}", method = { RequestMethod.GET, RequestMethod.POST })
	public String regDonationClass(@PathVariable(value="board", required=false) String board, Donation donation, Exchange exchange) {
		if (board.equals("donation")) {
			giveSvc.regDonationClass(donation);
			return "redirect:/give/search_give_donation";
		} else {
			giveSvc.regExchangeClass(exchange);
			return "redirect:/give/search_give_exchange";
		}
	}

	
	// 해당 게시글 수정 완료
	@RequestMapping(value = "/modClass&{board}", method = { RequestMethod.GET, RequestMethod.POST })
	public String modDonationClass(@PathVariable("board") String board, Donation donation, Exchange exchange) {
		if (board.equals("donation")) {
			giveSvc.modDonationClass(donation);
			return "redirect:/give/search_give_donation";
		} else {
			giveSvc.modExchangeClass(exchange);
			return "redirect:/give/search_give_exchange";
		}
	}

	
	// 해당 게시글 삭제
	@RequestMapping("/give/delClass&{board}&{no}")
	public String deleteClass(@PathVariable("board") String board, @PathVariable("no") int no) {
		if (board.equals("donation")) {
			giveSvc.delDonationClass(no);
			return "redirect:/give/search_give_donation";
		} else {
			giveSvc.delExchangeClass(no);
			return "redirect:/give/search_give_exchange";
		}
	}

	
	/**
	 * 기부 상세 페이지
	 * @param no 게시물 번호
	 * @return
	 */
	@RequestMapping("/give/donationDetail&{no}")
	public String donationDetail(@PathVariable("no") int no, Model model, HttpSession session) {
		// 로그인 한 사용자일 경우 북마크 정보를 가져와서 보여준다.
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		String id = "";
		if (loginInfo != null) {
			id = loginInfo.getId();
//			model.addAttribute("bookmark", bookmarkSvc.checkbookmark(loginInfo.getId(), no, 1));
		}
		ArrayList<Applicant> listOfApplicant = applicantSvc.listOfApplicant(no, 1);
		Donation donationDetail = giveSvc.donationDetail(no, id);
		Bookmark bookmark = bookmarkSvc.checkbookmark(id, no, 1);
		model.addAttribute("bookmark", bookmark);
		model.addAttribute("donationDetail", donationDetail);
		model.addAttribute("listOfApplicant", listOfApplicant);
		model.addAttribute("applicant", applicantSvc.applicant(no, 1, id));
		return "give/donationDetail";
	}

	// 교환 상세
	@RequestMapping("/give/exchangeDetail&{no}")
	public String exchangeDetail(@PathVariable("no") int no, Model model, HttpSession session) {
		// 로그인 한 사용자일 경우 북마크 정보를 가져와서 보여준다.
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		String id = "";
		if (loginInfo != null) {
			id = loginInfo.getId();
//			model.addAttribute("bookmark", bookmarkSvc.checkbookmark(loginInfo.getId(), no, 2));
		}
		ArrayList<Applicant> listOfApplicant = applicantSvc.listOfApplicant(no, 2);
		Exchange exchangeDetail = giveSvc.exchangeDetail(no, id);
		Bookmark bookmark = bookmarkSvc.checkbookmark(id, no, 2);
		model.addAttribute("bookmark", bookmark);
		model.addAttribute("exchangeDetail", exchangeDetail);
		model.addAttribute("listOfApplicant", listOfApplicant);
		model.addAttribute("applicant", applicantSvc.applicant(no, 2, id));
		return "give/exchangeDetail";
	}
	
	
	@RequestMapping(value = "/give/searchLocation", method = { RequestMethod.GET, RequestMethod.POST })
	public String search_location(@RequestParam(value="lo", required=false) String lo, Model model) {
		if (lo == null) {
			return "give/searchLocation";
		} else {
			ArrayList<Location> locationList = giveSvc.locationList(lo);
			model.addAttribute("locationList", locationList);
			return "give/searchLocation";
		}
	}
	
	
	
	

}