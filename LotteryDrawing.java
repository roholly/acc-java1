package edu.acc.java;

import java.util.Arrays;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class LotteryDrawing {
	
	private int[] results = new int[6];
	
	public int getResults(int i) {
		return this.results[i];
	}

	public void setResults(int i, int n) {
		this.results[i] = n;
	}

	private int[] pick_numbers(int numBalls)  {
		int[] drawnNumbers = new int[numBalls];
		// 54 is max and default for ball numbers -- command line argument
		int maxBalls = 54;
		Random rand = new Random();
		for (int i=0; i < numBalls; i++)  {
			while (drawnNumbers[i] == 0)  {
				int ball = rand.nextInt(maxBalls) + 1;
				if (isUnique(drawnNumbers, ball))  {
					drawnNumbers[i] = ball;
				}
			}
		}
		return drawnNumbers;
		
	}
	
	public boolean isUnique(int[] intArray, int n)  {
		for (int i = 0; i < intArray.length; i++)  {
			if (intArray[i] == n )  {
				return false;
			}
		}
		return true;
	}
	
	// numYears will be a command line argument -- overridden in this method?
	public void run_simulation(int numYears)  {
		
		int numDrawings = (numYears * 2);
		int numMatches;
		
		for (int drawingRound = 0; drawingRound < numDrawings; drawingRound++)  {
			
			// 6 is default value for number of balls -- command line argument.
			
			//Define a winning list and put it in an ArrayList:
			int[] winningNumbers = this.pick_numbers(6);
			System.out.println(Arrays.toString(winningNumbers));
			List<Integer> winArrayList = new ArrayList<>();
			for (int num:  winningNumbers)  {
				winArrayList.add(num);
			}
			
			//Define a quick pick list:
			int[] quickPicks = this.pick_numbers(6);
			System.out.println(Arrays.toString(quickPicks));
		
			// Traverse through winArrayList to find number of matches from quickPicks
			numMatches=0;
			for (int num:  quickPicks)  {
				if (winArrayList.contains(num))  {
					numMatches++;
				}	
			}
			System.out.println("Adding 1 in results array to " + numMatches + " index.");
			this.setResults(numMatches, this.getResults(numMatches+1));
		}
		
	}
	
	public static void main(String[] args)  {
		LotteryDrawing ld = new LotteryDrawing();
		// 6 is default value for number of balls -- command line argument.
		ld.run_simulation(5);
		
	}
	

}
