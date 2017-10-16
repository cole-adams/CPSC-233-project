package ca.ucalgary.main;
/**
 * This Collectable class allows the game to interact with 
 * the position of collectables spawned within the enemy 
 * class. 
 * The class updates the collectable's position and checks 
 * if it is still within the range of the game board.
 * 
 * @author lilypollreis
 *
 */
public class Collectable {

	private int x;
	private int y;
	
	Collectable(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Gets integer column value the collectable.
	 * @return integer column value the collectable.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets new integer column value for the collectable.
	 * @param x new column value.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets integer row value the collectable.
	 * @return integer row value the collectable.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets new integer row value for the collectable.
	 * @param y new row value.
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Moves collectable down the screen by one row every turn 
	 * until it is no longer within the range of the game board.
	 * 
	 * @param board array list that is the game board.
	 * @return true if the collectable is still within
	 * the range of the game board.
	 */
	public boolean move(String[][] board) {
		boolean onScreen = true;
		if (y == (board.length - 1)) {
			onScreen = false;
		} else {
			y++;
		}
		return onScreen;
	}

	/**
	 * Prints the character '$' at the current X and Y 
	 * value on the array list that is the game board.
	 * @param board array list that is the game board.
	 */
	public void draw(String[][] board) {
		board[y][x] = "$";
	}
}
