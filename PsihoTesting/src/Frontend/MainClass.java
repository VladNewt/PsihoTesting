package Frontend;

import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

import DB.AizenkResult;
import DB.ConnectDb;
import DB.TestWriter;
import DB.TextFileDow;

public class MainClass {
	public static JFrame frame;
	/*
	public static void PrintResult() {
		AizenkResult result = new AizenkResult();
		System.out.println("Уровень экстраверсии: "+result.AizenkExtravers(result.massQuest));	//Макс: 15+9=24
		System.out.println("Уровень нейротизма: "+result.AizenkNeirotizm(result.massQuest));	//Макс: 24+0=24
		System.out.println("Уровень лжи: "+result.AizenkLee(result.massQuest));					//Макс 3+6=9
	}
	*/
	public static void main(String[] args) throws IOException {
		
		frame = new DesktopFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //frame.setExtendedState(frame.MAXIMIZED_BOTH); 
	    //frame.setVisible(true);
	     
	     
		
		/*
		TestWriter write = new TestWriter();
		TextFileDow vopr = new TextFileDow();
		
		System.out.println("Тестирование функции заполенения опросника");
		//Имитация ответа пользователя
		
		for(int i=0;i<=58;i++) {
			 if ((i+1)>vopr.massQuest.size()) {
  				System.out.println("Тестирование завершено");
  				write.WriteClose();
  				break;
			} else {
				write.WriteResult("0");
			}
		}
		
		
		//Обработка результата
		PrintResult();
		*/
		
	}

}
