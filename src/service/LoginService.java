package service;

public class LoginService {
//	private MemberDao memberDao;
//
//	public LoginService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}

	
/*	public LoginInfo login(String id, String password) {
		// id에 해당하는 회원정보를 불러옴
		Member member = memberDao.SelectId(id);
		
		// 가입 된 회원정보가 없을 경우 예외처리
		if (member == null) {
			throw new LoginException();
		}
		// 회원정보는 있으나 패스워드가 일치하지 않을 경우 예외처리
		if (!member.matchPassword(password)) {
			throw new LoginException();
		}
		// 회원정보도 있으며 패스워드도 일치할 경우 실행
		return new LoginInfo(member.getId(), member.getPassword(), member.getName());
	}*/
	
//	public LoginInfo login(String id, String password) {
//		LoginInfo loginInfo = null;
//		
//		// id에 해당하는 회원정보를 불러옴
//		Member member = memberDao.SelectId(id);
//		
//		// 회원정보도 있으며 패스워드도 일치할 경우 실행
//		if(member != null && member.matchPassword(password)) {
//			return new LoginInfo(member.getId(), member.getName());
//		}
//		return loginInfo;
//	}

}
