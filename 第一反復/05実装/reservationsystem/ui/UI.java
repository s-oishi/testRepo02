package ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import domain.Member;
import domain.Reservation;
import domain.Ticket;

public class UI {
	private String inputID;
	private String inputPass;

	public String userLoginID() {
		System.out.println("ユーザーIDを入力してください。");
		System.out.print("ID:");
		this.inputID = readLine();
		return inputID;
	}

	public String userLoginPass() {
		System.out.println("パスワードを入力してください。");
		System.out.print("PASSWORD:");
		this.inputPass = readLine();
		return inputPass;
	}

	public int selectSystem() {
		String line;
		System.out.println("利用サービスを入力してください。");
		System.out.println("1:チケット情報閲覧・予約");
		System.out.println("2:予約チケット確認・キャンセル");
		System.out.print("サービス番号:");
		line = readLine();
		int systemNumber = Integer.parseInt(line);
		while(systemNumber != 1 && systemNumber != 2) {
			System.out.println("1または2を入力してください");
			System.out.print("サービス番号:");
			line = readLine();
			systemNumber = Integer.parseInt(line);
		}
		return systemNumber;
	}

	public int inputTicketNo() {
		String line;
		System.out.println("予約を行うチケット番号を入力してください。");
		System.out.println("メニューに戻る場合は0を入力してください。");
		System.out.print("番号:");
		line = readLine();
		int systemNumber = Integer.parseInt(line);
		return systemNumber;
	}

	public int inputSheetsNumber() {
		String line;
		System.out.println("希望枚数を入力してください。");
		System.out.print("希望枚数:");
		line = readLine();
		int systemNumber = Integer.parseInt(line);
		return systemNumber;
	}

	public int inputReservation() {
		String line;
		System.out.println("キャンセルをするチケット番号を入力してください。");
		System.out.println("メニューに戻る場合は0を入力してください。");
		System.out.print("番号:");
		line = readLine();
		int systemNumber = Integer.parseInt(line);
		return systemNumber;
	}

	public boolean checkCancel() {
		String line;
		System.out.println("本当にキャンセルしてもよろしいですか？");
		System.out.println("1：はい。");
		System.out.println("2:いいえ。");
		System.out.print("番号:");
		line = readLine();
		int systemNumber = Integer.parseInt(line);
		if(systemNumber == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public int showNotingTicket() {
		String line;
		System.out.println("表示できるチケットが1件もありません");
		System.out.println("メニューに戻る");
		System.out.print("何か入力してください:");
		line = readLine();
		while(line == null) {
			line = readLine();
		}
		return 1;
	}
	
	public void showAllTicketInfo(Ticket[] ticketInfo) {
		System.out.println("チケット確認・予約");
		for(Ticket tickets : ticketInfo) {
			System.out.print(tickets.getTicketNumber()+",");
			System.out.print(tickets.getTicketName()+",");
			System.out.print(tickets.getPrice()+",");
			System.out.print(tickets.getDay()+",");
			System.out.print(tickets.getStock());
			System.out.println("");
		}
	}

	public void showAllReserveInfo(List<Reservation> ReservationInfo) {
		System.out.println("予約チケット確認・キャンセル");
		if( ReservationInfo == null ||  ReservationInfo.size() == 0) {
			System.out.println("予約していません");
		}else {
			for(Reservation reserveTickets : ReservationInfo) {
				if(reserveTickets != null) {
					System.out.print(reserveTickets.getReserveNumber()+",");
					Member memberName = reserveTickets.searchMember();
					System.out.print(memberName.getMemberName()+",");
					Ticket ticketName = reserveTickets.searchTicket();
					System.out.print(ticketName.getTicketName()+",");
					System.out.print(reserveTickets.getReserveDay()+",");
					System.out.print(reserveTickets.getSheetsNo());
					System.out.println("");
				} 
			}
		}
	}
	
	public int reserveEnd() {
		String line;
		System.out.println("予約が完了しました。");
		System.out.println("メニューに戻る");
		System.out.print("0を入力してください:");
		line = readLine();
		while(line == null) {
			line = readLine();
		}
		return 1;
	}
	
	public int cancelEnd() {
		String line;
		System.out.println("キャンセルが完了しました。");
		System.out.println("メニューに戻る");
		System.out.print("0を入力してください:");
		line = readLine();
		while(line == null) {
			line = readLine();
		}
		return 1;
	}
	
	private String readLine(){
		String line = "";
		try {
			BufferedReader reader 
			 = new BufferedReader(new InputStreamReader(System.in));
			line = reader.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return line;
	}
}
