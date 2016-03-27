package edu.acc.java;

public interface BattleShipIF {


	void generateShips(int numShips);

	boolean shipExists(int arrayNum);
	
	boolean scanForTrue(boolean[] array);
	
	void createShip(int arrayNum, int xStart, int xLength);
	
	void printArray(boolean[] array);
	
	void printGameBoard();
	
	boolean keepFiring();
	
	boolean fireAtCoordinates(int x, int y);
	

}
