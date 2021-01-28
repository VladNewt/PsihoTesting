package Frontend;

import java.awt.Color;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import CreateTestTwoAns.PanelCreate;


public class DesktopFrame extends JFrame{
	JScrollPane scrpane;
	PanelCreate qestPane;
	private boolean tabTest=true;
	private boolean tabEmpl=true;
	
	private int w = 0;
	private int h = 0;
	
	private Tables tab;
	
	
	public DesktopFrame() throws IOException {
		
		
		
		
		setTitle("PsihoTesting 2.01 - Психологическое тестирование сотрудников");
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
	    JMenu file = new JMenu("Файл");
	    JMenuItem aut = new JMenuItem("Авторизация");
	    JMenuItem reg = new JMenuItem("Регистрация");
	    file.add(aut);
	    file.add(reg);
	    
	    
	    JMenu view = new JMenu("Вид");
	    JMenuItem employers = new JMenuItem("Сотрудники");
	    JMenuItem statistic = new JMenuItem("Статистика");
	    view.add(employers);
	    view.add(statistic);
	    JMenu tests = new JMenu("Тесты");
	    tests.setEnabled(false);										//Блокировка нажатия без авторизации
	    tests.setForeground(Color.gray);
	    JMenuItem aizenk = new JMenuItem("Тест Айзенка"); 
	    tests.add(aizenk);
	    JMenuItem resAizenk = new JMenuItem("Результаты");
	    //resAizenk.setEnabled(false);
	    tests.add(resAizenk);
	    JMenuItem exitTest = new JMenuItem("Выйти из теста");
	    tests.add(exitTest);
	    JMenu settings = new JMenu("Настройки");
	    JMenuItem look = new JMenuItem("Оформление");
	    JMenuItem connDB = new JMenuItem("База данных");
	    settings.add(look);
	    settings.add(connDB);
	    JMenu about = new JMenu("О программе");
	    
	    
	    menu.add(file);
	    menu.add(view);
	    menu.add(tests);
	    menu.add(settings);
	    menu.add(about);
	    
	    setExtendedState(this.MAXIMIZED_BOTH); 
	    setVisible(true);
	    
	    w=this.getWidth();
	    h=this.getHeight();
	    
	    
	    
	    
	    
	    
	    aut.addActionListener(new
	    		ActionListener()
	      		{
	          		public void actionPerformed(ActionEvent event)
	          		{
	          			DialogMake dm = new DialogMake();
	          			dm.AutorizCreate(tests);
	          		}
	          	});
	    
	    reg.addActionListener(new
	    		ActionListener()
	      		{
	          		public void actionPerformed(ActionEvent event)
	          		{
	          			DialogMake dm = new DialogMake();
	          			try {
							dm.RegistrCreate();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	          		}
	          	});
	    
	    aizenk.addActionListener(new
	    		ActionListener()
	      		{
					public void actionPerformed(ActionEvent event)
	          		{
						if(scrpane!=null) {
							remove(scrpane);
							repaint();
							validate();
						}
		
						try {
							qestPane=new PanelCreate(w,h);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						add(qestPane);
						
						repaint();
						validate();
	          			
	          		}
	          	});
	    
	    
	    exitTest.addActionListener(new
	    		ActionListener()
  		{
			public void actionPerformed(ActionEvent event)
      		{
				if (qestPane!=null) {
					remove(qestPane);
					repaint();
					validate();
				}
      		}
      	});
	    
	    
	    
	    
	    employers.addActionListener(new
	    		ActionListener()
	      		{
					public void actionPerformed(ActionEvent event)
	          		{
						if(qestPane!=null) {
							remove(qestPane);
							repaint();
							validate();
						}
					
	          			if (scrpane==null) {
	          				tab = new CreateTableEmpl();
	          				TableFunc(tab);
	          			} else if ((scrpane!=null)&&(tab.getTypeObject()!=2)) {
	          				remove(scrpane);
	          				tab = new CreateTableEmpl();
	          				TableFunc(tab);
	          			}
	          			
	          		}
	          	});
	    
	    resAizenk.addActionListener(new
	    		ActionListener()
	      		{
	          		public void actionPerformed(ActionEvent event)
	          		{
	          			DialogMake dm = new DialogMake();
	          			dm.ResultView();
	          		}
	          	});
	    
	    
	}
	
	void TableFunc(Tables tbls) {
		tbls.CreateTable();
		scrpane = new JScrollPane(tbls.getTable());
		add(scrpane);
		repaint();
		validate();
	}

}
