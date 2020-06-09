package management;
import java.util.List;

import domain.MemberList;
import domain.Reservation;
import domain.ReservationList;
import domain.Ticket;
import domain.TicketList;
import ui.UI;


public class AllSystem {
	
	//追加
	private MemberList memberlist;
	private TicketList ticketlist;
	private ReservationList reservationlist;
	
	private LoginSystem loginSystem = new LoginSystem(memberlist);
	private ReservationSystem reservationSystem;
	private ShowTicketSystem showTicketSystem;
	private String loginId;
	private UI ui = new UI();

	
	
	public AllSystem(MemberList m, TicketList t, ReservationList r) {
		memberlist = m;
		ticketlist = t;
		reservationlist = r;
		loginSystem = new LoginSystem(memberlist);
		reservationSystem = new ReservationSystem(ticketlist, reservationlist, memberlist);
		showTicketSystem = new ShowTicketSystem(ticketlist, reservationlist);
	}
	
	public void start() {
		boolean flag = false;
		while(flag == false) {
			this.loginId = ui.userLoginID();
			String loginPass = ui.userLoginPass();
				flag = loginSystem.userCheck(loginId,loginPass);
		}
		
		while(true) {
		this.selectMenu();
		}
	}
	//全てのticketの情報
	public void indicateAllTicketInfo() {
		int number = showTicketSystem.searchTicketInfoNo();
		if(number == 0) {
			ui.showNotingTicket();
		}else {
			Ticket[] ticket = showTicketSystem.getAllTicketInfo();
			ui.showAllTicketInfo(ticket);
		}
		
	}
	//ticketの予約
	public void ticketReserve() {
		reservationSystem.sendID(this.loginId);
		boolean flag1 = false;
		while(flag1 == false) {
			int ticketNo = ui.inputTicketNo();
			
			if(ticketNo == 0) {
				this.selectMenu();
			}else {
				flag1 = reservationSystem.checkTicket(ticketNo);
			}
		}
		boolean flag2 = false;
		while(flag2 == false) {
			int sheetsNo = ui.inputSheetsNumber();
			flag2 = reservationSystem.checkSheetsNumer(sheetsNo);
		}
		ui.reserveEnd();
		
	}
	
	//特定の会員の予約情報
	public boolean ticketCheck() {
		List<Reservation> reservation = showTicketSystem.useShowSystem(this.loginId);
		ui.showAllReserveInfo(reservation);
		if(reservation.size()==0) {
			return false;
		}else {
			return true;
		}
	}
	//ticketのキャンセル
	public void ticketCancel() {
		boolean flag1 = false;
		int reservationNo = 0;
		while(flag1 == false) {
			reservationNo = ui.inputReservation();
			
			if(reservationNo == 0) {
				this.selectMenu();
			}else {
				flag1 = reservationSystem.checkReservation(reservationNo);
			}
		}
		
		if(ui.checkCancel()==true) {
			boolean flag2 = reservationSystem.cancel(reservationNo);
			if(flag2 == true) {
				ui.cancelEnd();
			}
		}


	}
	
	
	//追加。メニュー表示
	public void selectMenu() {
		switch(ui.selectSystem()){
		case 1:
			this.indicateAllTicketInfo();
			this.ticketReserve();
			break;
		case 2:
			boolean canCancel = this.ticketCheck();
			if(canCancel==true) {
				this.ticketCancel();
			}
			break;
		default:
			break;
		}
	}
	
	
	
}
