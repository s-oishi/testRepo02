package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBtemplate {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		static final String URL = "jdbc:mysql://localhost/db";
		static final String USERNAME = "root";
		static final String PASSWORD = "masterkey";

		public static void main(String[] args) {
			// TODO 自動生成されたメソッド・スタブ
			
			try(
					Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					Statement state = connection.createStatement();
					){
				
				String sql;
				int result;//情報追加時の行数
				ResultSet message;//情報取得時の情報
				
				
				/*sql = "INSERT INTO テーブル名 VALUES (データの中身)";
				result = state.executeUpdate(sql);
				System.out.println("結果1:" + result);
				*/
				
				/*sql = "SELECT * FROM reservationlist;";
				message = state.executeQuery(sql);
				message.next();//次の行に移動
				System.out.print("結果3:" + message.getString(1));　//列を数字またはカラム名で指定
				System.out.print(",");
				System.out.print(message.getString(2));
				System.out.print(",");
				System.out.print(message.getString(3));
				System.out.print(",");
				System.out.print(message.getString(4));
				System.out.print(",");
				System.out.print(message.getString(5));
				*/
				
			}catch(SQLException e) {
				e.printStackTrace();
			}

		}


	}

}
