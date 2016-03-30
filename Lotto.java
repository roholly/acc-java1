package edu.acc.java;

import java.util.Arrays;

public class Lotto {
	
	
	//void calc_odds();
	//void print_results();
	
	//String args = "-b 6 -p 54 -y 1";
	private int numLottoBalls = 6;
	private int maxBallNum = 54;
	private int years = 1;
	
	
	public void calc_odds(int numLottoBalls, int maxBallNum)  {
		int odds = 1;
		int[] balls = new int[maxBallNum];
		for (int i=0; i < maxBallNum; i++)  {
				balls[i] = i+1;
			}
		System.out.println("array length is " + balls.length);
		int startIndex = balls.length - numLottoBalls;
		int[] newArray = Arrays.copyOfRange(balls, startIndex, balls.length);
		System.out.println(Arrays.toString(newArray));
		for (int i : newArray)  {
			odds *= i;
		}
		System.out.println("odds are " + odds);	
	}
	

	public static void main(String[] args) {
		
		Lotto lt = new Lotto();
		lt.calc_odds(lt.numLottoBalls, lt.maxBallNum);
	}
		
		
		/*
		 * Example call would be Lotto.java -b 6 -p 54 -y 1
		 * where -b is number of lotto balls (default 6)
		 *       -p is the maximum ball number (default and max is 54)
		 *       -y is the number of years to simulate (default 1)
	
		//int i = 0;
       while (i < args.length && args[i].startsWith("-"))  {
        	String arg = args[i++];
        	for (int j=1; j < args.length; j++)  {
        		char flag = arg.CharAt(j);
        		switch(flag)  {
        		case 'b':
        			numLottoBalls
        		}
        	}
        	
        	
                charflag = arg.charAt(j);
                switch (flag) {
                case 'x':
                    if (vflag) System.out.println("Option x");
                    break;
                case 'n':
                    if (vflag) System.out.println("Option n");
                    break;
                default:
                    System.err.println("ParseCmdLine: illegal option " + flag);
                    break;
                }
        	
        }
		
	}


		*/
}
