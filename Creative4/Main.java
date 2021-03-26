import javax.swing.JFrame;
import view.ShapeMovingPanel;

public class Main {
    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(500, 120);
        var screen = new ShapeMovingPanel(window);
        screen.init();
        window.pack();
        window.setVisible(true);
    }
}