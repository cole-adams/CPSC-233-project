package ca.ucalgary.main;

public class EnemyProjectile extends Projectile {
    
    private int velocity;
    private boolean collided;
    private boolean edgy;
    private String symbol = "*";
    
//    // Main constructor
    public EnemyProjectile (int x, int y) {
        super(x, y);
        this.velocity = 0;
    }
//
//    // Constructor with velocity parameter
    public EnemyProjectile(int x, int y, int velocity) {
        super(x, y, velocity);
    }
    
    public boolean collidedWith(Player player) {
        collided = ((this.y == player.getY() || this.y == player.getY() - 1)
                    && this.x == player.getX());
        return collided;
        
    }
    /**
     * Moves the projectile down one row and detects whether or not it has reached
     * the edge of the board.
     * @return edgy returns true if the projectile has reached the edge of the board.
     */
    @Override
    public boolean move() {
        if (collided) {
            edgy = true;
        }
        if (this.y == TextGame.ROWS - 1) {
            edgy = true;
        } else {
            edgy = false;
            this.y = this.y + 1;
        }
        return edgy;
    }
    @Override
    public void draw(String[][] board) {
        board[y][x] = "*";
    }
    @Override
    public void draw(Board board) {
        board.draw(symbol, x, y);
    }



    
}