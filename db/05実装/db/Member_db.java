package db;

public class Member_db {
	private String id;
	private String password;
	private String memberName;
	
	
	void setID(String id) {
		this.id = id;
	}
	
	void setPass(String pass) {
		this.password = pass;
	}
	
	void setMemberName(String name) {
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
}
