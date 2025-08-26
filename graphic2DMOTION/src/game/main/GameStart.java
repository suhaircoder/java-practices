package game.main;
import game.core.MovingObjectsGame;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameStart{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Moving Balls Game");
            MovingObjectsGame game = new MovingObjectsGame();
            frame.add(game);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocation(0,0);  // Center on screen
            frame.setVisible(true);
        });
    }
}
