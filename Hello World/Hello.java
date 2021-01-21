import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Container;


public class Hello{
    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setSize(400, 400);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = window.getContentPane();
        JPanel panel = new JPanel();
        panel.add(new JTextField("Hello Wrold"));
        panel.add(new JButton("Click on me."));
        panel.add(new JButton("Sign up"));
        panel.add(new JTextField("Java World"));
        cp.add(panel);

        window.pack();
        window.setVisible(true);
    }
}