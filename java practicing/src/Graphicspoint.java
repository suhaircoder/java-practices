import javax.swing.*;
import java.awt.*;

public class Graphicspoint extends JPanel {


    public static void main(String[] args){
     Graphicspoint graphicspoint=new Graphicspoint();

    }
    public void paintComponent(Graphics g) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
        g.fillOval(70,70,100,100);
        g.setColor(Color.orange);
        g.fillRect(20, 50, 100, 100);
    }
}
