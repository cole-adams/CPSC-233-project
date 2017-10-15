package ca.ucalgary.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TextGame {
	
	public static final int ROWS = 10;
	public static final int COLUMNS = 7;
	
	private ArrayList<Enemy> enemies;
	private ArrayList<Projectile> projectiles;
	private ArrayList<Collectable> collectables;
	private Player player;
	
	private String[][] board;
	
	private boolean running;
	
	public TextGame() {
		enemies = new ArrayList<Enemy>();
		projectiles = new ArrayList<Projectile>();
		collectables = new ArrayList<Collectable>();
		
        player = new Player(COLUMNS/2, ROWS - 2, 5);		
		board = initBoard();
	}
	
	//Cole
	public void run() {
		running = true;
		
		
		while (running) {
			String input = getInput();
			move(input);
			checkCollisions();
			enemies.add(new Enemy(0));
			projectiles.add(new Projectile(player.getX(), player.getY() - 1));
			draw();
			print();
		}
		
	}
	
	//Quinn
	public void checkCollisions() {
        // check collisions between enemies and projectiles
        for (Iterator<Enemy> enemyItr = enemies.iterator(); enemyItr.hasNext();) {
            Enemy enemy = enemyItr.next();
            for (Iterator<Projectile> projecItr = projectiles.iterator(); projecItr.hasNext();) {
                Projectile projec = projecItr.next();
                // if enemy and projectile collide, remove each from respective arraylists
                if (projec.collidedWith(enemy)) {
                    projecItr.remove();
                    enemyItr.remove();
                }
            }
        }
        // check collisions between collectables and player
        for (Iterator<Collectable> collecItr = collectables.iterator(); collecItr.hasNext();) {
            Collectable collec = collecItr.next();
            if (player.collidedWith(collec)) {
                collecItr.remove();
            }
        }
        
        // check collisions between enemies and player
        for (Iterator<Enemy> enemyItr = enemies.iterator(); enemyItr.hasNext();) {
            Enemy enemy = enemyItr.next();
            // decrease player health by one if collision occurs
            if (enemy.collidedWith(player)) {
                int health = player.getHealth() - 1;
                player.setHealth(health);
            }
        }
    }
	
	//Quinn
	public String[][] draw() {
        
        clearBoard();
        
        player.draw(board);
        
        for (Enemy enemy : enemies) {
            enemy.draw(board);
        }

        for (Projectile projectile : projectiles) {
            projectile.draw(board);
        }
        
        for (Collectable collectable : collectables) {
            collectable.draw(board);
        }

        return board;
		
	}
	
	//Lily
	public void print() {
        draw();		//why does this and run call draw?
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
	
	//Lily
	public String getInput() {
		Scanner in = new Scanner(System.in);
		String com = in.nextLine().toUpperCase();
        return com;
	}
	
	//Matt
	public void move(String s) {
		
		for(int i = 0; i < enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			enemy.move();	
		}
		for(int i = 0; i < projectiles.size(); i++) {
			Projectile projectile = projectiles.get(i);
			projectile.move(); 
		}
		
		for(int i = 0; i < collectables.size(); i++) {
			Collectable collectable = collectables.get(i);
			collectable.move(board);
		}
		
		player.move(s);
	}
	
    public void clearBoard() {
        board = new String[ROWS][COLUMNS];
        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLUMNS; col++) {
                board[row][col] = "-";
            }
        }
    }
    
	//Matt
	public String[][] initBoard(){
        clearBoard();
		for(int i = 0; i < ROWS-6; i++) {
			Enemy enemy = new Enemy(i);
			enemies.add(enemy);
		}
		
		return board;
	}

}
