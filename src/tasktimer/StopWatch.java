package tasktimer;
/*
 * @author Khanutchon Ammawong
 */
public class StopWatch {
	
	private static final double NANOSECONDS = 1.0E-9;
	
	private long startTime;
	private long stopTime;
	private boolean running = false;
	
	/*
	 * time when start the task
	 */
	public void start(){
		
		if (! running ) {
			startTime = System.nanoTime();
			running = true;
		}
	}
	
	/*
	 * time when finish the task
	 */
	public void stop(){
		
		if (running) {
			stopTime = System.nanoTime();
			running = false;
		}
	}
	
	/*
	 * calculate the used time
	 */
	public double getElapsed(){
		
		return (stopTime - startTime)*NANOSECONDS;
	}
}
