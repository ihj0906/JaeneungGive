package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dto.Bookmark;
import dto.Donation;
import dto.Exchange;
import dto.LoginInfo;
import service.BookmarkService;
import service.GiveService;

@Controller
public class IndexController {

	@Autowired
	private GiveService giveSvc;
	
	@Autowired
	private BookmarkService bookmarkSvc;

	@RequestMapping(value = { "/index", "/main"})
	public String index(Model model, HttpSession session) {
		// 로그인 한 사용자일 경우 북마크 정보를 가져와서 보여준다.
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		String keyword = "";
		String id = "";
		if (loginInfo != null) {
			id = loginInfo.getId();
		}
//		ArrayList<Donation> donationList = giveSvc.donationList();
//		ArrayList<Exchange> exchangeList = giveSvc.exchangeList(keyword, id);
		ArrayList<Donation> donationList = giveSvc.donationList(0, 4, "", id);
		ArrayList<Exchange> exchangeList = giveSvc.exchangeList(0, 4, "", id);
		
		ArrayList<Bookmark> bookmarkList = bookmarkSvc.listOfBookmark(0, 4, 1, id);
		ArrayList<Bookmark> bookmarkListE = bookmarkSvc.listOfBookmark(0, 4, 2, id);
		model.addAttribute("bookmarkList", bookmarkList);
		model.addAttribute("bookmarkListE", bookmarkListE);
		model.addAttribute("donationList", donationList);
		model.addAttribute("exchangeList", exchangeList);
		return "index";
	}
}