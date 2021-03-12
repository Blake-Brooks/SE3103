package Controller;
import Model.Spaceship;
import View.Game;
import View.GamePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller implements ActionListener{
    private Spaceship spaceship; 
    private GamePanel gammingPanel;
    public Controller(GamePanel gammingPanel){
        this.gammingPanel = gammingPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        button = gammingPanel.getFireButton();
    }
}
