package domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TicketList {
	private Map<Integer, Ticket> ticket = new HashMap<Integer, Ticket>();
	
	public TicketList() {
		Ticket a = new Ticket(01, "東京ランド", 5000, "2020-07-07", 100);
		ticket.put(01,a);
		Ticket b = new Ticket(02, "大阪パーク", 4000, "2020-08-08", 80);
		ticket.put(02,b);
		Ticket c = new Ticket(03, "横浜ポート", 3000, "2020-06-06", 50);
		ticket.put(03,c);
	}
	
	public void addTicketList(int no, Ticket t) {
		ticket.put(no, t);
	}

	/*public Ticket checkTicketNumber(int ticketNo) {
		// boolean flag = false;
		Ticket ticketOb = new Ticket(1, "a", 100, "2000/1/1", 1);
		for (int i = 0; i < ticket.size(); i++) {
			if (ticket.get(ticketNo) != null) {
				ticketOb = ticket.get(ticketNo);
				return ticketOb;
				// flag = true;
			}
		}
		return null;

	}*/

	/*
	 * public int checkStrock(int ticketNo) { int sheetNumber =
	 * ticket.get(ticketNo).check(); return sheetNumber; }
	 * 
	 * public void updateStock(int ticketNumber, int sheet) {
	 * 
	 * }
	 */
	public int getTicketTypeNo() {
		int size = ticket.size();
		return size;
	}

	public Ticket[] getTicketInfo() {
		Ticket[] allTickets = new Ticket[ticket.size()];
		Iterator<Ticket> it = ticket.values().iterator();
		int n = 0;
		while(it.hasNext()) {
			allTickets[n] = it.next();
			n++;
		}
		return allTickets;
	}
}

