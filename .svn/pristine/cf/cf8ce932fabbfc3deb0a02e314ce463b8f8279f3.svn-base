package service;

import dao.MemberDao;

import dto.JoinRequest;
import dto.LoginInfo;
import dto.Member;

//회원가입 - 아이디 중복체크 > 패스워드 일치 체크 > 회원가입 완료

public class MemberService {
	private MemberDao memberDao;
	
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public LoginInfo login(String id, String password) {
		LoginInfo loginInfo = null;
		
		// id에 해당하는 회원정보를 불러옴
		Member member = memberDao.SelectId(id);
		
		// 회원정보도 있으며 패스워드도 일치할 경우 실행
		if(member != null && member.matchPassword(password)) {
			return new LoginInfo(member.getId(), member.getName(), member.getUseyn());
		}
		return loginInfo;
	}

	
	public void join(JoinRequest joinReq) {
		Member member = memberDao.SelectId(joinReq.getId());
		if (member != null) { 
			// id 일치
		}
		Member newMember = new Member ();
		newMember.setId(joinReq.getId());
		newMember.setPassword(joinReq.getPassword());
		newMember.setEmail(joinReq.getEmail());
		newMember.setPhone(joinReq.getPhone());
		newMember.setName(joinReq.getName());
		memberDao.join(newMember);
	}

	public Member myinfo(String id) {
		Member member = memberDao.SelectId(id);
		return member;
	}
	
	public Member selectId(String id) {
		return memberDao.SelectId(id);
	}
	
	public String findId(String name, String email) {
		return memberDao.findId(name,email);
	}
	
	public String findPassword(String name, String email, String id) {
		return memberDao.findPassword(name, email, id);
	}
	
	public void modify(JoinRequest joinReq) {
		memberDao.modify(joinReq);
	}
	
	public void deleteUser(String id) {
		memberDao.deleteUser(id);
	}
}
