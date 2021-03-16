package View;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.EnemyObject;
import Model.Rectangle;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;

public class Game extends JPanel{
    private GamePanel panel;
    private Rectangle rect = new Rectangle(100, 100, Color.blue, 50, 50);
    private EnemyObject circ = new EnemyObject(0, 0, Color.red, 5);
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
        if(state==GamePanel.GameState.READY){
            g2.setColor(Color.blue);
            g2.setFont(new Font("Times New Roman", Font.BOLD, 30));
            g2.drawString("Click Start to Begin", 70, 150);
        } else{
            if(state == GamePanel.GameState.GAMEOVER){
                g2.setColor(Color.red);
                g2.setFont(new Font("Times New Roman", Font.BOLD, 30));
                g2.drawString("Game over", 150, 160);
            }
            //getRect();
            panel.getGameCanvas().getRect().render(g2);
            panel.getGameCanvas().repaint();
            panel.getGameCanvas().getCirc().render(g2);
            panel.getGameCanvas().repaint();
        }
    }

    public Rectangle getRect(){
        return rect;
    }

    public EnemyObject getCirc(){
        return circ;
    }

    public void repaint(Rectangle playerObject) {
    }
}
