package controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dto.Donation;
import dto.Exchange;
import service.GiveService;

@Controller
public class GiveController {
	
	@Autowired
	private GiveService giveSvc;
	
	
	/*// 기부 목록 - 전체
	@RequestMapping("/give/donation")
	public String donationList(Model model) {
		ArrayList<Donation> donationList = giveSvc.donationList();
		model.addAttribute("donationList", donationList);
		return "give/donation";
	}
	
	// 기부 목록 - 카테고리 별
	@RequestMapping("/give/donation&{category}")
	public String donationCategoryList(@PathVariable("category") String category, Model model) {
		ArrayList<Donation> donationCategoryList = giveSvc.donationCategoryList(category);
		model.addAttribute("category", category);
		model.addAttribute("donationCategoryList", donationCategoryList);
		return "give/donation";
	}*/
	
	// index 검색기능
	@RequestMapping(value="/give/search_give", method={RequestMethod.GET, RequestMethod.POST})
	public String searchGive(
			@RequestParam(value="category", required=false) String searchOption,
			@RequestParam(value="key", required=false) String keyword, Model model) throws Exception {
		if(searchOption == null){
			searchOption = "";
			keyword="";
			ArrayList<Donation> donationList = giveSvc.donationList(keyword);
			model.addAttribute("donationList", donationList);
			model.addAttribute("keyword", keyword);
		}else if (searchOption.equals("기부")) {
			ArrayList<Donation> donationList = giveSvc.donationList(keyword);
			model.addAttribute("donationList", donationList);
			model.addAttribute("keyword", keyword);
		} else {
			ArrayList<Exchange> exchangeList = giveSvc.exchangeList(keyword);
			model.addAttribute("exchangeList", exchangeList);
			model.addAttribute("keyword", keyword);
		}
//			레코드의 갯수
//			int count = giveSvc.countArticle(searchOption, keyword);
//			ModelAndView 모델과 뷰
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list); // list
		map.put("count", count); // 레코드의 갯수
		map.put("searchOption", searchOption); // 검색옵션
		map.put("keyword", keyword); // 검색키워드
		mav.addObject("map",map); // 맵에 저장된 데이터를 mav에 저장
		mav.setViewName("donation/list"); // list.jsp로 list가 전달된다.*/		
		return "give/donation";
	} 
	
	// 새 기부 클래스 등록 양식
	@RequestMapping("/give/donationWriteForm")
	public String donationWriteForm() {
		return "give/donationWriteForm";
	}
	
	// 새 기부 클래스 등록
//	@RequestMapping(value="/regDonationClass", method={RequestMethod.GET, RequestMethod.POST})
	@RequestMapping(value="/regDonationClass", method=RequestMethod.POST)
	public String regDonationClass(Donation donation) {
		giveSvc.regDonationClass(donation);
		return "redirect:/give/search_give";
	}
	
	// 기부 상세
	@RequestMapping("/give/donationDetail&{no}")
	public String donationDetail(@PathVariable("no") int no, Model model) {
		Donation donationDetail = giveSvc.donationDetail(no);
		model.addAttribute("donationDetail", donationDetail);
		return "give/donationDetail";
	}
	
	
	
	
	
}