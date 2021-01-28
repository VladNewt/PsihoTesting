package sandbox;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*Скрипт предназначен для работы с базой данных - создание таблиц, наполнения таблиц и т.д. (чтобы не мучаться с консолью)
Инструкция:
При запуске программы на консоле выйдет приглашение ввести номер команды:
1 - создать таблицу
	Введите название таблицы:
	Введите число столбцов
	Вводите название каждого столбца (первый столбец начинается со слова ID_ и далее название ключевого столбца, например ID_depart)
	После ввода каждого столбца будет предложено ввести его тип данных;
2 - вставить данные
	Введите название таблицы, затем вводите через Enter данные для каждого столбца
	
*/


public class DataBaseWork {
		private static final String url = "jdbc:mysql://127.0.0.1:3306/psihtest?useUnicode=true&serverTimezone=UTC";
		private static final String user = "vadik";
		private static final String password = "vadiknet";
		
		private static Connection con;
		public static Statement stm;
		
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in); 
		int action;
		
		try {
			con=DriverManager.getConnection(url,user,password);
			stm=con.createStatement();
			System.out.println("Подключение к базе данных выполнено");
		} catch (SQLException e) {
			System.out.println("Подключение к базе данных НЕ выполнено");
			e.printStackTrace();
		}
		
		System.out.println("Эта программа служит для упрощения работы с базой данных psihtest");
		System.out.println("Выберете действие:");
		System.out.println("1 - Создать таблицу");
		System.out.println("2 - Ввести данные в таблицу");
		action = in.nextInt();
		System.out.println(action);
		in.nextLine();
		//in.close();
		
		switch(action) {
			case 1:
				String nameTab;
				int numCol;
				
				System.out.print("Введите название таблицы: ");
				nameTab = in.nextLine();
				//System.out.println(nameTab+"2");
				System.out.print("Введите число столбцов: ");
				numCol = in.nextInt();
				//System.out.println("Число столбцов: "+numCol);
				in.nextLine();
				
				String[] nameCol = new String[numCol+1];
				for (int i = 0; i<numCol; i++) {
					System.out.print("Введите имя "+(i+1)+"-го столбца: ");
					nameCol[i]=in.nextLine();
					//System.out.println("Имя "+(i+1)+" - го столбца: " + nameCol[i]);
					//in.close();
				}
				
				//Ввод типа данных столбцов
				System.out.println("Введите один из предложенных типа данных столбца:");
				System.out.println("	INT(3)");
				System.out.println("	CHAR(66)");
				System.out.println("	DATE(66)");
				
				String[] dataType = new String[numCol+1];
				for (int i = 0; i<numCol; i++) {
					System.out.print("Введите тип данных "+(i+1)+"-го столбца: ");
					dataType[i]=in.nextLine();
					//System.out.println("Имя "+(i+1)+" - го столбца: " + nameCol[i]);
					//in.close();
				}
				
				
				
				in.close();
				
				
		}
		
		
	}

}

