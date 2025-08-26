package game.core;
import game.objects.Ball;
import game.utils.GameConstants;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MovingObjectsGame extends JPanel implements KeyListener, MouseMotionListener {
    private final Ball activeBall;
    private final List<Ball> passiveBalls;

    public MovingObjectsGame() {
        this.setPreferredSize(new Dimension(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT));
        this.setBackground(GameConstants.BACKGROUND_COLOR);
        this.setFocusable(true);
        this.addKeyListener(this);
        this.addMouseMotionListener(this);

        // Create active ball
        activeBall = new Ball(
                GameConstants.WINDOW_WIDTH/2,
                GameConstants.WINDOW_HEIGHT/2,
                GameConstants.MIN_BALL_SIZE,
                0, 0, true);

        passiveBalls = new ArrayList<>();

        // Create passive balls
        for (int[] ballData : GameConstants.PASSIVE_BALLS) {
            createPassiveBall(ballData[0], ballData[1], ballData[2], ballData[3], ballData[4]);
        }

        // Start game loop
        new Thread(this::gameLoop).start();
    }

    private void createPassiveBall(int x, int y, int size, int dx, int dy) {
        Ball ball = new Ball(x, y, size, dx, dy, false);
        passiveBalls.add(ball);
        Thread thread = new Thread(ball);
        thread.start();
    }

    private void gameLoop() {
        while (true) {
            // Check collisions
            for (Ball ball : passiveBalls) {
                if (activeBall.intersects(ball)) {
                    ball.reverseDirection();
                    activeBall.reverseDirection();
                }
            }
            repaint();
            try {
                Thread.sleep(GameConstants.FRAME_DELAY);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        activeBall.draw(g);
        for (Ball ball : passiveBalls) {
            ball.draw(g);
        }
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> activeBall.dy = -GameConstants.PLAYER_SPEED;
            case KeyEvent.VK_S -> activeBall.dy = GameConstants.PLAYER_SPEED;
            case KeyEvent.VK_A -> activeBall.dx = -GameConstants.PLAYER_SPEED;
            case KeyEvent.VK_D -> activeBall.dx = GameConstants.PLAYER_SPEED;
        }
    }


    public void keyReleased(KeyEvent e) {
        activeBall.dx = 0;
        activeBall.dy = 0;
    }

    public void keyTyped(KeyEvent e) {}

    public void mouseMoved(MouseEvent e) {
        activeBall.x = e.getX();
        activeBall.y = e.getY();
        repaint();
    }

    public void mouseDragged(MouseEvent e) {}
}