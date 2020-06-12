package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberList {
	private Map<String,Member> member = new HashMap<String,Member>();
	
	public MemberList() {
		//追加。
		Member abc = new Member("abc", "123", "田中太郎");
		member.put("abc", abc);
		Member def = new Member("def", "456", "山田花子");
		member.put("def", def);
		Member ghi = new Member("ghi", "789", "佐藤二朗");
		member.put("ghi", ghi);
	}
	
	public void addMemberList(/*String id, Member member*/) {
		//this.member.put(id,member);
		
		
		
	}
	
	public Member getMember(String id) {
		Member memberInfo = member.get(id);
		return memberInfo;
	}
	
	
}
