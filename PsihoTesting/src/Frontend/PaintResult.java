package Frontend;

import java.awt.Color;

import javax.swing.*;

import DB.AizenkResult;

public class PaintResult implements MainDialog{
	public int extraVal = 0;
	public int neiroVal = 0;
	public int leeVal = 0;
	
	private int[] extraMinColor = {189,183,107};
	private int[] extraMaxColor = {255,255,0};
	private int extraMinVal=0;
	private int extraMaxVal=24;
	private int[] neiroMinColor = {0,0,128};
	private int[] neiroMaxColor = {0,255,0};
	private int neiroMinVal = 0;
	private int neiroMaxVal = 24;
	private int[] leeMinColor = {240,128,128};
	private int[] leeMaxColor = {255,0,0};
	private int leeMinVal = 0;
	private int leeMaxVal = 9;
	
	private int[] InterpColor(int[]minColor, int[]maxColor, int paramMin, int paramMax, int param) {
		int[] col = new int[3];
		for (int i=0; i<3;i++) {
			col[i]=(int)(minColor[i]+(maxColor[i]-minColor[i])*(param-paramMin)/(paramMax-paramMin));
		}
		return col;
	}
	
	private Color setColor(int[] paramColor) {			//64,224,208   до 255,255,0
		Color myColor = new Color(paramColor[0],paramColor[1],paramColor[2]);
		return myColor;
	}
	
	
	public void Create() {
		
		//Загружаем результаты тестирования
		AizenkResult resTest = new AizenkResult();
		extraVal=resTest.AizenkExtravers(resTest.massQuest);
		neiroVal=resTest.AizenkNeirotizm(resTest.massQuest);
		leeVal = resTest.AizenkLee(resTest.massQuest);
		
		//Выполняем вычисление цвета шкалы
		Color colorBarExtra=setColor(InterpColor(extraMinColor,extraMaxColor,extraMinVal,extraMaxVal,extraVal));
		Color colorBarNeiro=setColor(InterpColor(neiroMinColor,neiroMaxColor,neiroMinVal,neiroMaxVal,neiroVal));
		Color colorBarLee=setColor(InterpColor(leeMinColor,leeMaxColor,leeMinVal,leeMaxVal,leeVal));
		
		//Размеры и положение окна
		int wPlace=100;
		int hPlace=100;
		int wWnd=600;
		int hWnd=300;
		
		//Положение текста подписи
		int wTextPlace = 20;
		int hTextExtraPlace = 50;
		int hDistBar = 50;
		
		JLabel[] nameElem = new JLabel[6];
		
		nameElem[0] = new JLabel("Интроверсия/Экстраверсия");
		nameElem[0].setBounds(wTextPlace,hTextExtraPlace,300,15);
		
		nameElem[1] = new JLabel("Нейротизм");
		nameElem[1].setBounds(wTextPlace,hTextExtraPlace+hDistBar,300,15);
		
		nameElem[2] = new JLabel("Шкала лжи");
		nameElem[2].setBounds(wTextPlace,hTextExtraPlace+2*hDistBar,300,15);
		
		nameElem[3] =new JLabel(Integer.toString(extraVal));
		nameElem[3].setBounds(wTextPlace+170+300+15,hTextExtraPlace,30,15);
		
		nameElem[4] =new JLabel(Integer.toString(neiroVal));
		nameElem[4].setBounds(wTextPlace+170+300+15,hTextExtraPlace+hDistBar,30,15);
		
		nameElem[5] =new JLabel(Integer.toString(leeVal));
		nameElem[5].setBounds(wTextPlace+170+300+15,hTextExtraPlace+2*hDistBar,30,15);
		
		
		
		JProgressBar extrav = new JProgressBar();
		extrav.setBounds(wTextPlace+170,hTextExtraPlace,300,20);
		extrav.setMinimum(0);
		extrav.setMaximum(24);
		extrav.setValue(extraVal);
		extrav.setForeground(colorBarExtra);
		
		
		JProgressBar neirot = new JProgressBar();
		neirot.setBounds(wTextPlace+170,hTextExtraPlace+hDistBar,300,20);
		neirot.setMinimum(0);
		neirot.setMaximum(24);
		neirot.setValue(neiroVal);
		neirot.setForeground(colorBarNeiro);
		
		JProgressBar lee = new JProgressBar();
		lee.setBounds(wTextPlace+170,hTextExtraPlace+2*hDistBar,300,20);
		lee.setMinimum(0);
		lee.setMaximum(9);
		lee.setValue(leeVal);
		lee.setForeground(colorBarLee);
		
		
		DialogUnivers dlg = new DialogUnivers();
		dlg.setBounds(wPlace,hPlace,wWnd,hWnd);
		dlg.setTitle("Результат тестирования по Айзенку");
		
		for(int i=0;i<6;i++) {
			dlg.add(nameElem[i]);
		}
		
		dlg.add(extrav);
		dlg.add(neirot);
		dlg.add(lee);
		
		
		dlg.setVisible(true);
	}
}
