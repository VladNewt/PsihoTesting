package CreateTestTwoAns;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DB.AizenkResult;
import DB.TestWriter;
import DB.TextFileDow;
import Frontend.DialogMake;

public class PanelCreate extends JPanel{
	private int Height = 0;
	private int Width = 0;
	private int numClicAnsver = 0;
	
	private TestWriter write = new TestWriter();
	private TextFileDow vopr = new TextFileDow();
	
	public String nameEmpl = "Нижегородцев Вадим Вячеславович";
	public String nameTest = "тест Айзенка";
	public String questTest = "Нравиться ли Вам оживление и суета вокруг Вас?";
	public int numValQuest = 0;
	
	
	public void getWindowSize(int Width, int Height) {
		this.Width=Width;
		this.Height=Height;
	}
	
	
	private Color setColor(int R, int G, int B) {
		Color myColor = new Color(R,G,B);
		return myColor;
	}
	
	
	private int WidthText(Font font, String str) {
		FontMetrics fm = getFontMetrics(font);
		return fm.stringWidth(str);
	}
	
	private int HeightText(Font font) {
		FontMetrics fm = getFontMetrics(font);
		return fm.getHeight();
	}
	
	public void PrintResult() {
		AizenkResult result = new AizenkResult();
		System.out.println("Уровень экстраверсии: "+result.AizenkExtravers(result.massQuest));
		System.out.println("Уровень нейротизма: "+result.AizenkNeirotizm(result.massQuest));
		System.out.println("Уровень лжи: "+result.AizenkLee(result.massQuest));
	}
	
