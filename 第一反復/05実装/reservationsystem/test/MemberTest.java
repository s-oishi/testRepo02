package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import domain.Member;

public class MemberTest {
	Member m;
	
	@Test
	public void memberTest_1_1() {
		m=new Member("abc","123","田中太郎");
		String a = "123";
		assertThat(a, is(m.getPass()));
	}
	
	@Test
	public void memberTest_2_1() {
		m=new Member("abc","123","田中太郎");
		String a = "田中太郎";
		assertThat(a, is(m.getMemberName()));
	}
	
	@Test
	public void memberTest_3_1() {
		m=new Member("abc","123","田中太郎");
		String a = "abc";
		assertThat(a, is(m.getID()));
	}

}
