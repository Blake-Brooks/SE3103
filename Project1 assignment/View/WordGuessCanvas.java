package View;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class WordGuessCanvas extends JPanel{
private WordGuessPanel panel;
public static int width = 500;
public static int height = 500;
private int HealthLevel;

public WordGuessCanvas(WordGuessPanel panel) {
    this.panel = panel;
    setPreferredSize(new Dimension(width, height));
    setBackground(Color.white);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        WordGuessPanel.GameState state = panel.getGameState();
        if(state == WordGuessPanel.GameState.READY){
            g2.setColor(Color.blue);
            g2.setFont(new Font("Courier", Font.BOLD, 40));
            g2.drawString("Press <New> to Start", 70, 150);
        } else{
            if(state == WordGuessPanel.GameState.GAMEOVER){
                g2.setColor(Color.red);
                g2.setFont(new Font("Courier", Font.BOLD, 40));
                g2.drawString("You Lost !!!", 70, 150);
                g2.setColor(Color.blue);
                g2.drawString("Press <New> to Start", 70, 150);
            }
            g2.drawString("Health Level " + HealthLevel, 20, 100);
            for(int i = 0; i < 5; i++){
                if(i < HealthLevel)
                g2.fillRect(i * 140 + 100, 80, 50, 50);
                else
                g2.drawRect(i * 140 + 100, 80, 50, 50);
            }
        }
    }
    public void setHealthLevel(int HealthLevel){
        this.HealthLevel = HealthLevel;
    }
}
