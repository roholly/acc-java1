package edu.acc.java;

import java.util.Random;
import java.util.Scanner;

public class BattleShipImpl implements BattleShipIF {

	
	/*
		 * Write a BattleShip class that uses 10 arrays (y0 – y9) of 10 elements each. 
		 * 
		 * Hide (2) ships by generating two random starting locations (x,y) where 
		 *   y is the array and x is the element in that array. 
		 *   Generate another random for the ship size which can be from 1 to 10. 
		 *   Do not reveal ship locations to user.
		 *   
		 * Game play: allow user to enter (x,y) coordinates using Scanner 
		 *   class and if it “hits” a ship print “hit”, else print “miss”. 
		 *   When all coordinates of ship are hit print “sunk”. 
		 *   When both ships sunk say “game over, you took “ <count> “ tries 
		 *   to sink ships”. 
		 *   
		 * Version 2.0: convert the 10 arrays to a single two dimensional array
		 */

	// int[][] oceanTerritory = new int[10][10];
	// public int[][] generateShip();

	final int arrayLength = 10;
	final int numArrays = 10;
	boolean[] y0, y1, y2, y3, y4, y5, y6, y7, y8, y9;
	
	public BattleShipImpl()  {
		y0 = new boolean[arrayLength];
		y1 = new boolean[arrayLength];
		y2 = new boolean[arrayLength];
		y3 = new boolean[arrayLength];
		y4 = new boolean[arrayLength];
		y5 = new boolean[arrayLength];
		y6 = new boolean[arrayLength];
		y7 = new boolean[arrayLength];
		y8 = new boolean[arrayLength];
		y9 = new boolean[arrayLength];
		
	}
	
	public void generateShips(int numShips)  {
		Random rand = new Random();
		int i = 0;
		while (i < numShips)  {
			int shipArrayNum = rand.nextInt(numArrays);
			if (shipExists(shipArrayNum))  {
				continue;
			}
			int shipXStart = rand.nextInt(arrayLength - 1);
			int shipLength = rand.nextInt(arrayLength - 1) + 1;
			createShip(shipArrayNum, shipXStart, shipLength);
			i++;
		}
	}
	
	public boolean shipExists(int arrayNum)  {
		switch (arrayNum)  {
		case 0:  return scanForTrue(y0);
		case 1:  return scanForTrue(y1);
		case 2:  return scanForTrue(y2);
		case 3:  return scanForTrue(y3);
		case 4:  return scanForTrue(y4);
		case 5:  return scanForTrue(y5);
		case 6:  return scanForTrue(y6);
		case 7:  return scanForTrue(y7);
		case 8:  return scanForTrue(y8);
		case 9:  return scanForTrue(y9);
		}
		return false;
		
	}
	
	public boolean scanForTrue(boolean[] array)  {
		for (int i = 0; i < arrayLength; i++)  {
			if (array[i])  {
				return true;
				}
		}
		return false;
	}
	
	public void createShip(int arrayNum, int xStart, int xLength)  {
		int xEnd = Math.min(xStart + xLength, arrayLength);
		switch (arrayNum)  {
		case 0: for (int i = xStart; i < xEnd; i++) y0[i] = true; break;
		case 1: for (int i = xStart; i < xEnd; i++) y1[i] = true; break;
		case 2: for (int i = xStart; i < xEnd; i++) y2[i] = true; break;
		case 3: for (int i = xStart; i < xEnd; i++) y3[i] = true; break;
		case 4: for (int i = xStart; i < xEnd; i++) y4[i] = true; break;
		case 5: for (int i = xStart; i < xEnd; i++) y5[i] = true; break;
		case 6: for (int i = xStart; i < xEnd; i++) y6[i] = true; break;
		case 7: for (int i = xStart; i < xEnd; i++) y7[i] = true; break;
		case 8: for (int i = xStart; i < xEnd; i++) y8[i] = true; break;
		case 9: for (int i = xStart; i < xEnd; i++) y9[i] = true; break;
		
		}
	}
	
	public void printArray(boolean[] array)  {
		System.out.println();
		for (int i = 0; i< array.length; i++)  {
			if (array[i])  {
				System.out.print("X");
			}
			else {
				System.out.print(".");
			}
		}
	}
	
	public void printGameBoard()  {
		printArray(y0);
		printArray(y1);
		printArray(y2);
		printArray(y3);
		printArray(y4);
		printArray(y5);
		printArray(y6);
		printArray(y7);
		printArray(y8);
	}
	
	public boolean keepFiring() {
		for (int i = 0; i < numArrays; i++)  {
			if (shipExists(i))  {
				return true;
			}
		}
		return false;
	}
	
	
	
	static public void main(String[] args)  {
		BattleShipImpl game = new BattleShipImpl();
		game.generateShips(2);
		game.printGameBoard();
		Scanner userIn = new Scanner(System.in);
		int shotCnt = 0;
		
		prompt:  while (game.keepFiring())  {
			game.printGameBoard();
			System.out.print("\nEnter x and y coordinates to fire at in format \'x,y\' where x and y are each from 1 to " + game.arrayLength + ":  ");
			int x, y = 0;
			while (true)  {
				String[] coordinate = userIn.next().split(",");
				if (coordinate.length !=2)  {
					sayInvalidInput();
					continue prompt;
				}
				try {
						x = Integer.parseInt(coordinate[0].trim());
						y = Integer.parseInt(coordinate[1].trim());
						if ((x < 1 || x > game.arrayLength) || (y < 1 || y > game.arrayLength))  {
							sayInvalidInput();
							continue prompt;
						}
						break;
				}
				
				catch (NumberFormatException e)  {
					sayInvalidInput();
					continue prompt;
				}
			}
			shotCnt++;
			
			boolean hit = game.fireAtCoordinates(x - 1,  y - 1);
			if (hit)  {
				System.out.print(" hit");
				if (!game.shipExists(y - 1))  {
					System.out.println(" sunk");
				}
			}  else {
						System.out.print("miss");
			}
			
		}
		System.out.println("Game over, you took " + shotCnt
					+ " tries to sink ships.");

	}
	
	public boolean fireAtCoordinates(int x, int y)  {
		boolean value = false;
		
		switch (y)  {
		case 0: value = y0[x]; y0[x] = false; break;
		case 1: value = y1[x]; y1[x] = false; break;
		case 2: value = y2[x]; y2[x] = false; break;
		case 3: value = y3[x]; y3[x] = false; break;
		case 4: value = y4[x]; y4[x] = false; break;
		case 5: value = y5[x]; y5[x] = false; break;
		case 6: value = y6[x]; y6[x] = false; break;
		case 7: value = y7[x]; y7[x] = false; break;
		case 8: value = y8[x]; y8[x] = false; break;
		case 9: value = y9[x]; y9[x] = false; break;
		}
		return value;
		
	}
	
	public static void sayInvalidInput()  {
		System.out.println("Invalid input.  Try again.");
	}	
	
}

