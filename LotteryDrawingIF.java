package edu.acc.java;

public interface LotteryDrawingIF {
	
	int[] getResults();


 	void run_simulation();


	/**
	 * Returns an int[] of unique random integers from 1 .. max_ball_num
	 * Depends on external rand variable as a Random generator
	 * @return
	 */
	int[] pick_numbers();

}
