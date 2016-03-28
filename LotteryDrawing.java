package edu.acc.java;

import java.util.Arrays;
import java.util.Random;

public class LotteryDrawing {
	
	private int[] pick_numbers(int numBalls)  {
		int[] drawnNumbers = new int[numBalls];
		Random rand = new Random();
		for (int i=0; i < numBalls; i++)  {
			while (drawnNumbers[i] == 0)  {
				int ball = rand.nextInt(numBalls);
				if (isUnique(drawnNumbers, ball))  {
					drawnNumbers[i] = ball;
				}
			}
		}
		return drawnNumbers;
		
	}
	
	public boolean isUnique(int[] intArray, int n)  {
		System.out.println("Running isUnique and testing number " + n + ".  intArray.length is " + intArray.length);
		for (int i = 0; i < intArray.length; i++)  {
			if (intArray[i] == n )  {
				System.out.println("i is " + i + ".  intArray[i] is " + intArray[i] + " and n is " + n);
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args)  {
		LotteryDrawing ld = new LotteryDrawing();
		int[] lotteryArray = ld.pick_numbers(6);
		System.out.println(Arrays.toString(lotteryArray));
		System.out.println("something");
	}
	

}
