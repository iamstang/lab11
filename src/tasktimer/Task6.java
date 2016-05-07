package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * @author Khanutchon Ammawong
 */
public class Task6 implements Runnable {

	static final int MAXCOUNT = 50_000;
	BufferedReader br;

	Task6(){
		// initialize
		InputStream instream = Dictionary.getWordsAsStream();
		br = null;
		try {
			br = new BufferedReader( new InputStreamReader(instream) );
		} catch (Exception ex) {
			out.println("Could not open dictionary: "+ex.getMessage() );
			return;
		}
	}


    /** 
     * Append all the words from the dictionary to a StringBuilder.
     * Compare how long this takes to appending to String.
     */
    public void run( ) {
        
        StringBuilder result = new StringBuilder();
        String word = null;
        int count = 0;
        try {
            while( (word=br.readLine()) != null  && count < MAXCOUNT) {
                result.append(word);
                count++;
            }
        } catch(IOException ioe) { System.out.println( ioe.getMessage() ); }
        System.out.printf("Done appending %d words to StringBuilder.\n", count);
        
    }
        
       
	public String toString(){

		return "append "+MAXCOUNT+" words to a StringBuilder";
	}
}
