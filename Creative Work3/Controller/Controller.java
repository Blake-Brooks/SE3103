package Controller;
import View.GamePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import Model.Rectangle;

import java.awt.Color;


public class Controller implements ActionListener{
    private GamePanel gammingPanel;

    public Controller(GamePanel gammingPanel){
        this.gammingPanel = gammingPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if(button == gammingPanel.getStartButton()){     
            gammingPanel.setGameState(GamePanel.GameState.PLAYING);
            Rectangle playerObject = gammingPanel.getGameCanvas().getRect();
            gammingPanel.getGameCanvas().repaint();
        } 
    }
}
