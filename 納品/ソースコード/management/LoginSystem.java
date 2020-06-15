package management;

import db.MemberList;
import domain.Member;


public class LoginSystem implements DetailSystem {
	private MemberList memberList;

	public LoginSystem(MemberList memberList) {
		this.memberList = memberList;
	}
	public boolean userCheck(String id,String pass){

		boolean match = false;
		while(match == false) {
			Member m;
			String inID;
			String inPass;
			m = memberList.getMember(id);
			if(m == null) {
				break;
			}else {
				inID = memberList.getMember(id).getID();
			}

			if(inID != null) {
				inPass = memberList.getMember(inID).getPass();
				if(inPass.equals(pass)) {
					match = true;
				}else {
					break;
				}
			}else {
				break;
			}
		}
		return match;
	}
}
