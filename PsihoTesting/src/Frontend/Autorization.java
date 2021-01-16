package Frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.*;

public class Autorization {
	
	private int dilog_width=300;
	private int dilog_heigth=250;
	private int location_width = 400;
	private int location_heigth = 200;
	
	public boolean createok = false;
	
	public void Create(JMenu menu) {
		DialogUnivers dlg = new DialogUnivers();
		
		dlg.setLocation(location_width, location_heigth);
		dlg.setSize(dilog_width,dilog_heigth);
		dlg.setTitle("Авторизация");
		dlg.setResizable(false);
		
		JLabel LB1 = new JLabel("Логин:");
		Font fnt = new Font("Arial",Font.BOLD,20);
		LB1.setBounds((dilog_width-80)/2,dilog_heigth-(dilog_heigth-10),65,20);
		LB1.setFont(fnt);
		dlg.add(LB1);
		
		JTextField TF1 = new JTextField();
		TF1.setBounds((dilog_width-250)/2,dilog_heigth-(dilog_heigth-35),250,25);
		dlg.add(TF1);
		
		JLabel LB2 = new JLabel("Пароль:");
		LB2.setBounds((dilog_width-90)/2,dilog_heigth-(dilog_heigth-65),90,20);
		LB2.setFont(fnt);
		dlg.add(LB2);
		
		JPasswordField TF2 = new JPasswordField();
		TF2.setBounds((dilog_width-250)/2,dilog_heigth-(dilog_heigth-90),250,25);
		dlg.add(TF2);
		
		JButton enter = new JButton("Войти");
		enter.setBounds((dilog_width-80)/2,dilog_heigth-(dilog_heigth-140),80,25);
		dlg.add(enter);
		
		dlg.setVisible(true);
		
		enter.addActionListener( new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				//Проверка логина и пароля (для отладки)
				if ((TF1.getText().equals("admin"))&&(TF2.getText().equals("admin"))) {
					System.out.println("Вы авторизованы в базе данных");
					menu.setEnabled(true);
					menu.setForeground(Color.black);
					dlg.dispose();
					
					//Подключение к базе данных
					
				}
			}
		});
	}
}
