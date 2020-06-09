package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import domain.Ticket;

public class TicketTest {
	Ticket t;
	
	
	@Test
	public void ticketTest_1_1() {
		t = new Ticket(01,"abc",1000,"2020/01/01",10);
		t.check();
		int a=10;
		assertThat(a,is(t.getStock()));
	}
	
	@Test
	public void ticketTest_2_1() {
		t = new Ticket(01,"abc",1000,"2020/01/01",10);
		t.stock(10);
		int a = 0;
		assertThat(a, is(t.getStock()));
	}
	
	@Test
	public void ticketTest_2_2() {
		t = new Ticket(01,"abc",1000,"2020/01/01",10);
		t.stock(-2);
		int a = 12;
		assertThat(a, is(t.getStock()));
	}
	
	@Test
	public void ticketTest_3_1() {
		t = new Ticket(01,"abc",1000,"2020/01/01",10);
		String a = "abc";
		assertThat(a, is(t.getTicketName()));
	}
	
	@Test
	public void ticketTest_4_1() {
		t = new Ticket(01,"abc",1000,"2020/01/01",10);
		int a = 01;
		assertThat(a, is(t.getTicketNumber()));
	}
	
	@Test
	public void ticketTest_5_1() {
		t = new Ticket(01,"abc",1000,"2020/01/01",10);
		int a = 1000;
		assertThat(a, is(t.getPrice()));
	}
	
	@Test
	public void ticketTest_6_1() {
		t = new Ticket(01,"abc",1000,"2020/01/01",10);
		String a = "2020/01/01";
		assertThat(a, is(t.getDay()));
	}
	
	@Test
	public void ticketTest_7_1() {
		t = new Ticket(01,"abc",1000,"2020/01/01",10);
		int a = 10;
		assertThat(a, is(t.getStock()));
	}
}
