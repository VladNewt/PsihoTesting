package Frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import DB.ConnectDb;

public class Registration implements MainDialog{
	
	private int dilog_width=550;
	private int dilog_heigth=700;
	private int location_width = 400;
	private int location_heigth = 200;
	private int lab_length=170;
	private int lab_heigth=15;
	private int lab_TF_dist=30;
	private int nul_pointX = 20;
	private int nul_pointY = 20;
	private int tf_length=200;
	private int tf_heigth=20;
	private int btnlit_length=80;
	private int btnlit_heigth=20;
	private int btnbig_length=200;
	private int btnbig_heigth=30;
	
	private boolean[] checkfrm = new boolean[11];
	boolean registcntr=true;
	
	
	private ArrayList<String> droplist=new ArrayList<String>();
	private String[] un_menu = {"Администрация", "Разработка"};  //Значения заданы для отладки в рабочей версии они будут загружаться из БД
	private String[] poss_menu = {"Фин.директор", "Программист", "АрхитекторПО"};
	private String[] namelabels = {"Фамилия:","Имя:","Отчество:","Дата рождения:","Подразделение:",
			"Должность:","Семейное положение:", "Хобби:","Логин:","Пароль:","Подтв. пароль:"};
	private String checktrue = "Подтверждаю, что данные введены верно";
	private String personaldata = "<html>Я даю согласие на обработку персональных данных, "
			+"включая сбор, систематизацию, накопление, хранение, уточнение(обновление,изменения), "
					+ "использование, обезличивание, блокирование, уничтожение персональных данных.</html>";
	private String badpassw = "Пароль и подтверждение пароля не совпадают!";
	private String loginrepeat = "Пользователь с таким логином уже зарегистрирован!";
	private String baddata = "Проверьте правильность введенных данных!";
	
	
	private Font font_label=new Font("TimesNewRoman",Font.PLAIN,14);
	
	private JLabel attent;
	
	private void dropList(String tablName, String colName, ArrayList<String> res) {
		ConnectDb connList = new ConnectDb();
		connList.returnColTable(tablName, colName, res);
		connList.closeConnect();
	}
	
