import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.Dimension;

public class Main{
    private JFrame window; 

    public Main(JFrame window){
        this.window = window;
        window.setTitle("Battle Screen");
    }

    public void initiate(){
        Container cp = window.getContentPane();
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500,100));

        JButton attack = new JButton("Attack");
        panel.add(attack);
    }
}