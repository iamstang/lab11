package tasktimer;

import static java.lang.System.out;

import java.io.InputStream;
import java.util.Scanner;

/*
 * @author Khanutchon Ammawong
 */
public class Task1 implements Runnable {
	
	private Scanner in;


	Task1(){
		
		InputStream instream = Dictionary.getWordsAsStream();
		in = new Scanner(instream);
	}
	
	
	/**
     * Process all the words in a file using Scanner to read and parse input.
     * Display summary statistics and elapsed time.
     */
	public void run(){
		
        // perform the task
        int count = 0;
        long totalsize = 0;
        while(in.hasNext()) {
            String word = in.next();
            totalsize += word.length();
            count++;
        }
        double averageLength = ((double)totalsize)/(count>0 ? count : 1);
        out.printf("Average length of %,d words is %.2f\n", count, averageLength);
	}
	
	
	public String toString(){
		
		return "read words using Scanner and a while loop";
	}

}
