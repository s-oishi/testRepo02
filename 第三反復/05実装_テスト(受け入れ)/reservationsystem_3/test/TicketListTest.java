package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import domain.Ticket;
import domain.TicketList;

public class TicketListTest {
	private TicketList tl;
	private Ticket t;
	
	@Before
	public void setUp() {
		t = new Ticket(01, "abc", 1000, "2020/6/8", 10);
		tl = new TicketList();
		tl.addTicketList(01, t);
	}
	
	@Test
	public void ticketListTest_1_1() {
		tl.checkTicketNumber(01);
		Ticket a = t;
		assertThat(a, is(t));
	}
	
	@Test
	public void ticketListTest_1_2() {
		tl.checkTicketNumber(02);
		Ticket a = t;
		assertThat(a, is(t));
	}
	
	@Test
	public void ticketListTest_4_1() {
		TicketList tl2 = new TicketList();
		int a = 0;
		assertThat(a, is(tl2.getTicketTypeNo()));
	}
	
	@Test
	public void ticketListTest_4_2() {
		int a = 1;
		assertThat(a, is(tl.getTicketTypeNo()));
	}
	
	@Test
	public void ticketListTest_5_1() {
		Ticket[] at = tl.getTicketInfo();
		Ticket a = at[0];
		assertThat(a, is(t));
	}

}
