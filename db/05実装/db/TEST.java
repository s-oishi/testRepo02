package db;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import domain.Member;
import domain.Reservation;
import domain.Ticket;
import management.ShowTicketSystem;

public class TEST {
	
	
	//予約
	
	

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		MemberList ml = new MemberList();
		//ml.addMemberList("pqr", "678", "秀田雪音");
		Member dto = ml.getMember("pqr");
		
		System.out.println(dto.getID());
		System.out.println(dto.getPass());
		System.out.println(dto.getMemberName());
		
		ReservationList rl = new ReservationList();
		
		TicketList tl = new TicketList();
		//tl.addTicketList(5, "クレスコ", 10000, "2020-10-10", 10);
		ShowTicketSystem sts = new ShowTicketSystem(tl, rl);
		
		System.out.println("チケット数:" + sts.searchTicketInfoNo());
		
		Ticket[] tickets = sts.getAllTicketInfo();
		for(Ticket a:tickets) {
			System.out.println(a.getTicketName());
			System.out.println(a.getStock());
		}
		System.out.println("");
		
		Ticket t = new Ticket(4, "オージス総研", 10000, "2020-12-12", 10);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("GGGGy- M- d");
		String reservationday = sdf.format(d);
		String id = dto.getID();
		String name = dto.getMemberName();
		int no = t.getTicketNumber();
		String tname = t.getTicketName();
		System.out.println(reservationday);
		System.out.println(id);
		System.out.println(name);
		System.out.println(no);
		System.out.println(tname);
		
		
		System.out.println("");
		rl.reserve(t, dto, 3);
		List<Reservation> list = rl.getReserveInfo("pqr");
		for(Reservation r:list) {
			System.out.println(r.getMemberName());
			System.out.println(r.getReserveDay());
		}
		
		System.out.println("");
		tickets = sts.getAllTicketInfo();
		for(Ticket a:tickets) {
			System.out.println(a.getTicketName());
			System.out.println(a.getStock());
		}
		
		System.out.println("");
		rl.removeReservationNo(1);
		list = rl.getReserveInfo("pqr");
		for(Reservation r:list) {
			System.out.println(r.getMemberName());
			System.out.println(r.getReserveDay());
		}
		
	}

}
