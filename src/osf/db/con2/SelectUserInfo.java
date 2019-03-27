package osf.db.con2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DBConnection {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "osfu";
	private static final String PASSWORD = "12345678";
	private static final String CLASS_NAME = "oracle.jdbc.OracleDriver";
	private static Connection con;
	
	public static Connection open() {

		if(con==null) {
			try {
				Class.forName(CLASS_NAME);
				con = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static void close() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		con = null;
	}
}

public class SelectUserInfo {
	
	public static void main(String[] args) {
		String sql = "select ui_num, ui_name, ui_age from User_Info";
		
		try {
			PreparedStatement ps = DBConnection.open().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("ui_num : " + rs.getString("ui_num"));
				System.out.println("ui_name : " + rs.getString("ui_name"));
				System.out.println("ui_age : " + rs.getString("ui_age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
