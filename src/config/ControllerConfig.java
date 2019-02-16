package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import controller.GiveController;
import controller.JoinController;
import controller.LoginController;
import controller.LogoutController;
import controller.MemberController;
import controller.MessageController;
import controller.MypageController;
import controller.QnaController;

@Configuration
public class ControllerConfig implements WebMvcConfigurer {

	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/main").setViewName("index");
		registry.addViewController("/index").setViewName("index");
	}

	@Bean
	public JoinController joinController() {
		JoinController joinCtrl = new JoinController();
		return joinCtrl;
	}
	
	@Bean
	public LoginController loginController() {
		LoginController loginCtrl = new LoginController();
		return loginCtrl;
	}
	
	@Bean
	public LogoutController logoutController() {
		LogoutController logoutCtrl = new LogoutController();
		return logoutCtrl;
	}
	
	@Bean
	public MessageController messageController() {
		MessageController messageCtrl = new MessageController();
		return messageCtrl;
	}
	
	@Bean
	public GiveController giveController() {
		GiveController giveCtrl = new GiveController();
		return giveCtrl;
	}
	
	@Bean
	public QnaController qnaController() {
		QnaController qnaCtrl = new QnaController();
		return qnaCtrl;
	}
	
	@Bean
	public MemberController memberController() {
		MemberController memberCtrl = new MemberController();
		return memberCtrl;
	}

	@Bean
	public MypageController mypageController() {
		MypageController mypageCtrl = new MypageController();
		return mypageCtrl;
	}
	
}