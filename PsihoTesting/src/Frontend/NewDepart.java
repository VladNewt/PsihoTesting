package Frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import DB.ConnectDb;

public class NewDepart implements MainDialog {
	
	public void Create() {
		//Параметры окошка
		int[] wndPar = {120,120,280,200};
		
		//Параметры подписи
		int[] labPar = {35,20,200,20};
		
		//Параметры текстового поля
		int[]tfPar = {30,55,200,25};
		
		//Параметры кнопки
		int[] btnPar = {80,100,70,30};
		
		DialogUnivers dlg = new DialogUnivers();
		dlg.setBounds(wndPar[0],wndPar[1],wndPar[2],wndPar[3]);
		JLabel annot = new JLabel("Введите новое подразделение");
		Font annotfont = new Font("Arial",1,12); 
		annot.setFont(annotfont);
		annot.setBounds(labPar[0],labPar[1],labPar[2],labPar[3]);
		JTextField tf = new JTextField();
		tf.setBounds(tfPar[0],tfPar[1],tfPar[2],tfPar[3]);
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(btnPar[0],btnPar[1],btnPar[2],btnPar[3]);
		
	
		dlg.add(annot);
		dlg.add(tf);
		dlg.add(btnOk);
		
		dlg.setVisible(true);
		
		
		//Обработчик события кнопки ОК
		btnOk.addActionListener( new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				ConnectDb conn = new ConnectDb();
				conn.addDepartment(tf.getText());
				conn.closeConnect();
			}
		});
	}
}
 