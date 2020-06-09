package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import domain.Member;
import domain.Reservation;
import domain.Ticket;

public class ReservationTest {
	Reservation r;
	Member m;
	Ticket t;
	
	@Before
	public void setUp() {
		m = new Member("abc", "123", "田中太郎");
		t = new Ticket(123, "ABC", 1000, "2020/01/01", 10);
		r = new Reservation(t, m, 3);
		r.setReservationNo(01);
	}
	
	@Test
	public void reservationTest_1_1() {
		int a = 3;
		assertThat(a, is(r.getSheetsNo()));
	}
	
	@Test
	public void reservationTest_2_1() {
		Member a = m;
		assertThat(a, is(r.searchMember()));
	}
	
	@Test
	public void reservationTest_3_1() {
		Ticket a = t;
		assertThat(a, is(r.searchTicket()));
	}
	
	@Test
	public void reservationTest_4_1() {
		int a = 01;
		assertThat(a, is(r.getReserveNumber()));
	}
	
	@Test
	public void reservationTest_5_1() {
		String a = "2020/6/8";
		assertThat(a, is(r.getReserveDay()));
	}
	
	
}
