package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.AdminController;
import controller.AdminLoginController;
import controller.ApplicantController;
import controller.BookmarkController;
import controller.GiveController;
import controller.IndexController;
import controller.IntroduceSiteController;
import controller.JoinController;
import controller.LoginController;
import controller.LogoutController;
import controller.MemberController;
import controller.MessageController;
import controller.MypageController;
import controller.QnaController;

@Configuration
//public class ControllerConfig implements WebMvcConfigurer {
public class ControllerConfig {

/*	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/main").setViewName("index");
		registry.addViewController("/index").setViewName("index");
	}*/

	@Bean
	public JoinController joinController() {
		return new JoinController();
	}
	
	@Bean
	public LoginController loginController() {
		return new LoginController();
	}
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	
	@Bean
	public MessageController messageController() {
		return new MessageController();
	}
	
	@Bean
	public GiveController giveController() {
		return new GiveController();
	}
	
	@Bean
	public QnaController qnaController() {
		return new QnaController();
	}
	
	@Bean
	public MemberController memberController() {
		return new MemberController();
	}

	@Bean
	public MypageController mypageController() {
		return new MypageController();
	}
	
	@Bean
	public BookmarkController bookmarkController() {
		return new BookmarkController();
}
	
	@Bean
	public IntroduceSiteController introducesitecontroller() {
		return new IntroduceSiteController();
	}
	
	@Bean
	public IndexController indexController() {
		return new IndexController();
	}

	@Bean
	public ApplicantController applicantController() {
		return new ApplicantController();
	}
	
	@Bean
	public AdminLoginController adminLoginController() {
		return new AdminLoginController();
	}
	
	@Bean
	public AdminController adminController() {
		return new AdminController();
	}
	
/*	@Bean
	public PagingController pagingController() {
		return new PagingController();
	}*/
}
