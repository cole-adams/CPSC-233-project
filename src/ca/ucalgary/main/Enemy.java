package ca.ucalgary.main;

import java.util.Random;

public class Enemy {
	
	private int x;
	private int y;
	
	private static int counter;
	
	private boolean alive;
	
	private String symbol = "V";
	
	Enemy() {
		this.x = new Random().nextInt(TextGame.COLUMNS - 1);
		this.y = 0;
		this.alive = true;
		
	}
	
	Enemy(int y) {
		this.x = new Random().nextInt(TextGame.COLUMNS - 1);
		this.y = y;
		this.alive = true;
	}
	
	//moves the enemy down one row and randomly in the horizontal(-1, 0 or +1)
	public boolean move() {
		
		y = y++;
		if(y == TextGame.ROWS - 1) {
			alive = false;
		}
		
		else if(x == TextGame.COLUMNS - 1) {
			int move = new Random().nextInt(3) - 1;
			if(move == 0 || move == -1) {
				x = x + move;
			} else {
				x = 0;
			}
		}
		
		else if(x == 0) {
			int move = new Random().nextInt(3) - 1;
			if(move == 0 || move == 1) {
				x = x + move;
			} else {
				x = TextGame.COLUMNS - 1;
			}
		}
		
		else{
			int move = new Random().nextInt(3) - 1;
			x = x + move;
		}
		return alive;
	}
	
	
	//Checks for collision with players ship
	public boolean collidedWith(Player player) {
		boolean collided = false;
		if(x > player.getX()) {
			collided = false;
		}
		else if(x == player.getX() && y == player.getY()) {
			collided = true;
		}
		return collided;
	} 
	
	
	
	
	public int getX() {
		return x;
	}

	public boolean isAlive() {
		return alive;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void draw(String[][] board) {
        System.out.println(x + " " + y);
		board[x][y] = symbol;
	}
	
	
}
