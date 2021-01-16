package Frontend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class CreateTableTest implements Tables {	//Ввести паттерн одиночка
	private JTable table;
	private int i=1;
	
	public JTable getTable() {
		return this.table;
	}
	
	
	public int getTypeObject() {
		return this.i;
	}
	
	
	public void CreateTable() {
		FileReader reader;
		try {
			reader = new FileReader("Opros2.txt");
		} catch (FileNotFoundException e) {
			reader = null;
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(reader);
		int k=0;
		String[] str = new String[100];
		String s;
		Object[][] data=new Object[57][4];
    
		try {
			while ((s=br.readLine())!=null) {
				str[k]=s;
				k++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    
		String[] colnames = {"№","Вопрос","Ответ"};
    
		for (int i=0;i<k;i++) {
			data[i][0] = i+1;
			data[i][1] = str[i];	    	
			data[i][2] = Boolean.FALSE;
		}
   /*
    DefaultTableModel tModel=new DefaultTableModel();
    tModel.addColumn("№");
    tModel.addColumn("Вопрос");
    tModel.addColumn("Ответ");
    tModel.addRow(new Object[] {"1","Нравится ли вам оживление и суета вокруг вас?",new JCheckBox()});
    */
    
    
		table = new JTable(data,colnames);
    
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    
    
		TableColumn[] column = new TableColumn[5];
		column[0] = table.getColumnModel().getColumn(0);
		column[1] = table.getColumnModel().getColumn(1);
		column[2] = table.getColumnModel().getColumn(2);
    
		column[0].setPreferredWidth(20);
		column[1].setPreferredWidth(800);
		column[2].setPreferredWidth(70);
    
    
		column[2].setCellRenderer(table.getDefaultRenderer(Boolean.class));
		column[2].setCellEditor(table.getDefaultEditor(Boolean.class));
    
    
    
		//Балуемся с получением значения ответа
		/*
    	boolean nh = (boolean) table.getValueAt(0, 2);
    	if (nh) {
    		System.out.println("Ответ Да");
    	}
		 */
	}
	
	
	
	public void DeleteTable() {
		
	}
}
