package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationList {
	private Map<Integer, Reservation> reservationList = new HashMap<Integer, Reservation>();
	private int reservationNo = 0;

	public ReservationList() {
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
		reservationList.remove(reservationNo);
		return ticket;
	}

	public int getReservationSheetsNumber(int reservationNo) {
		Reservation reservation = reservationList.get(reservationNo);
		int sheetsNo = reservation.getSheetsNo();
		return sheetsNo;
	}

	public List<Reservation> getReserveInfo(String id) {
		List<Reservation> mamberReservationList = new ArrayList<Reservation>();
		for (Reservation reservation : reservationList.values()) {
			Member member = reservation.searchMember();
			if ((member.getID()).equals(id)) {
				mamberReservationList.add(reservation);
			}
		}
		return mamberReservationList;
	}

}
