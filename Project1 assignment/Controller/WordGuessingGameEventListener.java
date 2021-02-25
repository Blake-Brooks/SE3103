package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import View.WordGuessPanel;

public class WordGuessingGameEventListener implements ActionListener {
    private WordGuessPanel panel;
    public WordGuessingGameEventListener(WordGuessPanel panel){
        this.panel = panel;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == panel.getNewButton()){
            
        }
    }
}
