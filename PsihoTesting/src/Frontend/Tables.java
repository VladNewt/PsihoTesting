package Frontend;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public interface Tables {
	public JTable getTable();
	public int getTypeObject();
	
	public void CreateTable();
	public void DeleteTable();
}
