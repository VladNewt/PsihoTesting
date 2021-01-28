package DB;

import java.io.*;

public class TestWriter {
	private static PrintStream writer;
	
	public TestWriter() {
		try {
			writer = new PrintStream("out.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void WriteResult(String result) {
			writer.println(result);
			//writer.close();
	}
	
	public void WriteClose() {
		writer.close();
	}
	
}
