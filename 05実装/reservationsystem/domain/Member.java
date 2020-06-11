package domain;

public class Member {
	private String id;
	private String passward;
	private String memberName;

	public Member(String id, String passward, String name) {
		this.id = id;
		this.passward = passward;
		this.memberName = name;
	}

	public String getPass() {
		return passward;
	}

	public String getMemberName() {
		return memberName;
	}
	
	public String getID() {
		return id;
	}
}
