package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.JoinRequest;
import dto.LoginInfo;
import dto.Member;
import service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberSvc;
	// 자동 주입

	@RequestMapping("/mypage/memberinfo")
	public String mypage(Model model, HttpSession session) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		Member member = memberSvc.myinfo(loginInfo.getId());
		model.addAttribute("member", member);
		return "mypage/memberinfo";
	}

	/*
	 * @RequestMapping("/mypage/memberinfo") public String
	 * memberupdate(ModelAttribute MemberVO, Model model) { boolean result =
	 * MemberService.checkPw(vo.getUserId(),vo.getUserPw()); }
	 */
	
	
	@RequestMapping(value="/mypage/modify" , method = RequestMethod.POST)
	public String modify(JoinRequest joinReq) {
		memberSvc.modify(joinReq);
		return "redirect:/mypage/memberinfo";
	}

	@RequestMapping("/findId")
	public String findIdForm() {
		return "member/findid";
	}

	@ResponseBody
	@RequestMapping(value = "/findId/Result", method = RequestMethod.POST)
	public String findId(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email) {
		String findResult = "";
		String id = memberSvc.findId(name, email);
		if (id != null) {
			findResult = id;
			return findResult;
		}
		return findResult;
	}

	@RequestMapping("/findPassword")
	public String findPassword() {
		return "member/findpw";
	}

	@ResponseBody
	@RequestMapping(value = "/findPassword/Result", method = RequestMethod.POST)
	public String findId(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email,
			@RequestParam(value = "id") String id) {
		String findResult = "";
		String passsword = memberSvc.findPassword(name, email, id);
		if (id != null) {
			findResult = passsword;
			return findResult;
		}
		return findResult;
	}

	@RequestMapping("/mypage/delete")
	public String deleteUser(@RequestParam(value = "id") String id, @RequestParam(value = "password") String password) {
		if(memberSvc.login(id, password) != null) {
			memberSvc.deleteUser(id);
			return "redirect:/logout";
		};
		return "redirect:/member/myinfo";
	}

}
