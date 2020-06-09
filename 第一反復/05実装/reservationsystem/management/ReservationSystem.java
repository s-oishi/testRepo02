package management;

import domain.Member;
import domain.MemberList;
import domain.ReservationList;
import domain.Ticket;
import domain.TicketList;

public class ReservationSystem implements DetailSystem {
	private String id;
	// private int ticketNo;
	private int sheetsNo;
	private Ticket ticket;
	private TicketList ticketList;
	private ReservationList reservationList;
	private MemberList memberList;

	public ReservationSystem(TicketList ticketList, ReservationList reservationList, MemberList memberList) {
		this.ticketList = ticketList;
		this.reservationList = reservationList;
		this.memberList = memberList;
	}

	public boolean checkTicket(int ticketNo) {
		ticket = ticketList.checkTicketNumber(ticketNo);
		if (ticket == null) {
			return false;
		} else {
			// this.ticketNo = ticketNo;
			return true;
		}
	}

	public boolean checkSheetsNumer(int sheetsNo) {
		int stock = ticket.check();
		if (sheetsNo <= stock) {
			Member member = memberList.getMember(id);
			reservationList.reserve(ticket, member, sheetsNo);// 引数何渡す?
			ticket.stock(sheetsNo);
			return true;
		} else {
			return false;
		}
	}

	public boolean checkReservation(int reservationNo) {
		return reservationList.checkReservationNo(reservationNo);
	}

	public boolean cancel(int reservationNo) {// booleanでなくvoidでは？
		sheetsNo = reservationList.getReservationSheetsNumber(reservationNo);
		Ticket removeTicket = reservationList.removeReservationNo(reservationNo);
		removeTicket.stock(sheetsNo);
		return true;
	}

	public void sendID(String id) {
		this.id = id;
	}
}
