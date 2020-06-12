package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Member;

public class MemberList {
	private static final String URL = "jdbc:mysql://localhost/shock_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "masterkey";
	
	//会員追加
	public void addMemberList(String id, String pass, String name) {
		String sql = "INSERT INTO memberlist VALUES ('" + id + "','" + pass + "', '" + name + "');";
		try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql)){
			ps.executeUpdate(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//会員情報の取得
	public Member getMember(String id) {
		Member member = new Member();
		String sql = "SELECT * FROM memberlist WHERE id = '" + id + "';";
		
		try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement ps = connection.prepareStatement(sql)){
			
			try(ResultSet rs = ps.executeQuery()){
					rs.next();
					member.setID(rs.getString(1));
					member.setPass(rs.getString(2));
					member.setMemberName(rs.getString(3));
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}
}
