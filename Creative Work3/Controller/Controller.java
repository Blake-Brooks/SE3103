package Controller;
import View.GamePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import Model.Rectangle;

public class Controller implements ActionListener{
    private GamePanel gammingPanel;
    public Controller(GamePanel gammingPanel){
        this.gammingPanel = gammingPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if(button == gammingPanel.getStartButton()){
            gammingPanel.getFireButton().setEnabled(true);      
            gammingPanel.setGameState(GamePanel.GameState.PLAYING);
            
        } else if(button == gammingPanel.getFireButton()){

        }

    
    }
}
