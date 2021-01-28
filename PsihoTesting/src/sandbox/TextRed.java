package sandbox;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextRed {

	public static void main(String[] args) throws IOException {
		FileReader reader = new FileReader("Opros.txt");
		FileWriter writer =new FileWriter("output.txt", false);
		BufferedReader br = new BufferedReader(reader);
		
		//Вычленяем порядковые ноиера
		String str;
		
		while ((str=br.readLine())!=null) {
			String vopr = str.substring(3, str.length());
			//vopr.trim();
			vopr.replaceAll("\t", "");
		
		System.out.println(vopr);
		writer.write(vopr+"\r\n");
		}
		
		writer.flush();
	}

}
