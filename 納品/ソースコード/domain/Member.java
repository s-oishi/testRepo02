package domain;

public class Member {
	private String id;
	private String password;
	private String memberName;

	public Member() {
		
	}
	
	public Member(String id, String passward, String name) {
		this.id = id;
		this.password = passward;
		this.memberName = name;
	}

	public String getPass() {
		return password;
	}

	public String getMemberName() {
		return memberName;
	}
	
	public String getID() {
		return id;
	}
	
	
	public void setID(String id) {
		this.id = id;
	}
	
	public void setPass(String pass) {
		this.password = pass;
	}
	
	public void setMemberName(String name) {
		this.memberName = name;
	}
	
	
}
