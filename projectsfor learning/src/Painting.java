import javax.swing.*;
import  java.awt.*;
public class Painting {
    int x=60;
    int y=80;
    public static void main (String[] args) {
       Painting gui = new Painting ();
        gui.go();
    }
    public void go(){
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrawPanel myDrawPanel=new MyDrawPanel();
        frame.getContentPane().add(myDrawPanel);
        frame.setSize(300,300);
        frame.setVisible(true);
        for( int i=0 ;i<140 ; i++){
            x++;
            y++;
            myDrawPanel.repaint();
            try {
                Thread.sleep(10);
            } catch(Exception ex) { }

        }
    }
     class MyDrawPanel extends  JPanel{
         public void paintComponent(Graphics g) {
             g.setColor(Color.white);
             g.fillRect(0,0,this.getWidth(), this.getHeight());
             g.setColor(Color.green);
             g.fillOval(x,y,40,40);
         }
     }
}
