package Frontend;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CreateTableEmpl implements Tables{
	private JTable table;
	private int i=2;
	
	public JTable getTable() {
		return this.table;
	}
	
	
	public int getTypeObject() {
		return this.i;
	}
	
	
	
	
	public void CreateTable() {
		//Загружаем всех сотрудников из базы данных
		//результаты присваиваем строковым переменным
		
		String[] colnames = {"№","Фамилия","Имя","Отчество","Дата рождения","Должность"};   //Этот массив будет формироваться автоматически в зав-ти от того,
																							//что выбрано для запроса
		Object[][] data = {{"1","Нижегородцев","Вадим","Вячеславович","26.02.1990","Разработчик"},{"2","Димитрова","Алена","Валерьевна","13.01.1989","Менеджер по кадрам"}};
		
		table = new JTable(data,colnames);
	}
	
	
	
	
	
	public void DeleteTable() {
		
	}
}
