package dto;

public class Member {
	private String id;			// 아이디
	private String password;	// 비밀번호
	private String email;		// 메일주소
	private String phone;		// 연락처
	private String name;		// 이름
	private int useyn;			// 사용여부 ( 1 탈퇴 2 사용중 ) 
	
	
	public int getUseyn() {
		return useyn;
	}

	public void setUseyn(int useyn) {
		this.useyn = useyn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}

}
