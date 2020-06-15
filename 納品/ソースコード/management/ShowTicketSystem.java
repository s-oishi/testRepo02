package management;

import java.util.List;
//import java.util.Map;

import domain.Reservation;
import db.ReservationList;
import domain.Ticket;
import db.TicketList;

public class ShowTicketSystem implements DetailSystem{
	
	private TicketList ticketList;
	private ReservationList reservationList;
	
	public ShowTicketSystem(TicketList tList ,ReservationList rList) {
		this.ticketList = tList;
		this.reservationList = rList;
	}
	
	public int searchTicketInfoNo() {
		return ticketList.getTicketTypeNo();
	}
	
	public Ticket[] getAllTicketInfo() {
		return ticketList.getTicketInfo();
	}
	
	public List<Reservation> useShowSystem(String id) {
		return reservationList.getReserveInfo(id);
	}
}

