package domain;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Reservation {
	private int reservationNumber;
	private String reservationDay;
	private int reservationSheetsNumber;
	private Member member;
	private Ticket ticket;

	public Reservation(Ticket ticket, Member member, int sheetsNo) {
		this.ticket = ticket;
		this.member = member;
		reservationSheetsNumber = sheetsNo;

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("y-M-d");
		reservationDay = sdf.format(d);
	}

	// 予約番号の設定
	public void setReservationNo(int no) {
		reservationNumber = no;
	}

	// 会員情報の取得
	public Member searchMember() {
		return member;
	}

	// チケット情報の取得
	public Ticket searchTicket() {
		return ticket;
	}

	// 予約枚数の取得
	public int getSheetsNo() {
		return reservationSheetsNumber;
	}

	// 予約番号の取得
	public int getReserveNumber() {
		return reservationNumber;
	}

	// 予約日の取得
	public String getReserveDay() {
		return reservationDay;
	}

}