	public void Create() throws ParseException {
		
		
		DialogUnivers dlg = new DialogUnivers();
		
		dlg.setLocation(location_width, location_heigth);
		dlg.setSize(dilog_width,dilog_heigth);
		dlg.setTitle("Регистрация сотрудника");
		dlg.setResizable(false);
		
		JLabel[] labels = new JLabel[12];
		JTextField[] tf = new JTextField[12];
		
		//Строка предупреждения
		attent = new JLabel();
		attent.setBounds(nul_pointX,  dilog_heigth-200, 450, 100);
		attent.setForeground(Color.RED);
		
		for (int i=0;i<=10;i++) {
			labels[i]=new JLabel(namelabels[i]);
			tf[i]=new JTextField();
			LabelSet(labels[i],nul_pointX,nul_pointY+lab_heigth+i*lab_TF_dist,dlg);
			if ((i!=3)&&(i!=4)&&(i!=5)&&(i!=9)&&(i!=10)) {
				
				TextFieldSet(tf[i],nul_pointX+lab_length+5,nul_pointY+lab_heigth+i*lab_TF_dist,dlg);
			}
		}
		
		//Поле ввода даты рождения
		MaskFormatter mf = new MaskFormatter("##.##.####");
		mf.setPlaceholderCharacter('_');
		JFormattedTextField ftf= new JFormattedTextField(mf);
		ftf.setBounds(nul_pointX+lab_length+5, nul_pointY+lab_heigth+3*lab_TF_dist, 90,tf_heigth);
		ftf.setFont(font_label);
		dlg.add(ftf);
	
		//Выпадающий список подразделений
		dropList("depart","dep",droplist);
		
		JComboBox tfcombo = new JComboBox(droplist.toArray());
		tfcombo.setBounds(nul_pointX+lab_length+5, nul_pointY+lab_heigth+4*lab_TF_dist, tf_length,tf_heigth);
		dlg.add(tfcombo);
		droplist.clear();
		
		//Выбор должности из выпадающего списка
		dropList("possitions","namepos",droplist);
		JComboBox possit = new JComboBox(droplist.toArray());
		possit.setBounds(nul_pointX+lab_length+5, nul_pointY+lab_heigth+5*lab_TF_dist, tf_length,tf_heigth);
		dlg.add(possit);
		droplist.clear();
		
		
		//Поле ввода пароля и подтверждения пароля
		JPasswordField passw = new JPasswordField();
		passw.setBounds(nul_pointX+lab_length+5, nul_pointY+lab_heigth+9*lab_TF_dist, tf_length,tf_heigth);
		dlg.add(passw);
		JPasswordField confpassw = new JPasswordField();
		confpassw.setBounds(nul_pointX+lab_length+5, nul_pointY+lab_heigth+10*lab_TF_dist, tf_length,tf_heigth);
		dlg.add(confpassw);
		
		//Создаем кнопки ввода новых подразделений и должностей
		JButton newunit = new JButton("Новое...");
		JButton newpossit = new JButton("Новое...");
		newunit.setBounds(nul_pointX+lab_length+tf_length+8,nul_pointY+lab_heigth+4*lab_TF_dist,btnlit_length,btnlit_heigth);
		newpossit.setBounds(nul_pointX+lab_length+tf_length+8,nul_pointY+lab_heigth+5*lab_TF_dist,btnlit_length,btnlit_heigth);
		dlg.add(newunit);
		dlg.add(newpossit);
		
		JCheckBox[] check = new JCheckBox[3];
		check[0]=new JCheckBox(checktrue);
		check[1]=new JCheckBox(personaldata);
		check[0].setBounds(nul_pointX, nul_pointY+lab_heigth+10*lab_TF_dist+40, 450, 20);
		check[1].setBounds(nul_pointX,  nul_pointY+lab_heigth+10*lab_TF_dist+60, 450, 100);
		check[1].setVerticalTextPosition(JCheckBox.TOP);
		
		dlg.add(check[0]);
		dlg.add(check[1]);
		
		JButton regist = new JButton("Регистрация");
		regist.setBounds((dilog_width-btnbig_length)/2, dilog_heigth-100, btnbig_length, btnbig_heigth);
		regist.setFont(font_label);
		dlg.add(regist);
		
		//ЗАПОЛНЯЕМ ФОРМУ ДЛЯ ОТЛАДКИ
		tf[0].setText("Нижегородцев");
		tf[1].setText("Вадим");
		tf[2].setText("Вячеславович");
		ftf.setText("26.02.1990");
		tf[6].setText("женат");
		tf[7].setText("спорт,музыка");
		tf[8].setText("vadiknet");
		passw.setText("12345");
		confpassw.setText("12345");
				
		
		
		dlg.setVisible(true);
		
		
		
		
		
		for (int i=0; i<3;i++) {
			FocusTransf(tf[i],tf[i+1]);
		}
		
		tf[2].addKeyListener(new KeyAdapter() { 
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					ftf.requestFocusInWindow();
				}
			}
		});
		
		ftf.addKeyListener(new KeyAdapter() { 
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					tfcombo.requestFocusInWindow();
				}
			}
		});
		
		tfcombo.addKeyListener(new KeyAdapter() { //Не работает событие
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					possit.requestFocusInWindow();
				}
			}
		});
		
		possit.addKeyListener(new KeyAdapter() { //Не работает событие
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					tf[6].requestFocusInWindow();
				}
			}
		});
		
		for (int i=6; i<=8;i++) {
			FocusTransf(tf[i],tf[i+1]);
		}
		
		
		tf[8].addKeyListener(new KeyAdapter() { 
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					passw.requestFocusInWindow();
				}
			}
		});
		
		
		passw.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					confpassw.requestFocusInWindow();
				}
			}
		});
		
		
		//Событие для создания нового подразделения
		newunit.addActionListener( new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				DialogMake dm = new DialogMake();
				dm.NewDepart();
			}
		});
		
		//Событие для создания новой должности
		newpossit.addActionListener( new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				DialogMake dm = new DialogMake();
				dm.NewPossitions();
			}
		});
		
	
		
		//Нажатие на кнопке регистрация
		regist.addActionListener( new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				
				
				for (int i=0; i<3;i++) {
					Drop(labels[i],dlg);
				}
				for (int i=6; i<9;i++) {
					Drop(labels[i],dlg);
				}
				
				//Проверка данных
				registcntr=true;
				checkfrm[0]=CheckPassw(passw,confpassw,dlg);
			
				checkfrm[1]=CheckPassw(passw,confpassw,dlg);
				
				for (int i=0; i<3;i++) {
					checkfrm[2+i]=CheckFormNull(tf[i],dlg,labels[i]);
				}
				
				for (int i=6; i<9;i++) {
					checkfrm[i-1]=CheckFormNull(tf[i],dlg,labels[i]);
				}
				checkfrm[8]=CheckFormNullFormatted(ftf,dlg,labels[3]);
				
				if(!(check[0].isSelected())) {
					attent.setText("Подтвердите правильность заполнения формы");
					dlg.add(attent);
					checkfrm[9]=false;
				} else {
					checkfrm[9]=true;
				}
				if(!(check[1].isSelected())) {
					attent.setText("Подтвердите согласие на обработку персональных данных");
					dlg.add(attent);
					checkfrm[10]=false;
				} else {
					checkfrm[10]=true;
				}
				
				for(int i=0;i<=10;i++) {
					if (checkfrm[i]==false) {
						registcntr=false;
						break;
					}
				}
				
				
				//Сохранение данных в БД
				if (registcntr)
				{
					System.out.println("Ваши данные сохранены");
				}
				
				
			}
		});
		
	}
	
	
	
	private void LabelSet(JLabel lab, int b_width, int b_heigth, DialogUnivers dlgv) {
		lab.setBounds(b_width, b_heigth, lab_length, lab_heigth);
		lab.setFont(font_label);
		dlgv.add(lab);
	}
	
	private void TextFieldSet(JTextField box, int x, int y,DialogUnivers dlgv) {
		box.setBounds(x,y,tf_length,tf_heigth);
		box.setFont(font_label);
		dlgv.add(box);
	}
	
	private void FocusTransf(JTextField tf_ish, JTextField tf_end) {
		tf_ish.addKeyListener(new KeyAdapter() { //Не работает событие
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					tf_end.requestFocusInWindow();
				}
			}
		});
	}
	
	//Проверка формы на отс.нулевых значений
	private boolean CheckFormNull(JTextField checktf, DialogUnivers dlgv,JLabel lbl) {
		if (checktf.getText().length()<2) {
			lbl.setForeground(Color.RED);
			attent.setText(baddata);
			dlgv.add(attent);
			dlgv.repaint();
			return false;
		}
		return true;
	}
	
	private boolean CheckFormNullFormatted(JFormattedTextField checktf, DialogUnivers dlgv,JLabel lbl) { //Доработать!! Отдельно
		if (checktf.getText().length()<2) {
			lbl.setForeground(Color.RED);
			attent.setText(baddata);
			dlgv.add(attent);
			dlgv.repaint();
			return false;
		}
		return true;
	}
	
	//Проверка совпадения пароля
	private boolean CheckPassw(JPasswordField pas, JPasswordField cofps, DialogUnivers dlgv) {
		if((pas.getText()).equals(cofps.getText())&&(pas.getText().length()>2)) {
			//dlgv.remove(attent);
			return true;
		} else {
			attent.setText(badpassw);
			dlgv.add(attent);
			return false;
		}
	}
	
	//Сброс до исходного оформления
	private void Drop(JLabel lbl,JDialog dlgv) {
		lbl.setForeground(Color.black);
		attent.setText("");
		dlgv.add(attent);
	}

}
