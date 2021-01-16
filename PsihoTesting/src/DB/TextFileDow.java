package DB;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileDow {
	private static FileWriter writer;
	private static BufferedReader br;
	
	public static ArrayList<String> massQuest = new ArrayList<>();
	public static int numQuest=0;
	public static String nameFileQuestion = "Opros2.txt";
	
	public TextFileDow() throws IOException {
		FileReader reader = new FileReader(nameFileQuestion);
		Scanner scan = new Scanner(reader);
		
		while(scan.hasNextLine()) {
			massQuest.add(scan.nextLine());
			numQuest++;
		}
		reader.close();
		
	}
}
