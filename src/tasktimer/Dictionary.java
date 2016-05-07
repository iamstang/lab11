package tasktimer;

import java.io.InputStream;
import java.util.Scanner;

public class Dictionary {
	private static String DICTIONARY = "wordlist.txt";
	
	public static InputStream getWordsAsStream(){
		
		return TaskTimer.class.getClassLoader().getResourceAsStream(DICTIONARY);
		
	}
}
