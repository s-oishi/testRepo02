package test;

import domain.MemberList;
import domain.ReservationList;
import domain.TicketList;
import management.AllSystem;

public class Main {
	
	public static void main(String[] args) {
		ReservationList reservationlist = new ReservationList();
		MemberList memberlist = new MemberList();
		TicketList ticketlist = new TicketList();
		
		AllSystem allsystem = new AllSystem(memberlist, ticketlist, reservationlist);
		
		
		allsystem.start();

	}

}
