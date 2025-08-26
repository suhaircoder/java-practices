package game.objects;
import game.utils.GameConstants;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball implements Runnable {
    public int x, y;
    public int size;
    public int dx, dy;
    private Color color;
    private final boolean isActive;
    private boolean running;
    private final Random random;

    public Ball(int x, int y, int size, int dx, int dy, boolean isActive) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.dx = dx;
        this.dy = dy;
        this.isActive = isActive;
        this.running = true;
        this.random = new Random();
        this.color = getRandomColor();
    }

    public void run() {
        while (running) {
            if (!isActive) {
                move();
            }
            try {
                Thread.sleep(GameConstants.FRAME_DELAY);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void move() {
        x += dx;
        y += dy;

        if (x <= 0 || x + size >= GameConstants.WINDOW_WIDTH) {
            dx = -dx;
           changeAppearance();
        }
        if (y <= 0 || y + size >= GameConstants.WINDOW_HEIGHT) {
            dy = -dy;
            changeAppearance();
        }
    }

    public void reverseDirection() {
        dx = -dx;
        dy = -dy;
       changeAppearance();
    }

    public boolean intersects(Ball other) {
        int centerDx = (this.x + this.size/2) - (other.x + other.size/2);
        int centerDy = (this.y + this.size/2) - (other.y + other.size/2);
        int distance = centerDx * centerDx + centerDy * centerDy;
        int radiusSum = (this.size/2 + other.size/2);
        return distance <= radiusSum * radiusSum;
    }

   public void draw(Graphics g) {
        g.setColor(color);
       g.fillOval(x, y, size, size);
    }
//change appearance
    private void changeAppearance() {
        this.color = getRandomColor();
        this.size = random.nextInt(GameConstants.MAX_BALL_SIZE - GameConstants.MIN_BALL_SIZE)
                + GameConstants.MIN_BALL_SIZE;
    }
//  color  ball
    private Color getRandomColor() {
        return new Color(
                   random.nextInt(256),
                   random.nextInt(256),
                   random.nextInt(256));
    }

    public void stop() {
        running = false;
    }
}