package View;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;

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

        
        Graphics2D g2 = (Graphics2D) g;
        GamePanel.GameState state = panel.getGameState();
        if(state==GamePanel.GameState.PLAYING){
            g2.setColor(Color.blue);
            g2.setFont(new Font("Times New Roman", Font.BOLD, 30));
            g2.drawString("Click Start to Begin", 70, 150);
        } else{
            if(state == GamePanel.GameState.GAMEOVER){
                g2.setColor(Color.red);
                g2.setFont(new Font("Times New Roman", Font.BOLD, 30));
                g2.drawString("Game over", 150, 160);
            }
            g2.drawRect(x, y, width, height);
        }
    }
}
