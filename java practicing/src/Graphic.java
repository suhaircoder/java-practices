import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Graphic implements ActionListener{
        JFrame frame = new JFrame();
        JButton button;

        public static void main(String[] args) {
            Graphic graphic = new Graphic();
            graphic.go();
        }
        public void go(){

                JButton button = new JButton("Change colors");
                button.addActionListener(this);
                MyDrawPanel drawPanel = new MyDrawPanel();

            frame.getContentPane().add(BorderLayout.SOUTH, button);
            frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

                frame.setSize(400, 400);
                frame.setVisible(true);
            }


    @Override
    public void actionPerformed(ActionEvent event) {
        frame.repaint();
    }
    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
           // Image image = new ImageIcon("\"C:\\Users\\suhai\\OneDrive\\Desktop\\my flash\\Adobe Photoshop CC Course - كورس فوتوشوب كامل\\bird.png\"").getImage();
          //  g.drawImage(image,3,4,this);
            GradientPaint gradient = new GradientPaint(70,70,Color.blue, 150,150, Color.orange);

            g2d.setPaint(gradient);
            g2d.fillOval(70,70,100,100);
        }
}}

