package game1024;

import java.util.ArrayList;

public class NumberGame implements NumberSlider {
	
	private int winningValue;
	public int[][] gameBoard;
	
	public static void main(String[] args) {
		
	}

	/**
	 * @Override
	 * @Exception
	 * 
	 * Sets size of 2D array that is used as the game board.
	 * Also sets the winning value of the game.
	 * 
	 */
	public void resizeBoard(int height, int width, int winningValue) throws Exception {
		gameBoard = new int[height][width];
		this.winningValue = winningValue;
	}

	/**
	 * @Override
	 * 
	 * Sets all values within the game board to zero.
	 * 
	 */
	public void reset() {
		for(int i=0; i<gameBoard[0].length; i++) {
			for(int j=0; j<gameBoard.length; j++) {
				gameBoard[i][j] = 0;
			}
			
		}
		
		// TODO: Place two random values on the game board.
		
	}

	/**
	 * @Override
	 */
	public void setValues(int[][] ref) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @Override
	 */
	public Cell placeRandomValue() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Override
	 */
	public boolean slide(SlideDirection dir) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @Override
	 */
	public ArrayList<Cell> getNonEmptyTiles() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Override
	 */
	public GameStatus getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Override
	 */
	public void undo() {
		// TODO Auto-generated method stub
	}
	
	}