package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberList_db {
	private static final String URL = "jdbc:mysql://localhost/shock_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "masterkey";
	
	
	public void addMemberList(String id, String pass, String name) {
		String sql = "INSERT INTO memberlist VALUES ('" + id + "','" + pass + "', '" + name + "');";
		try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql)){
				
			int rs = ps.executeUpdate(sql);
			System.out.println("結果1:" + rs);
					
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public Member_db getMember(String id) {
		Member_db member = new Member_db();
		String sql = "SELECT * FROM memberlist;";
		
		try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement ps = connection.prepareStatement(sql)){
			
			try(ResultSet rs = ps.executeQuery()){
				
				while(rs.next()) {
					if(rs.getString(1).equals(id)) {
						member.setID(rs.getString(1));
						member.setPass(rs.getString(2));
						member.setMemberName(rs.getString(3));
						break;
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}
}
