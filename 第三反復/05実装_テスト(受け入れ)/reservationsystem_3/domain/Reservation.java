package domain;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Reservation {
	private int reservationNumber;
	private String reservationDay;
	private int reservationSheetsNumber;
	//変更。
	//private String memberid;
	//private int ticketNo;
	//追加。
	private String membername;
	private String ticketName;

	public Reservation() {
		
	}
	
	/*public Reservation(Ticket ticket, Member member, int sheetsNo) {
		this.ticket = ticket;
		this.member = member;
		reservationSheetsNumber = sheetsNo;

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("GGGGy- M- d");
		reservationDay = sdf.format(d);
	}*/

	// 予約番号の設定
	public void setReservationNo(int no) {
		reservationNumber = no;
	}

	// 予約日の設定
	public void setReservationDay(String day) {
		reservationDay = day;
	}

	// 予約枚数の設定
	public void setReservationSheetsNo(int no) {
		reservationSheetsNumber = no;
	}

	/*public void setMember(String id) {
		memberid = id;
	}*/
	
	public void setMemberName(String name) {
		membername = name;
	}

	/*public void setTicketNo(int no) {
		ticketNo = no;
	}*/
	
	public void setTicketName(String name) {
		ticketName = name;
	}

	// 会員情報の取得
	public String getMemberName() {
		return membername;
	}

	// チケット情報の取得
	public String getTicketName() {
		return ticketName;
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
