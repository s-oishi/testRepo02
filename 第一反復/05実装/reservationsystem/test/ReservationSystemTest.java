package test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import domain.Member;
import domain.MemberList;
import domain.ReservationList;
import domain.Ticket;
import domain.TicketList;
import management.ReservationSystem;

public class ReservationSystemTest {
	ReservationSystem r;
	TicketList tL;
	ReservationList rL;
	MemberList mL;
	
	@Before
	public void setUp() {
		tL = new TicketList();
		rL = new ReservationList();
		mL = new MemberList();
		r = new ReservationSystem(tL,rL,mL);
	}
	
	@Test
	public void test1_1() {
		Ticket t1 = new Ticket(1,"山田太郎",5000,"6/1",5);
		tL.addTicketList(01, t1);
		boolean result = r.checkTicket(01);
		boolean expected_result = true;
		assertThat(result, is(expected_result));
	}
	
	@Test
	public void test1_2() {
		Ticket t1 = new Ticket(1,"山田太郎",5000,"6/1",5);
		tL.addTicketList(01, t1);
		boolean result = r.checkTicket(02);
		boolean expected_result = false;
		assertThat(result, is(expected_result));
	}
	
	@Test
	public void test2_1() {
		Ticket t1 = new Ticket(1,"山田太郎",5000,"6/1",10);
		tL.addTicketList(01, t1);
		boolean a = r.checkTicket(01);
		boolean result = r.checkSheetsNumer(10);
		boolean expected_result = true;
		assertThat(result, is(expected_result));
	}
	
	@Test
	public void test2_2() {
		Ticket t1 = new Ticket(1,"山田太郎",5000,"6/1",10);
		tL.addTicketList(01, t1);
		boolean a = r.checkTicket(01);
		boolean result = r.checkSheetsNumer(11);
		boolean expected_result = false;
		assertThat(result, is(expected_result));
	}
	
	@Test
	public void test3_1() {
		Ticket t1 = new Ticket(0,"山田太郎",5000,"6/1",10);
		Member m1 = new Member("12345","abcde","山田太郎");
		rL.reserve(t1, m1, 1);
		boolean result =r.checkReservation(1);
		boolean expected_result = true;
		assertThat(result, is(expected_result));
	}
	
	@Test
	public void test3_2() {
		Ticket t1 = new Ticket(1,"山田太郎",5000,"6/1",10);
		Member m1 = new Member("12345","abcde","山田太郎");
		rL.reserve(t1, m1, 1);
		boolean result =r.checkReservation(2);
		boolean expected_result = false;
		assertThat(result, is(expected_result));
	}
	
	@Test
	public void test4_1() {
		Ticket t1 = new Ticket(1,"山田太郎",5000,"6/1",10);
		Member m1 = new Member("12345","abcde","山田太郎");
		rL.reserve(t1, m1, 1);
		boolean result =r.cancel(1);
		boolean expected_result = true;
		assertThat(result, is(expected_result));
	}
	
	@Test
	public void test5_1() {
		String id = "1234";
		r.sendID(id);
		Member m1 = mL.getMember(id);
		assertThat(m1.getID(), is("1234"));
	}
}
