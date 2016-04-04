package edu.acc.java;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public final class LotteryDrawing implements LotteryDrawingIF  {
	
	private int numLottoBalls;
	private int maxBallNum;
	private int numDrawings;
	private int[] results;
	private Random rand;
	
	public int[] getResults() {
		return results;
	}

		
	public LotteryDrawing(int numLottoBalls, int maxBallNum, int years)  {
		this.numLottoBalls = numLottoBalls;
		this.maxBallNum = maxBallNum;
		this.numDrawings = years*104;
		results = new int[numLottoBalls + 1];
		
		rand = new Random();
	}

	public int[] pick_numbers()  {
		int[] drawnNumbers = new int[numLottoBalls];
		for (int i=0; i < numLottoBalls; i++)  {
			while (drawnNumbers[i] == 0)  {
				int ball = rand.nextInt(maxBallNum) + 1;
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
	
	public void run_simulation()  {
		
		int numMatches;
		
		for (int drawingRound = 0; drawingRound < numDrawings; drawingRound++)  {
			
			//Define a winning list and put it in an ArrayList:
			int[] winningNumbers = this.pick_numbers();
			//System.out.println(Arrays.toString(winningNumbers));
			List<Integer> winArrayList = new ArrayList<>();
			for (int num:  winningNumbers)  {
				winArrayList.add(num);
			}
			
			//Define a quick pick list:
			int[] quickPicks = this.pick_numbers();
			//System.out.println(Arrays.toString(quickPicks));
		
			// Traverse through winArrayList to find number of matches from quickPicks
			numMatches=0;
			for (int num:  quickPicks)  {
				if (winArrayList.contains(num))  {
					numMatches++;
				}	
			}
			results[numMatches]++;
			//System.out.println("results index of " + numMatches + " is " + results[numMatches]);
		}
		
	}
	
	
		
}
