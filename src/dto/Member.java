package dto;

public class Member {
	private String id;
	private String password;
	private String email;
	private String phone;
	private String name;
	private int useyn;
	
	
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
