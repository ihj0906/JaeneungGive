package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dto.Admin;
import service.AdminLoginService;

@Controller
public class AdminLoginController {

	@Autowired
	private AdminLoginService adminLoginSvc;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String form() {
		return "admin/admin_login";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session) {
		Admin admin = adminLoginSvc.selectId(id, password);
		if(admin != null) {
			if (admin.getPassword().equals(password)) {
				session.setAttribute("adminInfo", admin);
				return "redirect:/admin/board";
			}
			return "admin/admin_login";
			
		}else {
			return "admin/admin_login";
		}
	}


	@RequestMapping("/adminlogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin";
	}
}
