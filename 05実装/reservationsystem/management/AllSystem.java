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

	
	//TODO シングルトン記述の追加
	public AllSystem(MemberList m, TicketList t, ReservationList r) {
		memberlist = m;
		ticketlist = t;
		reservationlist = r;
		loginSystem = new LoginSystem(memberlist);
		reservationSystem = new ReservationSystem(ticketlist, reservationlist, memberlist);
		showTicketSystem = new ShowTicketSystem(ticketlist, reservationlist);
	}
	
	
	//TODO 記述の変更
	public void start() {
		boolean flag = false;
		while(flag == false) {
			this.loginId = ui.userLoginID();
			String loginPass = ui.userLoginPass();
				flag = loginSystem.userCheck(loginId,loginPass);
		}
		
		//TODO 記述の変更
		while(true) {
		this.selectMenu();
		}
	}
	
	
	//型をTicket配列に変更。全てのticketの情報
	public Ticket[] showAllTicket() /*indicateAllTicketInfo()*/ {
		int number = showTicketSystem.searchTicketInfoNo();
		if(number == 0) {
			return null;
		}else {
			Ticket[] ticket = showTicketSystem.getAllTicketInfo();
			return ticket;
		}
		
	}
	//TODO ticketの予約
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
	
	//TODO 特定の会員の予約情報
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
	
	
	//メニュー表示
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
