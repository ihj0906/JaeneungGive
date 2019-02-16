package controller;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.JoinRequest;
import service.MemberService;

@Controller
public class JoinController {

	@Autowired
	private MemberService memberSvc;

	@RequestMapping("/join/terms")
	public String terms() {
		return "member/contract";
	}

	@RequestMapping(value = "/join/signup", method = RequestMethod.POST)
	public String signupForm(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
		if (!agree) {
			return "member/contract";
		}
//		model.addAttribute("joinRequest", new JoinRequest());
		return "member/join";
	}

	@RequestMapping(value = "/join/signup", method = RequestMethod.GET)
	public String signupGet() {
		return "redirect:terms";
	}

	@RequestMapping(value = "/join/welcome", method = RequestMethod.POST)
	public String welcome(JoinRequest joinReq) {
		memberSvc.join(joinReq);
		return "redirect:/login";
	}

	@ResponseBody
	@RequestMapping(value = "/join/idCheck", method = RequestMethod.POST)
	public String checkId(HttpServletRequest req, @RequestParam(value="id") String id) {
		
		String idCheckResult = "0";
		if (memberSvc.selectId(id) != null) {
			idCheckResult = "1";
		}
		return idCheckResult;
	}

	/*
	 * @RequestMapping(value = "/join/checkId", method=RequestMethod.POST) public
	 * String checkId(@RequestParam(value = "id") String id, Model model) { boolean
	 * idCheckResult = false; if(memberSvc.selectId(id) != null) { idCheckResult =
	 * true; } model.addAttribute("idCheckResult", idCheckResult);
	 * model.addAttribute("id", id); return "member/checkId"; }
	 */

}
