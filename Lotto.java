package edu.acc.java;

import java.util.Arrays;

public final class Lotto implements LottoIF {
	
	private LotteryDrawingIF testDrive;
	
	private int numLottoBalls = NUM_LOTTO_BALLS;
	private int maxBallNum = MAX_BALL_NUM;
	private int years = YEARS;
	
	public void calc_odds(int numLottoBalls, int maxBallNum)  {
		long odds = 1;
		int[] balls = new int[maxBallNum];
		for (int i=0; i < maxBallNum; i++)  {
				balls[i] = i+1;
			}
		int startIndex = balls.length - numLottoBalls;
		int[] newArray = Arrays.copyOfRange(balls, startIndex, balls.length);
		//System.out.println(Arrays.toString(newArray));
		for (int i : newArray)  {
			odds *= i;
		}
		System.out.println("odds are " + odds);	
	}
	
	public void print_results() {
		int i = 0;
		for (int next_result : testDrive.getResults())  {
			System.out.printf("%7s %7s %7.1f%%\n", i++, next_result, (next_result/(years*104.))*100);
		}
	}
	
	public void usage()  {
		System.out.println("\nUsage:  java Lotto.java [-b <num_balls>] [-p <max_ball_num>] [-y <years>]\n\n"
				+ "where:\n"
				+ "\tnum_balls is the number of lotto balls to play (default is 6)\n"
				+ "\tmax_ball_num is the maximum ball number (default is 54)\n"
				+ "\tyears is the number of years to simulate (default is 1)\n\n");
	}
	
	private void process_command_line(String[] args)  {
		/*
		 * Example call would be Lotto.java -b 6 -p 54 -y 1
		 * where -b is number of lotto balls (default 6)
		 *       -p is the maximum ball number (default and max is 54)
		 *       -y is the number of years to simulate (default 1)
		 */
		// Check for even number of arguments:
		if (args.length % 2 != 0)  { 
			this.usage();
			System.exit(1);
		}
		
		for (int i=0; i < args.length;)  {
           	switch (args[i].trim())  {      	
        		case "-b":
        			this.numLottoBalls = Integer.parseInt(args[++i]);
        			break;
        		case "-p":
        			this.maxBallNum = Integer.parseInt(args[++i]);
        			break;
        		case "-y":
        			this.years = Integer.parseInt(args[++i]);
        			break;
        		default:  System.out.println("Invalid argument detected.  Ignoring ...");
        		}
           	i++;
        	
        	}
 	
	}
		
  

	public static void main(String[] args) {
		
		Lotto lt = new Lotto();
		lt.process_command_line(args);
		lt.calc_odds(lt.numLottoBalls, lt.maxBallNum);
		lt.testDrive = new LotteryDrawing(lt.numLottoBalls, lt.maxBallNum, lt.years);
		lt.testDrive.run_simulation();
		lt.print_results();
			
	}
	
		
		
		
}
