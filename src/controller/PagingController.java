/*package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.Donation;
import dto.PageMaker;
import service.GiveService;

@Controller
public class PagingController {
	

	@Autowired
	private GiveService giveSvc;
	
	@RequestMapping(value="/listtest")
	public String listtest(Locale locale, Model model) {
		return "test";
	}
	
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(HttpServletRequest request) {
		PageMaker pagemaker = new PageMaker();
		String pagenum = request.getParameter("pagenum"); // 페이지 값을 입력 받는다.
		String contentnum = request.getParameter("contentnum");// 한 페이지에 몇개 보일지
		System.out.println(contentnum);
		
		int cpagenum = Integer.parseInt(pagenum); // int 형으로 몇 번 페이지인지 페이지 값 형변환
		int ccontentnum = Integer.parseInt(contentnum);// int 형으로 한 페이지에 몇개 보일지 값 형변환

		---------페이지 객체에 새로운 정보 다시 지정해주는 부분------------------
		pagemaker.setTotalcount(giveSvc.donationCount());// 전체 게시글 개수 지정한다
		pagemaker.setPagenum(cpagenum - 1);// 현재 페이지를 페이지 객체에 다시 지정해준다//몇번 페이지인지 PageMaker에 세팅한다
		pagemaker.setContentnum(ccontentnum);// 한 페이지에 몇개씩 보여줄지 세팅한다
		pagemaker.setCurrentblock(cpagenum);// 현재 페이지블록이 몇번인지 현재 페이지 번호를 통해서 지정한다
		pagemaker.setLastblock(pagemaker.getTotalcount());// 마지막 블록 번호를 전체 게시글 수를 통해서 정한다

		---------페이지 객체에 새로운 정보 다시 지정해주는 부분------------------

		pagemaker.prevnext(cpagenum);// 현재 페이지 번호로 화살표 나타낼지 결정한다
		pagemaker.setStartPage(pagemaker.getCurrentblock());// 시작페이지 번호를 현재 페이지 블록으로 정한다
		pagemaker.setEndPage(pagemaker.getLastblock(), pagemaker.getCurrentblock());
		// 현재 블록 번호와 마지막 블록 번호를 보내서 대조하고 페이지 블록의 마지막 번호를 지정한다

		List<Donation> testlist = new ArrayList<Donation>();// 게시글 담을 리스트 선언
		testlist = giveSvc.donationList(pagemaker.getPagenum() * 10, pagemaker.getContentnum(), "", "1");// 리스트에 저장
		// 매퍼로 한 페이지에 몇개 보일지 ,몇번 페이지 인지 전달//매퍼.xml 에서 사용하기 위해서 곱하기 10을 한다

		request.setAttribute("list", testlist);// sql로 얻은 리스트를 .jsp페이지로 전달
		request.setAttribute("page", pagemaker);// 페이지 번호 객체 .jsp페이지로 전달
		return "list";

	}

}
*/