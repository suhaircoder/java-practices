package game.utils;

import java.awt.Color;

public class GameConstants {
    // Window settings
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 600;
    public static final Color BACKGROUND_COLOR = Color.BLACK;

    // Ball settings
    public static final int PLAYER_SPEED = 5;
    public static final int MIN_BALL_SIZE = 30;
    public static final int MAX_BALL_SIZE = 50;

    // Animation settings
    public static final int FRAME_DELAY = 15;

    // Initial ball positions and speeds
    public static final int[][] PASSIVE_BALLS = {
            // x, y, size, dx, dy
            {100, 100, 40, 3, 2},  // Fast ball
            {300, 200, 50, 1, 1},  // Slow ball
            {500, 300, 45, 2, 3}   // Medium ball
    };
}