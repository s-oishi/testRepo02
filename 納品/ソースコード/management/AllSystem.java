package management;

import java.util.List;
import db.MemberList;
import domain.Reservation;
import db.ReservationList;
import domain.Ticket;
import db.TicketList;

public class AllSystem {
	// 追加
	private static ReservationList reservationlist = new ReservationList();
	private static MemberList memberlist = new MemberList();
	private static TicketList ticketlist = new TicketList();

	private LoginSystem loginSystem = new LoginSystem(memberlist);
	private ReservationSystem reservationSystem;
	private ShowTicketSystem showTicketSystem;
	private String loginId;
	private String loginPass;

	private static final AllSystem allsystem = new AllSystem(memberlist, ticketlist, reservationlist);

	private AllSystem(MemberList m, TicketList t, ReservationList r) {
		memberlist = m;
		ticketlist = t;
		reservationlist = r;
		loginSystem = new LoginSystem(memberlist);
		reservationSystem = new ReservationSystem(ticketlist, reservationlist, memberlist);
		showTicketSystem = new ShowTicketSystem(ticketlist, reservationlist);
	}

	public AllSystem(String id, String pass) {
		this.loginId = id;
		this.loginPass = pass;
	}

	public boolean userLogin() {
		boolean flag;
		flag = loginSystem.userCheck(loginId, loginPass);
		return flag;
	}

	// 全てのticketの情報
	public Ticket[] indicateAllTicketInfo() {
		showTicketSystem.searchTicketInfoNo();
		Ticket[] ticket = showTicketSystem.getAllTicketInfo();
		return ticket;

	}

	// ticketの予約
	public void ticketReserve(int i, Ticket t) {
		reservationSystem.sendID(this.loginId);

		/*boolean flag1 = false;
		while (flag1 == false) {
			flag1 = reservationSystem.checkTicket(t.getTicketNumber());

		}*/
		// System.out.println(flag1);
		boolean flag2 = false;
		while (flag2 == false) {

			flag2 = reservationSystem.reserveTicket(t,i);
		}

	}

	// 特定の会員の予約情報
	public boolean ticketCheck() {
		List<Reservation> reservation = showTicketSystem.useShowSystem(this.loginId);
		if (reservation.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public List<Reservation> showReserveInfo() {
		List<Reservation> reservation = showTicketSystem.useShowSystem(this.loginId);
		return reservation;
	}

	// ticketのキャンセル
	public boolean ticketCancel(int reservationNo) {
		boolean end = false;
		end = reservationSystem.cancel(reservationNo);
		return end;
	}

	public void setID(String id) {
		this.loginId = id;
	}

	public void setPass(String pass) {
		this.loginPass = pass;
	}

	public static AllSystem getAllSystemInstance() {
		return allsystem;
	}
}
