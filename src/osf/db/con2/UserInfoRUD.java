package osf.db.con2;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInfoRUD {

	public static void insertUser(int num, String name, int age) {
		String sql = "insert into User_Info(ui_num, ui_name, ui_age)";
		sql += " values(?,?,?)";
		
		try {
			PreparedStatement ps = DBConnection.open().prepareStatement(sql);
			ps.setInt(1, num);
			ps.setString(2, name);
			ps.setInt(3, age);
			int cnt = ps.executeUpdate();
			String result = "등록 실패";
			if(cnt==1) {
				result = "등록 성공";
			}
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateUser(String name,int age,int num) {
		String sql = "update User_Info set ui_name=?, ui_age=? where ui_num=?";
		try {
			PreparedStatement ps = DBConnection.open().prepareStatement(sql);
			ps.setString(1,name);
			ps.setInt(2, age);
			ps.setInt(3, num);
			int cnt = ps.executeUpdate();
			String result = "수정 실패";
			if(cnt==1) {
				result = "수정 성공";
			}
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void deleteUser(int num) {
		String sql = "delete from User_Info where ui_num=?";
		try {
			PreparedStatement ps = DBConnection.open().prepareStatement(sql);
			ps.setInt(1,num);
			int cnt = ps.executeUpdate();
			String result = "삭제 실패"; 
			if(cnt==1){
				result = "삭제 성공";
			}
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
			
	public static void main(String[] args) {
		insertUser(4,"홍길동4",44);
		updateUser("동동동",22,4);
		deleteUser(4);
	}
}
