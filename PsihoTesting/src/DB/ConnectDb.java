package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectDb {
	
	private static final String url = "jdbc:mysql://127.0.0.1:3306/psihtest?useUnicode=true&serverTimezone=UTC";
	private static final String user = "vadik";
	private static final String password = "vadiknet";
	
	private static Connection con;
	public static Statement stm;
	//public static ResultSet rs;
	
	public ConnectDb() {
		try {
			con=DriverManager.getConnection(url,user,password);
			stm=con.createStatement();
			System.out.println("Подключение к базе данных выполнено");
		} catch (SQLException e) {
		
		e.printStackTrace();
		}
	}
	
	public void addDepartment(String namedep) {
		String query = "INSERT INTO depart(dep) VALUES('"+namedep+"');";
		try {
			stm.execute(query);
			System.out.println("Подразделение успешно добавлено!!!");
		} catch (SQLException e) {
			System.out.println("Подразделение не добавлено!!!");
			e.printStackTrace();
		}
	}
	
	public void addPossition(String namepos) {
		String query = "INSERT INTO possitions(namepos) VALUES('"+namepos+"');";
		try {
			stm.execute(query);
			System.out.println("Должность добавлена");
		} catch (SQLException e) {
			System.out.println("Должность не добавлена");
			e.printStackTrace();
		}
	}
	
	public void returnColTable(String nameTab, String nameCol, ArrayList<String> result) {
		String query = "SELECT "+nameCol+" FROM "+nameTab+";";
		ResultSet rs;
		try {
			stm.executeQuery(query);
			rs=stm.executeQuery(query);
			while(rs.next()) {
				result.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeConnect() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
