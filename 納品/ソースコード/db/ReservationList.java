package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import domain.Member;
import domain.Reservation;
import domain.Ticket;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ReservationList {
	private static final String URL = "jdbc:mysql://localhost/shock_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "masterkey";

	// private Map<Integer, Reservation> reservationList = new HashMap<Integer,
	// Reservation>();
	private int reservationNo = 0;

	public ReservationList() {
	}

	public void reserve(Ticket ticket, Member member, int sheetsNo) {
		
		String sql = "select count(reservationnumber) from reservationlist;";
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				rs.next();
				this.reservationNo = rs.getInt(1);
				//System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		
		reservationNo += 1;
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("GGGGy- M- d");
		String reservationday = sdf.format(d);
		String id = member.getID();
		String name = member.getMemberName();
		int no = ticket.getTicketNumber();
		String tname = ticket.getTicketName();
		
		//予約の作成
		sql = "INSERT INTO reservationlist VALUES (" + reservationNo + ",'" + reservationday + "', "
				+ sheetsNo + ", '" + id + "', '" + name + "', " + no
				+ ",'" + tname + "');";
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql)) {
			
			ps.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//在庫の修正
		String stock = "UPDATE ticketlist SET stock = (stock - " + sheetsNo + " ) WHERE ticketnumber = " + no
				+ ";";
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(stock)) {

				ps.executeUpdate(stock);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 予約の削除
	public void removeReservationNo(int reservationNo) {
		int ticketNo = 0;
		int sheetsNo = 0;

		// チケット情報の取得
		String sql = "SELECT reservationsheetsnumber, ticketnumber FROM reservationlist WHERE reservationnumber="
				+ reservationNo + ";";
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery(sql)) {
				rs.next();
				sheetsNo = rs.getInt(1);
				ticketNo = rs.getInt(2);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 在庫書き換え
		String stock = "UPDATE ticketlist SET stock = (stock + " + sheetsNo + " ) WHERE ticketnumber = " + ticketNo
				+ ";";
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(stock)) {

				ps.executeUpdate(stock);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//予約の削除
		String delete = "DELETE FROM reservationlist WHERE reservationnumber = " + reservationNo + ";";
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(delete)) {
			ps.executeUpdate(delete);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	// 予約情報のまとめ
	public List<Reservation> getReserveInfo(String id) {
		List<Reservation> mamberReservationList = new ArrayList<Reservation>();
		String sql = "SELECT * FROM reservationlist WHERE id = '" + id + "';";

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery(sql)) {
				while (rs.next()) {
					Reservation reservation = new Reservation();
					reservation.setReservationNo(rs.getInt(1));
					reservation.setReservationDay(rs.getString(2));
					reservation.setReservationSheetsNo(rs.getInt(3));
					reservation.setMemberName(rs.getString(5));
					reservation.setTicketName(rs.getString(7));
					mamberReservationList.add(reservation);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mamberReservationList;
	}
}
