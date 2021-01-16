package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnect {
	private static final String url = "jdbc:mysql://127.0.0.1:3306/psihtest?useUnicode=true&serverTimezone=UTC";
	private static final String user = "vadik";
	private static final String password = "vadiknet";
	
	private static Connection con;
	private static Statement stm;
	private static ResultSet rs;
	

	public static void main(String[] args) {
		String query = "select * from employers";
		
		try {
			con=DriverManager.getConnection(url,user,password);

			stm=con.createStatement();
			rs=stm.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getDate(5));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
