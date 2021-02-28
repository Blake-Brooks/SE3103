package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.WordGuess;
import javax.swing.JFrame;

import Model.WordGuess;
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
            var wordGuess = new WordGuess();
            for(var b: panel.getLetterButtons()){
                b.setEnabled(true);
            }
        } else {
            
        }
    }
}
