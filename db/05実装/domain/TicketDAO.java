package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDAO {
	// DB
	private static final String URL = "jdbc:mysql://localhost/shock_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "masterkey";
	private static final String SQL = "select * from ticketlist;";
	private static final String count_SQL = "select count(ticketnumber) from ticketlist;";
	private int ticketSize = 0;

	public TicketDAO() {

	}

	/*
	 * public void addTicketList(int no, Ticket t) { ticket.put(no, t); }
	 */

	public Ticket[] getTicketInfo() {
		Ticket[] allTickets = new Ticket[ticketSize];
		int n = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(SQL)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Ticket ticket = new Ticket(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
							rs.getInt(5));
					allTickets[n] = ticket;
					n++;
				}
				// return allTickets;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return allTickets;
	}

	public int getTicketTypeNo() {
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(count_SQL)) {
			try (ResultSet rs = ps.executeQuery()) {
				rs.next();
				this.ticketSize = rs.getInt(1);
				//System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return ticketSize;
	}

	/*
	 * public int getTicketTypeNo() { int size = ticket.size(); return size; }
	 */

	/*
	 * public Ticket[] getTicketInfo() { Ticket[] allTickets = new
	 * Ticket[ticket.size()]; Iterator<Ticket> it = ticket.values().iterator(); int
	 * n = 0; while (it.hasNext()) { allTickets[n] = it.next(); n++; } return
	 * allTickets; }
	 */
}