	public PanelCreate(int w, int h) throws IOException {
		//ЗАДАЕМ ПЕРЕМЕННЫЕ ДЛЯ РАЗМЕЩЕНИЯ ЭЛЕМЕНТОВ ПАНЕЛИ
		
		//Размеры родительского окна
		getWindowSize(w,h);
		
		//Задаем поля(пиксели):
		int left = 10;
		int right = 10;
		int top = 10;
		int bottom = 10;
		int poprWString = 400;	//Добавка на ширину строки вопроса
		
		//Задаем базовый тип и размер шрифта
		String fontType = "TimesNewRoman";
		int fontSize = 12;  //Самый мелкий шрифт
		int poprFontQues=10;	//Добавка на размер шрифта для вопросов
		
		
		
		//Базовый размер кнопки
		int hBtn = 20;
		int wBtn = 40;
		
		int dist = 200;					//Расстояние между кнопками
		
		
		
		//Получаем размеры панели
		setBackground(setColor(30,144,255));
		setLayout(null);
		
		
		//Загружаем вопросы из текстового файла
		numValQuest=vopr.massQuest.size()-1;
		
		
		
		
		JLabel name = new JLabel(nameEmpl+", "+nameTest);
		//Font smallText= new Font(fontType,1,fontSize);
		FontMetrics fm = getFontMetrics(new Font(fontType,1,fontSize));
		name.setFont(new Font(fontType,1,fontSize));
		name.setBounds(left,top,fm.stringWidth(nameEmpl+","+nameTest)+20,fm.getHeight());
		add(name);
		
		//(Width-left-right)/2-WidthText(new Font(fontType,1,fontSize+5),"Вопрос №1")/2
		
		JLabel numQuestion = new JLabel("Вопрос №1");
		numQuestion.setFont(new Font(fontType,1,fontSize+5));
		numQuestion.setBounds((Width-left-right)/2-WidthText(new Font(fontType,1,fontSize+5),"Вопрос №1")/2,(Height-top-bottom)/4+top,
				WidthText(new Font(fontType,1,fontSize+5),"Вопрос №1"),HeightText(new Font(fontType,1,fontSize+5)));
		
		//add(numQuestion);
		
		
		JLabel question = new JLabel(questTest);
		question.setFont(new Font(fontType,1,fontSize+poprFontQues));
		question.setBounds((Width-left-right-50)/2-WidthText(new Font(fontType,1,fontSize+poprFontQues),questTest)/2,(int)((Height-top-bottom)*0.32)+top,
				WidthText(new Font(fontType,1,fontSize+poprFontQues),questTest)+poprWString,HeightText(new Font(fontType,1,fontSize+poprFontQues)));
		
		
		
		
		
		
		
		JButton yes = new JButton("Да");
		yes.setFont(new Font(fontType,1,fontSize+16));
		yes.setBounds((Width-left-right)/2-WidthText(new Font(fontType,1,fontSize+16),"Да")/2-dist/2,(int)((Height-top-bottom)*0.53)+top,
				WidthText(new Font(fontType,1,fontSize+16),"Да")+100,HeightText(new Font(fontType,1,fontSize+16))+20);
		
		
		JButton no = new JButton("Нет");
		no.setFont(new Font(fontType,1,fontSize+16));
		no.setBounds((Width-left-right-WidthText(new Font(fontType,1,fontSize+16),"Нет")+dist)/2,(int)((Height-top-bottom)*0.53)+top,
				WidthText(new Font(fontType,1,fontSize+16),"Нет")+100,HeightText(new Font(fontType,1,fontSize+16))+20);
		
		JButton exit = new JButton("Выход");
		exit.setFont(new Font(fontType,1,fontSize));
		exit.setBounds(Width-right-WidthText(new Font(fontType,1,fontSize),"Выход")-100,(int)((Height-top-bottom)*0.85)+top,
				WidthText(new Font(fontType,1,fontSize),"Выход")+50,HeightText(new Font(fontType,1,fontSize))+5);
		
		
		
		
		JLabel stock = new JLabel("Осталось вопросов: "+numValQuest);
		stock.setFont(new Font(fontType,1,fontSize+5));
		stock.setBounds(left,(int)((Height-top-bottom)*0.85)+top,
				WidthText(new Font(fontType,1,fontSize+5),"Осталось вопросов: "+numValQuest)+20,HeightText(new Font(fontType,1,fontSize+5)));
		
		
		
		
		add(question);
		add(yes);
		add(no);
		add(exit);
		add(stock);
		
		
		
		
		
		
		
		//Задаем события на кнопки
		yes.addActionListener(new
	    		ActionListener()
	      		{
	          		public void actionPerformed(ActionEvent event)
	          		{	
	          			if ((numClicAnsver+1)>vopr.massQuest.size()-1) {
	          				write.WriteResult("1");
	          				write.WriteClose();
	          				question.setText("Тестирование завершено!");
	          				PrintResult();
	          				yes.setEnabled(false);
	          				no.setEnabled(false);
	          				repaint();
		          			validate();
		          			
	          			} else {
	          				write.WriteResult("1");
	          				questTest=vopr.massQuest.get(numClicAnsver+1);
	          				question.setBounds((Width-left-right-50)/2-WidthText(new Font(fontType,1,fontSize+poprFontQues),questTest)/2,(int)((Height-top-bottom)*0.32)+top,
	          						WidthText(new Font(fontType,1,fontSize+poprFontQues),questTest)+poprWString,HeightText(new Font(fontType,1,fontSize+poprFontQues)));
	          				question.setText(questTest);
	          				numValQuest=numValQuest-1;
	          				stock.setText("Осталось вопросов: "+numValQuest);
	          				repaint();
	          				validate();
	          				numClicAnsver++;
	          			}

	          		}
	          	});
		
		no.addActionListener(new
	    		ActionListener()
	      		{
	          		public void actionPerformed(ActionEvent event)
	          		{	
	          			if ((numClicAnsver+1)>vopr.massQuest.size()-1) {
	          				write.WriteResult("0");
	          				write.WriteClose();
	          				question.setText("Тестирование завершено!");
	          				PrintResult();
	          				yes.setEnabled(false);
	          				no.setEnabled(false);
	          				repaint();
		          			validate();
	          			} else {
	          				write.WriteResult("0");
	          				questTest=vopr.massQuest.get(numClicAnsver+1);
	          				question.setBounds((Width-left-right-50)/2-WidthText(new Font(fontType,1,fontSize+poprFontQues),questTest)/2,(int)((Height-top-bottom)*0.32)+top,
	          						WidthText(new Font(fontType,1,fontSize+poprFontQues),questTest)+poprWString,HeightText(new Font(fontType,1,fontSize+poprFontQues)));
	          				question.setText(questTest);
	          				numValQuest=numValQuest-1;
	          				stock.setText("Осталось вопросов: "+numValQuest);
	          				repaint();
	          				validate();
	          				numClicAnsver++;
	          			}
	          			
	          			
	          		}
	          	});
		
		
	}
	
	
}
