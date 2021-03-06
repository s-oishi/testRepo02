package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationList {
	private Map<Integer, Reservation> reservationList = new HashMap<Integer, Reservation>();
	private int reservationNo = 0;

	public ReservationList() {
		/*
		Ticket a = new Ticket(00, "×××",1000, "yyyy-mm-dd",0);
		Member m = new Member("","111","田中太郎");
		Reservation reservation = new Reservation(a, m, 0);
		reservationList.put(0, reservation);
		*/
	}

	public void reserve(Ticket ticket, Member member, int sheetsNo) {
		Reservation reservation = new Reservation(ticket, member, sheetsNo);
		reservationNo += 1;
		reservationList.put(reservationNo, reservation);
		reservation.setReservationNo(reservationNo);
	}

	public boolean checkReservationNo(int reservationNo) {
		for (Integer reservation : reservationList.keySet()) {
			if (reservation == reservationNo) {
				return true;
			}
		}
		return false;
	}

	public Ticket removeReservationNo(int reservationNo) {
		Ticket ticket=reservationList.get(reservationNo).searchTicket();
		int sheetsNo = reservationList.get(reservationNo).getSheetsNo();
		ticket.stock(-sheetsNo);
		reservationList.remove(reservationNo);
		return ticket;
	}

	public int getReservationSheetsNumber(int reservationNo) {
		Reservation reservation = reservationList.get(reservationNo);
		int sheetsNo = reservation.getSheetsNo();
		return sheetsNo;
	}

	public List<Reservation> getReserveInfo(String id) {
		List<Reservation> memberReservationList = new ArrayList<Reservation>();
		for (Reservation reservation : reservationList.values()) {
			Member member = reservation.searchMember();
			if ((member.getID()).equals(id)) {
				memberReservationList.add(reservation);
			}
		}
		return memberReservationList;
	}

}
