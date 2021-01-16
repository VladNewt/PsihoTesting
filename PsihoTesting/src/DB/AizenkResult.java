package DB;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AizenkResult {
	public static ArrayList<String> massQuest = new ArrayList<>();
	private static String nameFileAnsver = "out.txt";
	
	public AizenkResult() {
		try {
			FileReader reader = new FileReader(nameFileAnsver);
			Scanner scan = new Scanner(reader);
		
			while(scan.hasNextLine()) {
				massQuest.add(scan.nextLine());
			}
			reader.close();
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int AizenkExtravers(ArrayList<String> massQuest) {
		int extra = 0;
		int i = 1;
		while(i<massQuest.size()+1) {
			if ((massQuest.get(i-1).equals("1"))&&((i==1)||(i==3)||(i==8)
					||(i==10)||(i==13)||(i==17)||(i==22)||(i==25)||(i==27)
					||(i==39)||(i==44)||(i==46)||(i==49)||(i==53)||(i==56))) {
				extra++;
			}
			if ((massQuest.get(i-1).equals("0"))&&((i==5)||(i==15)||(i==20)
					||(i==29)||(i==32)||(i==34)||(i==37)||(i==41)||(i==51))) {
				extra++;
			}
			i++;
		}
		return extra;
		
	}
	
	public int AizenkNeirotizm(ArrayList<String> massQuest) {
		int neiro=0;
		int i=1;
		while(i<massQuest.size()+1) {
			if ((massQuest.get(i-1).equals("1"))&&((i==2)||(i==4)||(i==7)
					||(i==9)||(i==11)||(i==14)||(i==16)||(i==19)||(i==21)
					||(i==23)||(i==26)||(i==28)||(i==31)||(i==33)||(i==35)||(i==38)||(i==40)||(i==43)||(i==45)||(i==47)||(i==50)||(i==52)
					||(i==55)||(i==57))) {
				neiro++;
			}
			i++;
		}
		return neiro;
	}
	
	public int AizenkLee(ArrayList<String> massQuest) {
		int lee=0;
		int i=1;
		while(i<massQuest.size()) {
			if ((massQuest.get(i-1).equals("1"))&&((i==6)||(i==24)||(i==36))) {
				lee++;
			}
			if ((massQuest.get(i-1).equals("0"))&&((i==12)||(i==18)||(i==30)||(i==42)||(i==48)||(i==54))) {
				lee++;
			}
			i++;
		}
		return lee;
	}
}
