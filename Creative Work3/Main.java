import javax.swing.JFrame;
import View.GamePanel;
public class Main{
    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(500,100);
        var screen = new GamePanel(window);
        screen.init();
        window.pack();
        window.setVisible(true);
    }
}