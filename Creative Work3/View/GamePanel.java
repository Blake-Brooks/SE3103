package View;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class GamePanel {
    private JFrame window;
    private Game gameCanvas; 
    private JButton fireBtton = new JButton("Fire");
    private JButton startButton = new JButton("Start");
    public GamePanel(JFrame window){
        this.window = window; 
    }

    public void init(){
        Container cp = window.getContentPane();
        JPanel southPanel = new JPanel();
        southPanel.add(startButton);
        southPanel.add(fireBtton);
        cp.add(BorderLayout.SOUTH, southPanel);
        gameCanvas = new Game(this);
        cp.add(BorderLayout.CENTER, gameCanvas);
    }

    public JButton getFireButton(){
        return fireBtton;
    }

    public JFrame getWindow(){
        return window;
    }

    public Game getGameCanvas(){
        return gameCanvas;
    }
}
