package View;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Game extends JPanel{
    private GamePanel panel;
    public Game(GamePanel panel){
        this.panel = panel;
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.black);
    }

    @Override 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
